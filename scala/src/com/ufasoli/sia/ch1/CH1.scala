package com.ufasoli.sia.ch1

import com.ufasoli.sia.ch1.classes.{MyMap, Programmer}

object CH1{


  def main(args: Array[String]) {
    var i = 10
    loopTill (i > 0) {
      println(i)
      i -= 1

    }

    val name ="Toto"
    println(name.exists(_.isUpper))

    println(countLines("resources/someFile.txt"))


    // using Dynamic
    val someMap = new MyMap
    println(someMap.foo)
    println(someMap.bar)


    var computers = Array(
                  Map("name" -> "Macbook", "color" -> "white"),
                 Map("name" -> "HP Pavillon", "color" -> "black")
    )
    computers = computers:+ Map("1" -> "2")

    println(computers)
  }

def loopTill(cond: => Boolean)(body: => Unit): Unit = {
  if (cond) {
    body
    loopTill(cond)(body)
  }
}

  def countLines(file: String): Int = {

    scala.io.Source.fromInputStream(getClass().getResourceAsStream(file)).getLines().map(x => 1).sum


  }





}
