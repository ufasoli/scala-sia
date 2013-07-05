package com.ufasoli.sia.ch2

import java.io.File

/**
 *
 * User: ufasoli
 * Date: 04/07/13
 * Time: 14:04
 * project : scala
 */

object LoopsAndIfs {

  def main(args: Array[String]) {

    //    In Scala, if and else blocks work as they do in any other programming language.
    //  If the expression inside the if evaluates to true,
    //    then the if block gets executed; otherwise, the else block is executed. The interesting
    //      part about Scala is that every statement is an expression, and its value is determined
    //    by the last expression within the statement. Assigning a value depending on
    //    some condition in Scala could look like this:

    val someValue = if (true) "true" else "false"
    println(someValue)

    val useDefault = false
    val configFile = if (useDefault) "custom.txt" else "default.txt"
    println(configFile)
    forLoops()
  }

  def forLoops() {

    /** IMPERATIVE FORMS **/
    println("IMPERATIVE FORMS")
    // simple loop
    val files = new File(".").listFiles()
    for (file <- files) {
      val fileName = file.getName
      println(file)
    }

    // alternative syntax with guard clause inside the loop

    for (
      file <- files;
      fileName = file.getName
    ) println(file)


    // multiple generators in the clause

    val aList = List(1, 2, 3)
    val bList = List(4, 5, 6)


    // each generator will be repeated for the other generator
    //
    for { a <- aList; b <- bList} println(a+b)

    //syntax supports either curly bracer or parenthesis
    for ( a <- aList; b <- bList) println(a+b)



    /** FUNCTIONAL FORMS **/

    println("FUNCTIONAL FORMS")
    val result = for {a <- aList; b <- bList} yield a+b

    for(r <- result) println(r)

    // creating a xml node from a for loop
    val xmlNode = <result>{result.mkString(",")}</result>
    println(xmlNode)

    // will return a list of Unit (the result of each yield println)
    val resList =  for(a <- aList; b <- bList ) yield {println(a+b)}

    println(resList)
  }
}