package com.ufasoli.sia.ch3.traits

import com.mongodb.{DBCollection => MongoDBCollection, DBObject}
/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 15:00
 * project : scala-sia
 */
trait ReadOnly {

  // abstract field --> in scala you can define
  // abstract fields that need to be implemented by subclasses
  val underlying: MongoDBCollection

  def name = underlying getName
  def fullName = underlying getFullName
  def find(doc:DBObject) = underlying find doc
  def findOne = underlying findOne
  def findOne(doc:DBObject) = underlying findOne doc
  def getCount(doc:DBObject) = underlying getCount doc

}
