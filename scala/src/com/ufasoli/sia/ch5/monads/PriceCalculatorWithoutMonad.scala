package com.ufasoli.sia.ch5.monads

import Stubs._
/**
 * This application needs to calculate a
 * price for a product by following a sequence of steps:
 *     - 1 Find the base price of the product.
 *     - 2 Apply a state code-specific discount to the base price.
 *     - 3 Apply a product-specific discount to the result of the previous step.
 *     - 4 Apply tax to the result of the previous step to get the final price.
 *
 *
 * User: ufasoli
 * Date: 02/09/13
 * Time: 09:18
 * project : scala-sia
 */
object PriceCalculatorWithoutMonad {

  case class PriceState(productId:String, stateCode:String, price:Double)

  def findBasePrice(productId:String, stateCode:String): PriceState = {
    val basePrice = findTheBasePrice(productId:String)
    PriceState(productId,stateCode,basePrice)
  }

  def applyStateSpecificDiscount(ps:PriceState): PriceState ={
        val discount = findProductSpecificDiscount(ps.productId)
    ps.copy(price = ps.price - discount)
  }

  def applyProductSpecificDiscount(ps:PriceState): PriceState = {
    val discount = findProductSpecificDiscount(ps.productId)
    ps.copy(price = ps.price - discount)
  }

  def applyTax(ps:PriceState):PriceState = {
    val tax = calculateTax(ps.productId, ps.price)
    ps.copy(price = ps.price + tax)
  }

  def calculatePrice(productId:String, stateCode:String): Double = {

    val a = findBasePrice(productId,stateCode)
    val b = applyStateSpecificDiscount(a)
    val c = applyProductSpecificDiscount(b)
    val d = applyTax(c)
    d.price
  }
}
