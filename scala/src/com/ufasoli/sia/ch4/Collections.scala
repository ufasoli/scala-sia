package com.ufasoli.sia.ch4

import java.util.{Collection => JCollection, ArrayList}
import java.util

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

  class JavaToTraversable[E](javaCollection:JCollection[E]) extends Traversable[E]{
    def foreach[U](f: (E) => U): Unit =  {
      val iterator = javaCollection.iterator()
      while(iterator.hasNext){
        f(iterator.next())
      }
    }
  }

}
