package com.ufasoli.sia.ch4

import java.util.{Collection => JCollection, ArrayList}
import java.util
import scala.collection.mutable.ListBuffer
import scala.collection.SortedSet
import scala.collection.immutable.Map



/**
 *
 * User: ufasoli
 * Date: 06/08/13
 * Time: 17:03
 * project : scala-sia
 */
class Collections {

  def collections(){
    val mapping : collection.Map[String, String] = Map("Ron" -> "admin", "Sam" -> "analyst")
    val mutableMapping: collection.mutable.Map[String, String]= collection.mutable.Map("Ron" -> "admin", "Sam" -> "analyst")
    mutableMapping + "a" -> "b"
    println(mutableMapping)
  }


  def javaWrapper(){

    val jCol = new util.ArrayList[Int]
    (1 to 5) foreach {jCol.add(_)}

    val scalaCol = new JavaToTraversable[Int](jCol)
    println("JavaToTraversable : " + scalaCol)

  }


  def iterable(){

    println("dropRight 2 on Iterable(1,2,3,4,5) : " + (Iterable(1,2,3,4,5)  dropRight 2 ))
    println("takeRight 2 on Iterable(1,2,3,4,5) : " + (Iterable(1,2,3,4,5)  takeRight  2) )
  }

  def partialFunctionWithDefaultUsingComposition(){

    println("********************************")
    println("Doing some composition with scala")
    println("********************************")

    val languages = Seq("Scala", "Haskell", "OCaml", "ML")


    try{
      println(s"trying to access value $languages in position 10 --> wil throw exception " + languages(10))
    }
    catch {
      case _ =>
        val default:PartialFunction[Int, String] = {
        case _ => "Is it a Functional Language ?"
      }
      val languagesWithDefault = languages orElse default

        println(s"trying to access value $languagesWithDefault in position 10 --> will return 'is it a functional language' " + languagesWithDefault(10))
    }



  }



  def listAndListBuffer(){

    println("********************************")
    println("List and List Buffer")
    println("********************************")
    val buf = ListBuffer(1.2,3.4,5.6)
    println(s"creating a ListBuffer : $buf")


    println("Updating the list buffer (storing 10 and 3d element)")
    buf(2) = 10
    println(s"$buf")

    println("Storing 20 as 3d element")
    buf.update(2,20)
    println(s"$buf")

    // the 2 syntaxes
    //   buf.update(2,20) &&  buf(2) = 10
    // are identical


    println("********************************")
    println("END List and List Buffer")
    println("********************************")
  }

  def setAndSortedSet(){
    println("********************************")
    println("Set and Sorted Set")
    println("********************************")

    val frameworks = Set("Lift"," Akka", "PlayFramework", "Scalaz")
    println(s"Defined  $frameworks")

    println(s"Checking if  $frameworks contains 'Lift' : " + frameworks contains "Lift")

    println(s"Checking if  $frameworks contains 'Lift' : " + frameworks contains "Scalacheck")

    println(s"Checking if  $frameworks contains 'Lift' with alternative syntax: " + frameworks("Lift"))

    val mFrameworks = scala.collection.mutable.Set() +  "Lift" + " Akka"+  "PlayFramework" +  "Scalaz"
    mFrameworks += "Scalacheck"
    println(s"Adding elements to set $mFrameworks" )

    mFrameworks -= "Scalacheck"
    println(s"Removing elements to set $mFrameworks" )


    println("Some advanced functions with Set and Sorted Set")

    println("Merging 2 sets and removing duplicates")
    println(Set(1,2,3) ++ Set(3, 4,5))

    println("Merging 2 Sorted Sets and removing duplicates")
    println(SortedSet(1,2,3) ++ SortedSet(3, 4,5))

    println("********************************")
    println("END Set and Sorted Set")
    println("********************************")
  }

  def mapAndTuples(){

    println("********************************")
    println("Map & Tuple")
    println("********************************")

    val m = Map((1, "1st"), (2,"2nd"))
    println(s"Created $m")

    val m2 = Map(1->"1st", 2 -> "2nd")
    println(s"Created $m2")

    println("Using the apply method of map on existing element")
    println(m(1))

    try{
      println("Using the apply method of map on non existing element")
      println(m(3))
    }
    catch{
      case e:Exception  => println(e)
    }


    println("Retrieving an element with the get method (it returns an Option object)")

    println("Getting element with position 3 :" + (m get 3))
    println("Getting element with position 2 :" + (m get 2))

    println("Filtering")

    val artists = Map(
    "Pink Floyd" -> "Rock",
    "Led Zeppelin" -> "Rock",
    "Michael Jackson" -> "Pop",
    "Above and Beyond" -> "Trance"
    )
    println(s"Filtering only rock artist from $artists")

    // the tuple returned by map gives 2 methods _1 and _2
    // key and value respectively
    println(artists filter {t => t._2 == "Rock"})

    println(s"Filtering only rock artist from $artists with alternative yield syntax")

    for(t <- artists if t._2 == "Rock" ) yield t

    println("********************************")
    println("END Map & Tuple")
    println("********************************")
  }

  class JavaToTraversable[E](javaCollection:JCollection[E]) extends Traversable[E]{
    def foreach[U](f: (E) => U): Unit =  {
      val iterator = javaCollection.iterator()
      while(iterator.hasNext){
        f(iterator.next())
      }
    }
  }



}
