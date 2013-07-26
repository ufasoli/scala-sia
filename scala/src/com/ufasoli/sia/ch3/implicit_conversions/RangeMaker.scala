package com.ufasoli.sia.ch3.implicit_conversions

/**
 *
 * User: ufasoli
 * Date: 26/07/13
 * Time: 15:40
 * project : scala-sia
 */
class RangeMaker(left:Int) {

  def --> (right:Int) = left to right

}
