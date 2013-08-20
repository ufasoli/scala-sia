package com.ufasoli.sia.ch4

/**
 *
 * User: ufasoli
 * Date: 20/08/13
 * Time: 11:29
 * project : scala-sia
 */
class Streams {

  def streams(){

    //If you want, you can build an infinite list in Scala using Stream, and it will consume memory based on your use

    //Here the from method defined in the Stream object creates an infinite stream starting at 0 and incrementing by 1
    val stream = List("zero", "one", "two", "three", "four", "five").zip(Stream.from(0))
  }

  def fib(n: Int): Int = n match{

    case 0 => 0
    case 1 => 1
    case n => fib(n-1)+fib(n-2)
  }
}
