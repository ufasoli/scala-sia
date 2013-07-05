/**
 *
 * User: ufasoli
 * Date: 05/07/13
 * Time: 16:42
 * project : scala-sia
 */

object HttpClient{
  def main(args: Array[String]) {

    require(args.size >= 2, "at minimum you should specify action (post, get,delete,options) and url")

    val command = args.head
    val params = parseArgs(args)
    val url = args.last

    // i => println(i + " : " + params(i) is an anonymous function taking 1 parameter i
    // it will be equivalent to define def myFunc(i:Int){i + " : " + params(i)}
    params.keys.foreach((i:String) => println(i + " : " + params(i)))


  }

  def parseArgs(args: Array[String]): Map[String, List[String]] = {

      def nameValuePair(paramName: String)= {
        def values(comaSeparatedValues: String)= comaSeparatedValues.split(",").toList


        val index = args.indexOf(paramName)
        (paramName, if(index == -1) Nil else values(args(index + 1)))


      }
    Map(nameValuePair("-d"), nameValuePair("-h"))
  }
}

