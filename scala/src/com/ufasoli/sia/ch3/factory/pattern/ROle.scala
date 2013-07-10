package com.ufasoli.sia.ch3.factory.pattern

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:18
 * project : scala-sia
 */
abstract  class Role {

  def canAccess(page:String): Boolean

}
