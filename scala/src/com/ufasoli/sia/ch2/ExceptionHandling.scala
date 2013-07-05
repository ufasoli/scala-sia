package com.ufasoli.sia.ch2

/**
 *
 * User: ufasoli
 * Date: 05/07/13
 * Time: 14:33
 * project : scala
 */

// NOTE: All exceptions in SCALA are unchecked
object ExceptionHandling{
  def main(args: Array[String]) {

    println("OK")
    rangeMatcher(50)
    println("EXCEPTION")

    try{
      rangeMatcher(102)
    }
    catch {
      case e : IllegalArgumentException => println(e.getMessage())
      case whatevs => println(s"unknown exception $whatevs")
    }

  }

  def rangeMatcher(num:Int) = num match{

    case within10 if within10 <= 10 => println("within 0 to 10")
    case within100 if within100 <= 100 => println("within 11 to 100")
    case _ => throw new IllegalArgumentException("Only values between 0 and 100 are allowed")

  }
}
