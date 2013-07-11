package com.ufasoli.sia.ch3.traits

import com.mongodb.DBObject

/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 15:05
 * project : scala-sia
 */
trait Updatable  extends ReadOnly{

  def -=(doc:DBObject): Unit = underlying remove doc
  def +=(doc:DBObject):Unit = underlying save doc

}
