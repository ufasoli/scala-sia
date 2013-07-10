package com.ufasoli.sia.ch3

import com.mongodb.Mongo

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 17:29
 * project : scala-sia
 */
class MongoClientV2(val host:String, val port:Int) extends Mongo(host,port){

}
