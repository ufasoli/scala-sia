package com.ufasoli.sia

object CH1{


  def main(args: Array[String]) {
    var i = 10
    loopTill (i > 0) {
      println(i)
      i -= 1
  }

def loopTill(cond: => Boolean)(body: => Unit): Unit = {
  if (cond) {
    body
    loopTill(cond)(body)
  }
}



}

}
