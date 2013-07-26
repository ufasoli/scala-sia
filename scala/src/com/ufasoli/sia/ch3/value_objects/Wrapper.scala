package com.ufasoli.sia.ch3.value_objects

/**
 *
 * User: ufasoli
 * Date: 26/07/13
 * Time: 14:56
 * project : scala-sia
 *
 * Starting with version 2.10, Scala allows user-defined value classes (which could be case
 * classes as well) that extend AnyVal. Value classes are a new mechanism to avoid runtime
 * allocation of the objects. To create a value class you need to abide by some
 * important rules, including:
 *
 * - The class must have exactly one val parameter (vars are not allowed).
 * - The parameter type may not be a value class.
 * - The class can not have any auxiliary constructors.
 * - The class can only have def members, no vals or vars.
 * - The class cannot extend any traits, only universal traits.
 *
 * These are big constraints, so why bother? Value classes allow you to add extension
 * methods to a type without the runtime overhead of creating instances.
 */
class Wrapper(val name: String) extends AnyVal {
  def up() = name.toUpperCase

}
