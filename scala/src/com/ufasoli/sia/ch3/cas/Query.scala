package com.ufasoli.sia.ch3.cas

import com.mongodb.DBObject

import com.ufasoli.sia.ch3.cas.Query
import com.ufasoli.sia.ch3.traits._
import com.ufasoli.sia.ch3.cas.Query
import com.ufasoli.sia.ch3.cas.Query


/**
 *
 * User: ufasoli
 * Date: 18/07/13
 * Time: 11:13
 * project : scala-sia
 */
// class/method with default value (NoOption defined)
case class Query(q: DBObject, option: QueryOption = NoOption) {

  // create a new query object everytime to allow a fluent interface
  //var rangeQuery = new BasicDBObject("i", new BasicDBObject("$gt", 20))
  //var richQuery = Query(rangeQuery).skip(20).limit(10)
  def sort(sorting: DBObject) = Query(q, Sort(sorting, option))
  def skip(skip:Int) = Query(q, Skip(skip, option))
  def limit(limit:Int) = Query(q, Limit(limit,option))
}



