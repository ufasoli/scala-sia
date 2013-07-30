import com.ufasoli.sia.ch4.{Nill, Maybe, Just}

/**
 *
 * User: ufasoli
 * Date: 30/07/13
 * Time: 13:29
 * project : scala-sia
 */

object CH4 {
  def main(args: Array[String]) {

    val xs = List("one", "two", "three")
    println(position(xs, "three"))
    println(position(xs, "four"))
    val pos = position2(xs, "two")

    println(pos.get)

    // in scala an immutable List is covariant in its type parameter
    val everything: List[Any] = List("one", "two", "three")



    // Mutable objects need to be invariant

    println("Get Or ELSE : " + position2(List(), "b").getOrElse("A"))



    higherOrderFunctions()


    // will throw exception
    println(position2(List(), "a").get)
  }


  def position[A](xs: List[A], value: A): Int = {
    xs.indexOf(value)
  }

  def position2[A](xs: List[A], value: A): Maybe[Int] = {

    val index = xs.indexOf(value)
    if (index != -1) Just(index) else Nill
  }


  def higherOrderFunctions() {

    // using an anonymous function
    val myList = List(1, 2, 3) map {
      (x: Int) => x + 1
    }
    println(myList)

    // using a function literal (when using placeholder '_')
    val myList2 = List(1, 2, 3) map {
      _ + 1
    }
    println(myList2)
    // passing an existing function
    val myList3 = List(1, 2, 3) map addOne
    println(myList3)

    // passing an existing function that returns a function
    val myList4 = List(1, 2, 3) map addOneF
    println(myList4)

    println("Map Recursive :" + mapRecursive(List(1,2,3), addOne))
  }

  def addOne(num: Int) = num + 1

  //function returning another function
  def addOneF(num: Int) = {

    def ++ = (x: Int) => x + 1

    ++(num)
  }

  def mapRecursive[A, B](xs: List[A], f: A => B): List[B] = {

    xs match {
      case List() => Nil
      // head --> firstElement of List
      // tail --> rest of the list
      // using :: we append the result of the f function recursively
      case head :: tail => f(head) :: mapRecursive(tail, f)

      //If you try the map function with List(1, 2, 3) and the addOne function as parameters,
      //the execution steps look like this:
      //
      //  case 1 :: List(2, 3) => addOne(1) :: mapRecursive(List(2, 3), addOne)
      //  case 2 :: List(3) => 2 :: addOne(2) :: mapRecursive(List(3), addOne)
      //  case 3 :: List() => 2 :: 3 :: addOne(3) :: mapRecursive(List(), addOne
      //At this point the empty list will match the first case, and the final expression will look
      //like this:
      //  2 :: 3 :: 4 :: Nil


      //How does head :: tail work?
      //This pattern is called the Infix Operation pattern, where the expression head :: tail
      //is shorthand for the constructor pattern ::(head, tail). The immutable List in
      //Scala is defined as an abstract sealed class, and its only two subclasses are Nil
      //and ::. Both are case classes. As you already know, one of the biggest benefits of
      //Scala case classes is that they can participate in pattern matching. So ::(head,
      //tail) matches the constructor of the :: case class that takes head as the first element
      //and the list as the second element, which in this case is tail


    }
  }

  def mapForComprehension[A,B](f: A => B, xs:List[A]) : List[B] = for(x <- xs ) yield f(x)
}

