/**
 *
 * User: ufasoli
 * Date: 06/07/13
 * Time: 15:49
 * Project : scala-sia
 */


object TuplesAndMaps{
  def main(args: Array[String]) {


//    Tuple is immutable like List, but unlike List it can contain different types of elements;
//    in this cas, it contains a String and a List. Scala provides syntax sugar
//    for creating a Tuple by wrapping elements with parentheses ():
    val tuple2  = Tuple2("1", List(1))
    val tuple3 = Tuple3("1",  List(1), 5)



//    A Map is an immutable collection of keys and values.
//    When you pass a tuple of two elements to Map, it takes the first element of the tuple as the key and the second element as the value:
    val m =  Map(("1", "a"), ("2", "b"))
  }
}
