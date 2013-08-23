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

  /**
   * this approach to fibonacci grows exponentially
   * as the number gets bigger
   * fib(8)
   * fib(7) + fib(6)
   * (fib(6) + fib(5)) + (fib(5) + fib(4))
   * ((fib(5) + fib(4)) + (fib(4) + fib(3)) + ((fib(4) + fib(3)) + (fib(3) +
   * fib(2))
   * @param n
   * @return
   */
  def fib(n: Int): Int = n match{

    case 0 => 0
    case 1 => 1
    case n => fib(n-1)+fib(n-2)
  }

  def fibStream(n:Int){

    // creating a fibonacci sequence with an infinite stream
//    val fib : Stream[Int] = Stream.cons(0, Stream.cons(1, fib.zip(fib.tail).map(t => t._1 + t._2)))
  }
}
