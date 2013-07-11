package com.ufasoli.sia.ch3.traits

import com.mongodb.{DBObject, DBCollection}

/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 17:14
 * project : scala-sia
 *
 * Mimics a cache on the database
 */
trait Memoizer  extends ReadOnly{

  val history = scala.collection.mutable.Map[Int, DBObject]()

  override def findOne = {
    history.getOrElseUpdate(-1, {super.findOne})
  }

  override def findOne(doc:DBObject) = {
    history.getOrElseUpdate(doc.hashCode(), {super.findOne(doc)})
  }

}
