package com.ufasoli.sia.ch5

/**
 *
 * Example of Functional Object pattern.
 * Each time the value is changed a new instance of the object is returned (newSide)
 * User: ufasoli
 * Date: 28/08/13
 * Time: 14:19
 * project : scala-sia
 */
class PureSquare(val side:Int) {

  def newSide(s:Int):PureSquare = new PureSquare(s)

  def area = side * side

}
