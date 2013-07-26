package com.ufasoli.sia.ch3.overriding

/**
 *
 * User: ufasoli
 * Date: 26/07/13
 * Time: 14:54
 * project : scala-sia
 */
trait DogMood {
     def greet
}

trait AngryMood extends DogMood{

  // in order to allow the call to
  // super greet the 2 modifiers (override & abstract need to be present)
  override abstract def greet = {
  println("bark")
    super.greet
  }
}

