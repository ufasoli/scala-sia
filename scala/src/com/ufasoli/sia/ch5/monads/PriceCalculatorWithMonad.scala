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


  import Stubs._
  import StateMonad.State._

  case class PriceState(productId:String, stateCode:String, price:Double)


  object Stubs {
    def findTheBasePrice(productId: String) = 10.0
    def findStateSpecificDiscount(productId: String, stateCode: String) = 0.5
    def findProductSpecificDiscount(productId: String) = 0.5
    def calculateTax(productId: String, price: Double) = 5.0
  }


  def findBasePrice(ps:PriceState):Double={
    val basePrice  = findTheBasePrice(ps.productId)
    basePrice

  }

  def applyStateSpecificDiscount(ps: PriceState): Double = {
    val discount = findStateSpecificDiscount(ps.productId, ps.stateCode)
    ps.price - discount
  }

  def applyProductSpecificDiscount(ps: PriceState): Double = {
    val discount = findProductSpecificDiscount(ps.productId)
    ps.price - discount
  }
  def applyTax(ps: PriceState): Double = {
    val tax = calculateTax(ps.productId, ps.price)
    ps.price + tax
  }


  def modifyPriceState(f: PriceState => Double) =

  modify[PriceState](s => s.copy(price = f(s)))
  val stateMonad = for {

    _ <- modifyPriceState(findBasePrice)
    _ <- modifyPriceState(applyStateSpecificDiscount)
    _ <- modifyPriceState(applyProductSpecificDiscount)
    _ <- modifyPriceState(applyTax)
  }yield ()




}

object StateMonad {
  import State._
  trait State[S, +A] {
    def apply(s: S): (S, A)
    def map[B](f: A => B): State[S, B] = state(apply(_) match {
      case (s, a) => (s, f(a))
    })
    def flatMap[B](f: A => State[S, B]): State[S, B] =
      state(apply(_) match {
        case (s, a) => f(a)(s)
      })
  }
  object State {
    def state[S, A](f: S => (S, A)) = new State[S, A] {
      def apply(s: S) = f(s)
    }
    def init[S]: State[S, S] = state[S, S](s => (s, s))
    def modify[S](f: S => S) =
      init[S] flatMap (s => state(_ => (f(s), ())))
  }
}