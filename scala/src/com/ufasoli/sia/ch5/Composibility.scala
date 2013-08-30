package com.ufasoli.sia.ch5

/**
 *
 * User: ufasoli
 * Date: 30/08/13
 * Time: 16:28
 * project : scala-sia
 */
object Composibility {

  def even: Int => Boolean = _ % 2 == 0

  def not: Boolean => Boolean = !_

  def filter[A](criteria: A => Boolean)(col: Traversable[A]) = col.filter(criteria)

  def map[A, B](f: A => B)(col: Traversable[A]) = col.map(f)

  def main(args: Array[String]) {

    def evenFilter = filter(even) _
    def double: Int => Int = _ * 2

    //    evenFilter creates a collection of even elements, and the map function invokes
    //    the double function for each element in the collection
    def doubleAllEven = evenFilter andThen map(double)

    // compose evaluates right to left
    // whereas andThen left to right
    def odd:Int => Boolean = not compose even
    def oddFilter = filter(odd) _

    def doubleAllOdd = oddFilter andThen map(double)
  }

}
