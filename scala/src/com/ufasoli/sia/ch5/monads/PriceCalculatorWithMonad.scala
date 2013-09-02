package com.ufasoli.sia.ch5.monads



/**
 *
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
 * Time: 09:14
 * project : scala-sia
 */
object PriceCalculatorWithMonad {

  case class PriceState(productId:String, stateCode:String, price:Double)


  object Stubs {
    def findTheBasePrice(productId: String) = 10.0
    def findStateSpecificDiscount(productId: String, stateCode: String) = 0.5
    def findProductSpecificDiscount(productId: String) = 0.5
    def calculateTax(productId: String, price: Double) = 5.0
  }

  import Stubs._
  def findBasePrice(ps:PriceState):Double={
    val basePrice  = findTheBasePrice(ps.productId)
    basePrice

  }

  def applyStateSpecificDiscount(ps:PriceState):Double = {
    val discount = findStateSpecificDiscount(ps.productId, ps.stateCode)
    ps.price - discount
  }

}
