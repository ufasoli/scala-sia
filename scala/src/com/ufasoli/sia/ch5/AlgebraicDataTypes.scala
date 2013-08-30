package com.ufasoli.sia.ch5

/**
 *
 * User: ufasoli
 * Date: 30/08/13
 * Time: 11:23
 * project : scala-sia
 */
object AlgebraicDataTypes {

  def main(args: Array[String]) {
          printAccountDetails(CheckingAccount("1111"))

  }

  def printAccountDetails(account:Account):Unit = account match{

    case CheckingAccount(accountId) => println(s"Checking account number : $accountId")
    case SavingAccount(accountId, limit) => println(s"SavingAccount account number : $accountId and limit : $limit")
    case PremiumAccount(corporateId, accountHolder) => println(s"PremiumAccount corporate id : $corporateId holded by : $accountHolder")
  }

  sealed trait Account

  case class CheckingAccount(accountId:String) extends Account
  case class SavingAccount(accountId:String, limit:Double) extends Account
  case class PremiumAccount(corporateId:String, accountHolder:String) extends Account



}
