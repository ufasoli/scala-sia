/**
 *
 * User: ufasoli
 * Date: 05/07/13
 * Time: 13:19
 * project : scala
 */

object PatternMatching {
  def main(args: Array[String]) {


    ordinal(11)
    printType("hello world")
    printType( List(1,2,3))
    printType(Array[Int](3,4,5))
    printType(new java.util.Date())

    // will print the first 2 items of the list
    infix(List(1,2,3,4)).foreach(println)


    //ordinal reimplemented
    val suffixes = List("th", "st", "nd", "rd", "th", "th", "th", "th", "th",
      "th")
    println(newOrdinal(501, suffixes))

  }


  def ordinal(number: Int) {
    number match {
      // no need for a break statement since you will not overflow into the next cases
      case 1 => println("1st")
      case 2 => println("2nd")
      case 3 => println("3rd")
      case 4 => println("4th")
      case 5 => println("5th")
      case 6 => println("6th")
      case 7 => println("7th")
      case 8 => println("8th")
      case 9 => println("9th")
      case 10 => println("10th")
      case _ => println("needs to be between 1 & 10")

    }
  }

  def printType(obj: AnyRef) {
    obj match {
      case s: String => println(s"[$obj] is a string")
      case l: List[_] => println(s"[$obj] is a list")
      case a: Array[_] => println(s"[$obj] is an array")
      case d: java.util.Date => println(s"[$obj] is a java date")
    }
  }

  /**
   * Extract the first and second elements of the list
   * @param list
   * @return
   */
  def infix(list:List[_]):List[_] ={

    list match{
      case f :: s :: rest => List(f,s)
      case _ => Nil
    }
  }

  def rangeMatcher(num:Int) = num match{
    case within10  if within10 <= 10 => println("within 0 and 10")
    case within100 if within100 <= 100 =>  println("within 11 and 100")
    case beyond100 if beyond100 < Integer.MAX_VALUE => println("beyond 100")
  }


  def newOrdinal(number:Int, suffixes: List[String]) = number match{
     //syntax sugar 10 to 20 ==> same as 10.to(20)
    case tenTo20  if 10 to 20 contains tenTo20 => number + "th"
    case rest => rest + suffixes(number % 10)
  }

  def withinRange(n:Int) = n match{

    case under10 if 0 to 10 contains n => println(s"[$n] is between 0 and 10")
    case under20 if n <= 20  => println(s"[$n] is between 11 and 20")
    case whatever => println(s"[$whatever] is over 20") // here we are not using the value of n
  }



}
