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

object PricingSystem {

  def main(args: Array[String]) {

    priceCalculator((Req("some product", Location(None, Some("4444")), Full(1)), Some(10))) match {
      case (c, finalPrice) => println(finalPrice)

    }

    priceCalculator((Req("some product", Location(None, None), Generic(10)), Some(10))) match {
      case (c, finalPrice) => println(finalPrice)
    }



  }

  // keyword type creates an alias for a given type (here PC == Tuple2[Req,Option[Double]]
  type PC = Tuple2[Req, Option[Double]]


  def handleFullClaim: PartialFunction[PC, PC] = {
    case (c@Req(id, l, Full(claimId)), basePrice)  =>  (c, basePrice.map(_ + 10))
  }

  def handlePartialClaim: PartialFunction[PC, PC] = {
    case (c@Req(id, l, Partial(claimId, percentage)), basePrice)  =>  (c, basePrice.map(_ + 20))
  }

  def handleZipCode: PartialFunction[PC, PC] = {
    case (c@Req(id, Location(_, Some(zipCode)), _), price) => (c, price.map(_ + 5))
  }

  def handleStateCode: PartialFunction[PC, PC] = {
    // @ crée un alias pour Req nomé c
    case (c@Req(id, Location(Some(stateCode), _), _), price) => (c, price.map(_ + 10))
  }


  //  To create the final solution to calculate the price for a provider, you can combine
  //  these smaller partial functions and be done with it. According to the business rules,
  //  you should first determine the price based on the claim and further refine the calculated
  //  price based on location. You can easily combine these functions with the orElse
  //    and andThen
  def claimHandlers = handleFullClaim orElse handlePartialClaim

  def locationHandlers = handleZipCode orElse handleStateCode

  def priceCalculator: PartialFunction[PC, PC] = claimHandlers andThen locationHandlers


}

sealed trait Claim {
  val claimId: Int
}

case class Full(val claimId: Int) extends Claim

case class Partial(val claimId: Int, percentage: Double) extends Claim

case class Generic(val claimId: Int) extends Claim


case class Location(stateCode: Option[String], zipCode: Option[String])

case class Req(productionId: String, location: Location, claim: Claim)




