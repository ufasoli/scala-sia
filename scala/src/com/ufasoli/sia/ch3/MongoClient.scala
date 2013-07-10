package com.ufasoli.sia.ch3

import com.mongodb.Mongo

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

  // this code will be put in the primary constructor
  require(host != null, "You must provide a host name")


  // so when creating a new instance of the MongoClient class
  private val underlying = new Mongo(host, port)


  // Because of Scala’s scripting nature, you can write code inside the class like a script, which will get
  // executed when the instance of the class is created (kind of like Ruby). The following
  // How is Scala doing this? Scala puts any inline code defined inside the class
  // into the primary constructor of the class


  // default constructor with no arguments
  def this() = this("127.0.0.1", 27017)


  // the following will throw a compilation error as when overloading a constructor
  // the first call must be to the primary constructor
  //  def this() = {
  //    val defaultHost = "127.0.0.1"
  //    val defaultPort = 27017
  //    this(defaultHost,defaultPort)
  //  }
}
