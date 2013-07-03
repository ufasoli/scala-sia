/**
 *
 * User: ufasoli
 * Date: 03/07/13
 * Time: 17:31
 * project : scala
 */

object ArraysAndList{

  def main(args: Array[String]) {
  val array = new Array[String](3)
  array(0) ="This"
  array(1) ="is"
  array(2) ="mutable"

  array.foreach(println)

    val myList = List("This", "is", "immutable")

    myList.foreach(println)

  }
}
