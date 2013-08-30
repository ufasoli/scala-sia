package com.ufasoli.sia.ch5

import scala.annotation.tailrec

/**
 *
 * User: ufasoli
 * Date: 30/08/13
 * Time: 10:40
 * project : scala-sia
 */
object Recursion {

  def main(args: Array[String]) {

    println(imperativeSum(List(1, 2, 3, 4)))
    println(recursiveSum(List(1, 2, 3, 4)))
    println(thinkingRecursively(List("A", "B", "C", "A", "D", "B")))



  }


  def imperativeSum(list: List[Int]): Int = {
    var sum = 0

    for (e <- list) {
      sum += e
    }

    sum

  }

  def recursiveSum(list: List[Int]): Int = {

    list match {
      case Nil => 0
      case x :: ys => x + recursiveSum(ys)
    }

  }


  //  Suppose you’re given a list of elements, and your job is to remove the duplicates. For
  //  example, if you’re given List(0,1,2,3,2,1,0), the output should be List(0, 1, 2, 3).
  // I’m going to show you a step-by-step process to come up with a recursion-based solution.
  //  The first step is to identify the type. Thinking in terms of type will help you think
  //    about the input parameter and the return value of the function. Don’t generalize yet,
  //  but think about what you have and what you want to achieve. Sometimes using a concrete
  //    example helps. The type of the removeDups function will look like the following:
  //    removeDups: List[Int] => List[Int]
  //The next step is to declare all the cases that you need to handle. In the case of
  //  removeDups, you have to handle the following cases:
  //case Nil =>
  //  case x :: ys if(ys.contains(x)) =>
  //  case x :: ys =>

  //  The next step is to implement the simple cases. Here you have only one simple
  //  case, and that’s case Nil. Because empty lists can’t have any duplicates, you can safely
  //  return an empty list back
  //  The next step is to implement the other case(s) when you have a nonempty list. For
  //  this step, it’s useful to consider which constructs and functions you have that you
  //    could use to implement these cases. For the second case, you want to throw out the x
  //  because it’s a duplicate and continue with the processing for the rest of the elements
  //  in the list. The easiest way to do that is to invoke removeDups again by passing the ys as
  //  a parameter
  //For the last case you want to continue with the rest of the list and append the nonduplicate
  //  element to the list:
  def thinkingRecursively[A](list: List[A]): List[A] = {

    removeDups(list)

  }

  def removeDups[A](list: List[A]): List[A] = {

    list match {
      // check for empty list
      case Nil => Nil
      // checking for duplicate elements
      case x :: ys if (ys.contains(x)) => removeDups(ys)
      //non duplicate element
      case x :: ys => removeDups(ys) :+ x
    }

  }

  // Head recursion is the more traditional way of doing recursion, where you perform the recursive call
  //    first and then take the return value from the recursive function and calculate the result.
  //    In tail recursion you perform your calculation first and then execute the recursive
  //  call by passing the result of the current step to the next step
  //  why recursion is avoided in Java and other similar   languages :
  //  Generally when you call a function an entry is added to the call stack of the currently
  //  running thread. The downside is that the call stack has a defined size, and once you violate
  //    that boundary you get a StackOverflowError exception. This is why Java developers
  //  prefer to iterate rather than recurse.
  def tailRecursion() {

  }


  def lengthHeadRecursion[A](xs: List[A]): Int = xs match {

    case Nil => 0
    case x :: ys => 1 + lengthHeadRecursion(ys)
  }

  // In this version you aren’t doing any calculation after the recursive call. You do the calculation
  // at each step and pass the result to the next step of the recursion
  // For Scala, you should always prefer the version
  // that uses tail recursion because Scala tries to optimize tail recursive functions

  def lengthTailRecursion[A](xs: List[A]): Int = {

    @tailrec
    def _length(xs: List[A], currentLength: Int): Int = xs match {

      case Nil => currentLength
      case x :: ys => _length(ys, currentLength + 1)
    }

    _length(xs, 0)

  }

}
