package com.ufasoli.sia.ch5

/**
 *    Function currying is a technique for transforming a function that takes multiple parameters
 *    into a function that takes a single parameter
 * User: ufasoli
 * Date: 29/08/13
 * Time: 11:22
 * project : scala-sia
 */
object Currying {


  def main(args: Array[String]) {
    val taxIt:(TaxStrategy,String) => Double = (s,p) => s.taxIt(p)

    //It turned the taxIt function into a function that takes one parameter and returns
    //another function that takes the second parameter:
    //TaxStrategy => String => Double = <function1>
    taxIt.curried


    val taxFree = taxIt.curried(new TaxFree)


    println(taxFree("someProduct"))

  }


}



class TaxFree extends TaxStrategy{

  override def taxIt(product:String) = 0.0
}



