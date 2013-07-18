package com.ufasoli.sia.ch3.traits

import com.mongodb.DBObject
import com.ufasoli.sia.ch3.Person
import com.ufasoli.sia.ch3.pkg.obj.BarTender

/**
 *
 * User: ufasoli
 * Date: 18/07/13
 * Time: 11:08
 * project : scala-sia
 */
// sealed marks the trait as non extendable from outside the class file
// (it can be extended only by adding sutff to the QueryOption.scala file

sealed trait QueryOption

case object NoOption extends QueryOption

case class Sort(sorting: DBObject, anotherOption: QueryOption) extends QueryOption

case class Skip(number: Int, anotherOption: QueryOption) extends QueryOption

case class Limit(limit: Int, anotherOption: QueryOption) extends QueryOption



