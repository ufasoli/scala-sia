package com.ufasoli.sia.ch3.traits

import com.mongodb.{DBCollection => MongoDBCollection, DBCursor, DBObject}
import com.ufasoli.sia.ch3.cas.Query

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

  def find(doc: DBObject) = underlying find doc

  def findOne = underlying findOne

  def findOne(doc: DBObject) = underlying findOne doc

  def getCount(doc: DBObject) = underlying getCount doc

  def find(query: Query): DBCursor = {

    def applyOptions(cursor: DBCursor, option: QueryOption): DBCursor = {

      option match {
        case Skip(skip, next) => applyOptions(cursor.skip(skip), next)
        case Sort(sorting, next) => applyOptions(cursor.sort(sorting), next)
        case Limit(limit, next) => applyOptions(cursor.limit(limit), next)
        case NoOption => cursor
      }

    }

    applyOptions(find(query.q), query.option)
  }

}
