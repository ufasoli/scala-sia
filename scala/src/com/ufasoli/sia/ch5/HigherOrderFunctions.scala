package com.ufasoli.sia.ch5

import com.ufasoli.sia.ch5.http.server.Pure.Resource
import com.ufasoli.sia.ch3.cas.Person

/**
 *   Higher-order functions are those that take functions as parameters or return functions
 *   as a return value
 * User: ufasoli
 * Date: 29/08/13
 * Time: 09:58
 * project : scala-sia
 */
class HigherOrderFunctions {


  def listFilter(){
    val l = List(1, 2, 3, 5, 7, 10, 15)
    println(s"Filtering even numbers $l first with function literal then higher order functions")


    println(s"With function literal : l.filter(_ % 2 == 0).   ${l.filter(_ % 2 == 0)}")

  }








}
