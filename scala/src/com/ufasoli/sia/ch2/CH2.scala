package com.ufasoli.sia.ch2

import java.util

/**
 *
 * User: ufasoli
 * Date: 03/07/13
 * Time: 15:02
 * project : scala
 */


object CH2 {
  // default values
  var willKnowLater: String = _


  def main(args: Array[String]) {
    val myList = new util.ArrayList[String]()

    myList.add("toto")
    println(myList.get(0))

    //   numbers
    val decimal = 100L
    var hexa = 0x45454
    val octa = 023

    val i = 1

    val i2: Byte = 1

    println(i)
    println(i2)

    // floating points

    val d = 0.0
    val f = 0.0f
    val exponent = 1e30


    // character literals
    var capB = '\102'
    println(capB)
    capB = 'B'
    println(capB)

    val newLine = '\n'
    println(newLine)



    // String literals
    val bookName = "Scala in \"Action\""
    println(bookName)


    val multiLineString =
      """ This is
        |a multiline
        |String
      """.stripMargin

    println(multiLineString)
    sayMyName("Ulises")

    sayMyNameHeight("Ulises", 1.9d)


    // XML literals

    val book = <book>
      <title>Scala in action</title>
      <author>Nilanjan Raychaudhuri</author>
    </book>

    println(book)
    printXmlExpression("Test", 1)



    willKnowLater = "hello"
    println(willKnowLater)

    lazy val forLater = lazyValInit()
    println(forLater)


    // variable assign from pattern

    // first will contain 1, rest will contain List(2,3)
    val first :: rest = List(1, 2, 3)
    println(first)
    println(rest)

    //functions

    println(myFirstMethod)
    println(welcome("ufasoli"))

    println(max(10, 8))



    // generic functions
    println(toList(1))
    println(toList("foo"))


    //closures
    val evenNumbers = List(2, 4, 6, 8, 10)


    val sum = evenNumbers.foldLeft(0) {
      (a: Int, b: Int) => a + b
    }
    println(s"Sum of all numbers in list $sum")

    // some function with automatic type inference
    val sum2 = evenNumbers.foldLeft(0) {
      (a, b) => a + b
    }
    println(s"Sum of all numbers in list $sum2")

    val sumFuncRef = sumFunc _

    val sum3 = evenNumbers.foldLeft(0)(sumFuncRef)
    println(s"Sum of all numbers in list as a func ref $sum3")


    install


  }


  def sayMyName(name: String) {
    println(s"Your name is $name")
  }

  def sayMyNameHeight(name: String, height: Double) {

    println(f"$name%s is $height%2.2f meters tall")
  }


  def printXmlExpression(message: String, code: Int) {

    val xml = <alert>
      <message priority={code.toString}>
        {message}
      </message> <date>
        {new java.util.Date()}
      </date>
    </alert>

    println(xml)

  }

  def lazyValInit(): String = {

    "Lazy"
  }


  def myFirstMethod: String = "exiting times ahead"


  def welcome(name: String): String = {

    s"Exiting times ahead $name"
  }

  def max(a: Int, b: Int): Int = if (a > b) a else b

  // generic function
  def toList[A](value: A) = List(value)

  def sumFunc(a: Int, b: Int): Int = a + b


  // adding support for break



def install() = {
  def break = new RuntimeException("break exception")

  val env = System.getenv("SCALA_HOM2E")
  if (env == null) break
  println("found scala home lets to the real work")
}

}
