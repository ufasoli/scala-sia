package com.ufasoli.sia.ch3.factory.pattern

/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 10:11
 * project : scala-sia
 */
class Root extends Role{
  def canAccess(page: String): Boolean = true
}
