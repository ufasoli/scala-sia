package com.ufasoli.sia.ch3

/**
 *
 * User: ufasoli
 * Date: 09/07/13
 * Time: 22:21
 * Project : scala-sia
 */
// age here is private so we need to define a getter/setter manually
class Person(var firstName:String, var lastName:String, private var _age:Int ) {

  // getter
  def age = _age
  def age_=(newAge:Int) = _age = newAge
}
