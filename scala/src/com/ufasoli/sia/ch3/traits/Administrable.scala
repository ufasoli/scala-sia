package com.ufasoli.sia.ch3.traits

/**
 *
 * User: ufasoli
 * Date: 11/07/13
 * Time: 15:04
 * project : scala-sia
 */
trait Administrable  extends ReadOnly{

  def drop : Unit = underlying drop
  def dropIndexes : Unit = underlying dropIndexes



}
