package com.ufasoli.sia.ch3

import com.mongodb.{DB => MongoDB}

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:11
 * project : scala-sia
 */
// Scala object
class DB private(val underlying:MongoDB) {

}

// scala companion object (both share the same name)
// companion objects can access the object's private fields
object DB {

  //Scala provides syntactic sugar that allows you to use objects as function calls.
  // Scala achieves this by translating these calls into the apply method,
  // which matches the given parameters defined in the object or class
  //If there’s no matching apply method, it will result in a compilation error. Even though
  def apply(underlying: MongoDB) = new DB(underlying)

}
