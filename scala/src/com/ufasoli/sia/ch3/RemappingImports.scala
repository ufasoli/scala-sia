package com.ufasoli.sia.ch3

import java.util.Date
// remaps the Date obj to SqlDate
import java.sql.{Date => SqlDate}
// hides the Array obj in the file
import java.sql.{Array => _}



import java.sql

/**
 *
 * User: ufasoli
 * Date: 10/07/13
 * Time: 18:04
 * project : scala-sia
 */
object RemappingImports {
  def main(args: Array[String]) {

    val now = new Date
    println(now)
    val sqlDate = new SqlDate(now.getTime)
    println(sqlDate)
  }

}
