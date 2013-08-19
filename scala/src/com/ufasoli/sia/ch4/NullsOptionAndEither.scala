package com.ufasoli.sia.ch4

import scala._
import java.lang.Throwable

/**
 *
 * User: ufasoli
 * Date: 19/08/13
 * Time: 16:34
 * project : scala-sia
 */
class NullsOptionAndEither {


  /**
   * scala.Either represents one of the two possible meaningful results, unlike
    * Option, which returns a single meaningful result or Nothing. Either provides two
    * subclasses: Left and Right. By convention, Left represents failure and Right is
    * akin to Some. In the following code you’re trying to make a socket connection, and as
    * you know, it might fail or return a connection based on whether a server is available
    * to accept it.
   * When exception occurs --> creates instance of Left otherwise Right
   * @param block
   * @tparam T
   * @return
   */
  def eitherThrowableToLeft[T](block: => T): Either[Throwable, T]= {

    println("**********************")
    println("Either Example")
    println("**********************")
    try{
      Right(block)
    }
    catch{
      case ex : Throwable => Left(ex)
    }


  }
}
