/**
 *
 * User: ufasoli
 * Date: 05/07/13
 * Time: 16:42
 * project : scala-sia
 */

import org.apache.http._
import org.apache.http.client.entity._
import org.apache.http.client.methods._
import org.apache.http.impl.client._
import org.apache.http.client.utils._
import org.apache.http.message._
import org.apache.http.params._

object HttpClient {




  def main(args: Array[String]) {

    require(args.size >= 2, "at minimum you should specify action (post, get,delete,options) and url")

    val command = args.head
    val params = parseArgs(args)
    val url = args.last

    // i => println(i + " : " + params(i) is an anonymous function taking 1 parameter i
    // it will be equivalent to define def myFunc(i:Int){i + " : " + params(i)}
    params.keys.foreach((i: String) => println(i + " : " + params(i)))


    command match {
      case "get" => handleGetRequest(params, url)
      case "post" => handlePostRequest(params, url)
      case "delete" => handleDeleteRequest(params, url)
      case "options" => handleOptionsRequest(params, url)
      case "put" => handlePutRequest(params,url)
    }

  }

  def handleGetRequest(params: Map[String, List[String]], url: String) {

    // create a query uri from the params
    val queryParams = params.get("-d").get.mkString("&")
    val httpGet = new HttpGet(s"$url?$queryParams")

    headers(params.get("-h").get).foreach(httpGet.addHeader(_))
    println(httpGet.getURI)
    val responseBody = new DefaultHttpClient().execute(httpGet, new BasicResponseHandler())
    println(responseBody)

  }

  def handlePostRequest(params: Map[String, List[String]], url: String) {

    val httpPost = new HttpPost(url)
    headers(params.get("-h").get).foreach {
      httpPost.addHeader(_)
    }
    httpPost.setEntity(formEntity(params))

    val responseBody = new DefaultHttpClient().execute(httpPost, new BasicResponseHandler())

    println(responseBody)
  }

  def handleDeleteRequest(params: Map[String, List[String]], url: String) {

    val httpDelete = new HttpDelete(url)
    headers(params.get("-h").get).foreach {
      httpDelete.addHeader(_)
    }
    val responseBody = new DefaultHttpClient().execute(httpDelete, new BasicResponseHandler())
    println(responseBody)
  }

  def handleOptionsRequest(params: Map[String, List[String]], url: String) {

    val httpOptions = new HttpOptions(url)
    headers(params.get("-h").get).foreach {
      httpOptions.addHeader(_)
    }
    val httpResponse = new DefaultHttpClient().execute(httpOptions, new BasicResponseHandler())
    println(httpResponse)
  }


  def handlePutRequest(params: Map[String, List[String]], url: String) {

    val httpPut = new HttpPut(url)
    headers(params.get("-h").get).foreach {httpPut.addHeader(_)}
    httpPut.setEntity(formEntity(params))

    val httpResponse = new DefaultHttpClient().execute(httpPut, new BasicResponseHandler())

    println(httpResponse)
  }


  def formEntity(params: Map[String, List[String]]): UrlEncodedFormEntity = {

    def toJavaList(scalaList: List[BasicNameValuePair]) = {
      //The special :_* tells the Scala compiler to send the result of toArray as a variable argument to the
      //Arrays.asList method; otherwise, asList will create a Java List with one element.
      java.util.Arrays.asList(scalaList.toArray: _*)
    }
    def formParams = for (nameValue <- params("-d")) yield {
      def tokens = splitByEqual(nameValue)
      new BasicNameValuePair(tokens(0), tokens(1))
    }

    new UrlEncodedFormEntity(toJavaList(formParams), "UTF-8")

  }

  def headers(headers: List[String]): List[BasicHeader] = {
    for (nameValue <- headers) yield {
      def tokens = splitByEqual(nameValue)
      new BasicHeader(tokens(0), tokens(1))
    }
  }

  def splitByEqual(nameValue: String): Array[String] = nameValue.split('=')

  def parseArgs(args: Array[String]): Map[String, List[String]] = {

    //the nested function nameValuePair takes the parameter name, –d or –h,
    // and creates a list of name-value pairs of request or header parameters.
    // The return type is a scala.Tuple2, a tuple  of two elements.
    // Tuple is immutable like List, but unlike List it can contain different types of elements;
    // in this case, it contains a String and a List.
    // Scala provides syntax sugar for creating a Tuple by wrapping elements with parentheses ():
    // eg :
    // val tuple2 = ("list of one element", List(1)) => tuple2: (java.lang.String, List[Int]) = (list of one element,List(1))
    def nameValuePair(paramName: String) = {
      def values(comaSeparatedValues: String) = comaSeparatedValues.split(",").toList


      // get the index for the current param
      val index = args.indexOf(paramName)
      // return Nil if the param is not found otherwise return the param value
      (paramName, if (index == -1) Nil else values(args(index + 1)))


    }
    // create an associative Map with the -d and -h params


    //A Map is an immutable collection of keys and values.
    // In this example you’re creating a Map of parameter name(-d or –h) and listing all the parameters as values.
    // When you pass a tuple of two elements to Map, it takes the first element of the tuple as
    // the key and the second element as the value:
    Map(nameValuePair("-d"), nameValuePair("-h"))
  }
}

