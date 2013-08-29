package com.ufasoli.sia.ch5


/**
 *
 * User: ufasoli
 * Date: 29/08/13
 * Time: 10:14
 * project : scala-sia
 */
class LoanPattern {

  trait Resource{ def dispose():Unit}


  def use[A, B <: Resource](r:Resource)(f: Resource => A):A ={

    try{
      f(r)
    }
    finally {
      r.dispose()
    }
  }

}
