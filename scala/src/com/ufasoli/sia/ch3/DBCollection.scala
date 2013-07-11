package com.ufasoli.sia.ch3

import com.ufasoli.sia.ch3.traits.{Updatable, Administrable, ReadOnly}
import com.mongodb.{DBCollection => MongoDBCollection }

/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 15:16
 * project : scala-sia
 */
// note override param that indicates that we are overriding the ReadOnly underlying param
class DBCollection(override val underlying: MongoDBCollection) extends ReadOnly{


}
