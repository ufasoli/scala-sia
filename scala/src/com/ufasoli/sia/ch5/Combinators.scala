package com.ufasoli.sia.ch5

/**
 *
 * User: ufasoli
 * Date: 29/08/13
 * Time: 10:15
 * project : scala-sia
 */
object Combinators {


  /**
   * Kestrel Combinator pattern.
   *
   * All types will have this method defined
   * since the method is declared as implicit
   * @param a
   * @tparam A
   * @return
   */
  implicit def kestrel[A](a: A) = new {
    def tap(sideEffect: A => Unit): A = {
      sideEffect(a)
      a
    }
  }


}




case class Person(firstName: String, lastName: String)

case class Mailer(mailAddress: String) {
  def mail(body: String) = {println("send mail here...") }
}

object Main {

  import Combinators._

  def main(args: Array[String]) {

    Person("Nilanjan", "Raychaudhuri").tap(p => {
      println("First name " + p.firstName)
      Mailer("some address")
    }).lastName



  }


}

