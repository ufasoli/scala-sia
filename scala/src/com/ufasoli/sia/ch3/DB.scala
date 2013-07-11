package com.ufasoli.sia.ch3

import com.mongodb.{DB => MongoDB}
import scala.collection.convert.Wrappers.JSetWrapper
import com.ufasoli.sia.ch3.traits.{Memoizer, Updatable, Administrable}

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:11
 * project : scala-sia
 */
// Scala obj
class DB private(val underlying:MongoDB) {
  // private constructor (factory pattern)

   //JSetWrapper --> converts a Java Set into a Scala set
  def collectionNames = for(name <- new JSetWrapper[String](underlying.getCollectionNames)) yield name


  private def collection(name:String) = underlying.getCollection(name)

  def readOnlyCollection(name:String) = new DBCollection(collection(name)) with Memoizer

  def administrableCollection(name:String) = new DBCollection(collection(name)) with Administrable with Memoizer

  def updatableCollection(name:String) = new DBCollection(collection(name)) with Updatable with Memoizer

}

// scala companion obj (both share the same name)
// companion objects can access the obj's private fields
object DB {

  //Scala provides syntactic sugar that allows you to use objects as function calls.
  // Scala achieves this by translating these calls into the apply method,
  // which matches the given parameters defined in the obj or class
  //If there’s no matching apply method, it will result in a compilation error. Even though
  def apply(underlying: MongoDB) = new DB(underlying)

}
