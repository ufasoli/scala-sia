package com.ufasoli.sia.ch5

/**
 *
 * User: ufasoli
 * Date: 28/08/13
 * Time: 14:21
 * project : scala-sia
 */
class DesignPatterns {


  /**
   * This pattern
   * allows you to select algorithms at runtime and can easily be implemented using a
  * higher-order function
   * @param product
   * @param taxingStrategy
   */
  def calculatePriceStrategyPattern(product:String, taxingStrategy: String => Double)= {

    println("************************************")
    println("Strategy Pattern :")
    println("This pattern allows you to select algorithms at runtime and can easily be implemented using a higher-order function")
    println("************************************")
    val tax = taxingStrategy(product)
  }
}


