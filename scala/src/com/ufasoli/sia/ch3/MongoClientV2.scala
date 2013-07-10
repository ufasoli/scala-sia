package com.ufasoli.sia.ch3

import com.mongodb.Mongo

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 17:29
 * project : scala-sia
 */
// calls directly the Mongo constructor
class MongoClientV2(val host: String, val port: Int) extends Mongo(host, port) {
  require(host != null, "You must provide a host")

  def this() = this("127.0.0.1", 27017)
}
