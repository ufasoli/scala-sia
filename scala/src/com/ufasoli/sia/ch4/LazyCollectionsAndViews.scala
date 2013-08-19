package com.ufasoli.sia.ch4

import scala.io._
import scala.xml.XML

/**
 *
 * User: ufasoli
 * Date: 19/08/13
 * Time: 16:52
 * project : scala-sia
 */
class LazyCollectionsAndViews {


  def strictCollections(){
    println("**************")
    println("strictCollections")
    println("**************")

    println("The following collection List(1,2,3,4,5) will be evaluated eagerly : "+ List(1,2,3,4,5).map(_+1).head)


    println("**************")
    println("end strictCollections")
    println("**************")
  }

  def nonStrictOrLazyWithViews(){

    println("**************")
    println("nonStrictOrLazyWithViews")
    println("**************")

    val list =  List(1, 2, 3, 4, 5)
   println("This time the call to map will produce a view without calculating all the elements : " + list.view.map( _ + 1).head)


    //  Another interesting way to look at  laziness is how sometimes you can avoid errors with lazy processing


      //The following example processes elements of List by using each element as a divisor of 2. But one
  //    of the elements will result in a divide-by-zero error:

    try{
      def strictProcessing =  List(-2,-1,0,1,2) map { _ / 2}

    println(strictProcessing(0))
      //Even though you’re interested in only the first element of the list, the entire collection
      //   is processed, causing the exception for the third element

    }
    catch {
      case e:Exception=> print(e)
    }


    def nonStricProcessing  = List(-2,-1,0,1,2).view map { _ / 2}


    nonStricProcessing(0)


    println("Forcing strict processing on a view")

    try{
      println("Forcing strict processing on a view" + List(-2,-1,0,1,2).view.force map { _ / 2} )
    }
    catch {
      case ex: Exception => println(ex)
    }
      println("**************")
      println("end nonStrictOrLazyWithViews")
      println("**************")

  }

  def loadTweets(){

    // tweets are loaded eagerly (time consuming)
    val allTweetsEagerly = Map("nraychaudhuri" -> tweets("nraychaudhuri"),
      "ManningBooks" -> tweets("ManningBooks"),
      "bubbl_scala" -> tweets("bubbl_scala")
    )

    // 2 step lazy load tweets
    // first create a map with partial function (no args given)
    val allTweetsLazily = Map("nraychaudhuri" -> tweets _ ,
      "ManningBooks" -> tweets _ ,
      "bubbl_scala" -> tweets _
    )


    allTweetsLazily.view.map { t => t._2(t._1).head}

    for(t <- allTweetsLazily; if t._1 == "ManningBooks") t._2(t._1)
  }

  def tweets(handle:String)= {
    println("processing tweets for : " + handle)

    // get the XML result
    val source = Source.fromURL(new java.net.URL("http://search.twitter.com/search.atom?q=" + handle))

    val iterator = source.getLines()
    val builder = new StringBuilder
    for(line <- iterator) builder.append(line)

    // load string and convert into XML
    XML.loadString(builder.toString)





  }
}
