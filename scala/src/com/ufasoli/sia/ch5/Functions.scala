package com.ufasoli.sia.ch5

/**
 * The common form of a function in Scala is defined as a member of a class. It’s called a
 * method
 *
 * User: ufasoli
 * Date: 29/08/13
 * Time: 09:43
 * project : scala-sia
 */
class Functions {

  def succMethod(){

    // the following is the same definition but with different syntax
    // the first is actually a shorthand for the second
    val succ = (x:Int) => x+1

    val succFunction = new Function1[Int,Int]{
      def apply(x:Int):Int = x+1
    }
  }


  def aMethodWithArgs(arg:String){
    println(arg)
  }

  def functionFromMethod(){

    // convert the method succMethod to a function and assign it  to val 's'
    val s = succMethod _

    // this will call the function succFunction
    s

    // convert the method aMethodWithArgs to a function and assign it  to val 'aFunc'
    val aFunc = aMethodWithArgs _

    // this will call the function 'aFuncWithArgs' with the argument test
    aFunc( "test")
  }
}
