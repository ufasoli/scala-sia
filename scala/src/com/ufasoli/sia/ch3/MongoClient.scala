package com.ufasoli.sia.ch3

/**
 *
 * User: ufasoli
 * Date: 09/07/13
 * Time: 22:09
 * Project : scala-sia
 */
// CLass with primary constructor and immutable accessors
// if no var/var are both missing variables will be treated as private fields
// accessible only from inside the class
class MongoClient(val host:String, val port:Int) {

  // default constructor with no arguments
  def this() = this("127.0.0.1", 27017)

}
