package com.ufasoli.sia.ch4

/**
 *
 * User: ufasoli
 * Date: 30/07/13
 * Time: 13:41
 * project : scala-sia
 */

// the + sign indicates it's covariant
// which means subtying classes can override and use narrower types
// than their subclass in covariant positions such as the return value
//The Maybe class is defined with a covariant parameter type A so that its subclasses can
//return more specialized types.
sealed abstract class Maybe[+A] {

  def isEmpty: Boolean

  def get: A

  // any superclass of A
  //The getOrElse method returns the value contained by Just or the default value when it’s empty.
  // Because the default value is taken as a
  //  parameter, you have to set the lower bound to A to satisfy the contravariant rule.
  def getOrElse[B >: A](default: B): B = {
    if (isEmpty) default else get

  }
}


final case class Just[A](value: A) extends Maybe[A] {
  def isEmpty = false

  def get: A = value
}

case object Nill extends Maybe[Nothing] {
  def isEmpty: Boolean = true

  def get: Nothing = throw new NoSuchElementException("Nil.get")
}