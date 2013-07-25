package com.ufasoli.sia.ch3.traits

/**
 *
 * User: ufasoli
 * Date: 25/07/13
 * Time: 13:46
 * project : scala-sia
 */
trait PersonTrait {
     def grade(years:Int):String
}

class SalesPerson extends PersonTrait{

  def grade(yrs:Int) = "Senior"
}
