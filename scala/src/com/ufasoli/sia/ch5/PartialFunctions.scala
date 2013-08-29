package com.ufasoli.sia.ch5

/**
 * A partial function is a function that’s only defined
 * for a subset of input values.
 * This is different from the definition of a pure function which is defined for all input parameters
 * User: ufasoli
 * Date: 29/08/13
 * Time: 16:01
 * project : scala-sia
 */
object PartialFunctions {

  def main(args: Array[String]) {
    def intToChar: PartialFunction[Int, Char] = {
      case 1 => 'a'
      case 2 => 'b'
    }
    println(intToChar(1))
  }


}

object PricingSystem{
  // keyword type creates an alias for a given type (here PC == Tuple2[Req,Option[Double]]
  type PC = Tuple2[Req,Option[Double]]
}

sealed trait Claim{val claimId:Int}
case class Full(val claimId:Int) extends Claim
case class Partial(val claimId:Int, percentage:Double) extends Claim
case class Generic(val claimId:Int)extends Claim


case class Location(stateCode:Option[String], zipCode: Option[String])
case class Req(productionId:String, location: Location, claim:Claim)




