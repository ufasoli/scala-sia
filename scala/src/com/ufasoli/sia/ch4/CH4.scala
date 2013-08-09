import com.ufasoli.sia.ch4.{Collections, Nill, Maybe, Just}

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



    val col = new Collections
    col.collections()
    col.javaWrapper()
    col.iterable()
    // will create a new list with every character of the strings
    //will print : List[Char] = List(o, n, e, t, w, o, t, h, r, e, e)
    println(List("one", "two", "three", "") flatMap {
      _.toList
    })

    // will create a list of lists
    //  List[List[Char]] = List(List(o, n, e), List(t, w, o), List(t, h, r, e, e), List())
    println(List("one", "two", "three", "") map {
      _.toList
    })


    //Using custom flatMap implementation
    println("CUSTOM FLATMAP : " + flatMap(List("one", "two", "three")) {
      _.toList
    })
    folds()
    customFunctionObjects()
    // will throw exception
    //    println(position2(List(), "a").get)
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

    println("Map Recursive :" + mapRecursive(List(1, 2, 3), addOne))
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

  def mapForComprehension[A, B](f: A => B, xs: List[A]): List[B] = for (x <- xs) yield f(x)


  //example of flatMap implementation
  def flatten[B](xss: List[List[B]]): List[B] = {
    xss match {
      case List() => Nil
      // ::: --> appends the content of a List to another
      case head :: tail => head ::: flatten(tail)
    }
  }

  // this function is declared with 2 sets of params (currying)
  def flatMap[A, B](xs: List[A])(f: A => List[B]): List[B] = {
    flatten(mapRecursive(xs, f))
  }


  // A lambda is an anonymous function a function without a name. You’ve already seen
  //some examples of it. Closure is any function that closes over the environment in
  //which it’s defined.
  def closuresAndLambdas() {

    // lambda
    List(100, 200, 300) map {
      _ * 10 / 100
    }

    //closure( uses variables from it's environment (percentage))
    var percentage = 10
    val applyPercentage = (amount: Int) => amount * percentage / 100
    percentage = 20
    List(100, 200, 300) map applyPercentage
  }

  //Reimplementing flattmap without recursion
  //  The downside of using a recursive solution is that it can throw a stack overflow
  //  error on large datasets. An alternative is to implement the function using tail recursion
  //    so that the Scala compiler could do tail call optimization and transform the
  //    recursion into a loop. In tail recursion you perform your calculation first and then
  //    execute the recursive call by passing the result of the current step to the next step.
  //  Here’s the implementation of the flatten function using tail recursion.

  //  In this case the flatten function is implemented using a nested function that uses the
  //    tail recursion pattern. The result of newList ::: head is passed as a parameter to the
  //  function so that the Scala compiler can optimize it. You’ll learn more about tail call
  //    recursion in the next chapter. In the next section you’ll explore another new concept
  //  called fold that allows you to process a data structure in some order and build a return
  //  value.
  def flatten3[B](xss: List[List[B]]): List[B] = {
    def _flatten3(oldList: List[List[B]], newList: List[B]): List[B] = {
      oldList match {
        case List() => newList
        case head :: tail => _flatten3(tail, newList ::: head)
      }

    }
    _flatten3(xss, Nil)
  }

  def folds(){
    // using foldLeft to calculate the sum of a list
    println("Calculating sum of list List(1,2,3,4) : " +List(1,2,3,4).foldLeft(0) { _ + _})
    // alternative syntax for calculating sum of list
    println("Alternative Calculating sum of list List(1,2,3,4) : " +List(1,2,3,4).foldLeft(0) {
        (a,b) => println("a:"+ a + "b:"+b);   a +b})

    println("Calculating length of list List(1,2,3,4) : " +List(1,2,3,4).foldLeft(0) { (a,b) => println("a:" + a +"b :"+ b ); a+1})


    // checking where an element exists

    def exists[A](xs:List[A], e:A) = xs.foldLeft(false)((a,x) => a || x==e)

    println("Checking if 3 exists in List : "  + exists(List(1,2,3), 3))

//    def foldLeft[B](z: B)(f: (B, A) => B): B
//    def foldRight[B](z: B)(f: (A, B) => B): B


  }

  def customFunctionObjects(){

    object folddl{
      // note when an operator ends with ':' here '/:' right associativeness is used (
      def apply[A,B](xs:Traversable[A], defaultValue: B)(op: (B,A) => B)=(defaultValue /: xs)(op)
    }



    println(folddl(List("1","2","3"), "0") {_+_})
    println(folddl(IndexedSeq("1","2","3"), "0") {_+_})
    println(folddl(Set("1","2","3"), "0") {_+_})


    // THE ++ exercise

    // it's a good practice to extend the FunctionN when creating a function object
    object ++ extends Function1[Int, Int]{
      def apply(p:Int):Int = p+1
    }

    println(mapForComprehension(++, List(10,20,30)))

    println(mapForComprehension((x:Int) => x+1, List(10,20,30) ))

    println(mapForComprehension(new Function1[Int,Int]{ def apply(p:Int)={p+1}}, List(10,20,30) ))
  }


  def functionComposition(){

    // combining functions
    val addOne :Int => Int = x => x+1
    val addTwo:Int => Int = x => x +2

    // combining the 2 functions to obtain 1 function
    // equivalent of val addThree : Int => Int = x => addOne(addTwo(x))
    val addThree = addOne compose addTwo

    print(addThree(3))
  }
}

