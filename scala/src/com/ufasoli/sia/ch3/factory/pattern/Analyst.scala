package com.ufasoli.sia.ch3.factory.pattern

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:19
 * project : scala-sia
 */
class Analyst extends Role{
  def canAccess(page: String): Boolean = false
}
