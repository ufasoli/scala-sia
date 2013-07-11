package com.ufasoli.sia.ch3.factory.pattern

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:18
 * project : scala-sia
 */
abstract  class Role {

  def canAccess(page:String): Boolean

}

object Role{

  def apply(roleName:String )= roleName match{
    case "Analyst" => new Analyst
    case "superAnalyst" => new SuperAnalyst
    case "root" => new Root
  }
}
