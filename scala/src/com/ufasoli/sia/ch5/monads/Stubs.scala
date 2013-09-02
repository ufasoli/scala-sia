package com.ufasoli.sia.ch5.monads

/**
 *
 * User: ufasoli
 * Date: 02/09/13
 * Time: 09:24
 * project : scala-sia
 */
object Stubs {

  def findTheBasePrice(productId:String)= 10.0
  def findStateSpecificDiscount(productId:String, stateCode:String) = 0.5
  def findProductSpecificDiscount(productId:String) = 0.5
  def calculateTax(productId:String, tax:Double)= 5.0
}
