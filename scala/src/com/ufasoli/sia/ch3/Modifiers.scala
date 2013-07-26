package com.ufasoli.sia.ch3

/**
 *
 * User: ufasoli
 * Date: 26/07/13
 * Time: 14:43
 * project : scala-sia
 */
class Modifiers {

    class Outer{

      class Inner{
        // private to inner and outter class
        private [Outer] def f() = "this is f"
        //private to package
        private [ch3] def g() = "this is g"
      }

    }


}
