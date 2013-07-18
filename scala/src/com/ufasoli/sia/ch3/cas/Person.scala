package com.ufasoli.sia.ch3.cas



/**
 *
 * User: ufasoli
 * Date: 18/07/13
 * Time: 10:51
 * project : scala-sia
 */
// if not specified all parameters will be treated as val
// the compiler implements the toString method, returning class name and parameters
// the compiler implements the copy method
// a companion object is created with the appropriate apply method, taking the same arguments as the clase class
// the compiler adds a method called 'unapply' which allors the class name to be used as an extractor for pattern matching
case class Person(firstName:String, lastName:String) {

}
