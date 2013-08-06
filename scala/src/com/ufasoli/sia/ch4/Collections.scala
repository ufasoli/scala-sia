package com.ufasoli.sia.ch4

/**
 *
 * User: ufasoli
 * Date: 06/08/13
 * Time: 17:03
 * project : scala-sia
 */
class Collections {

  def collections(){
    val mapping : collection.Map[String, String] = Map("Ron" -> "admin", "Sam" -> "analyst")
    val mutableMapping: collection.mutable.Map[String, String]= collection.mutable.Map("Ron" -> "admin", "Sam" -> "analyst")
    mutableMapping + "a" -> "b"
  }
}
