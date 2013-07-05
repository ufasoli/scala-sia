/**
 *
 * User: ufasoli
 * Date: 03/07/13
 * Time: 17:19
 * project : scala
 */

object Breakeable {


  val breakException = new RuntimeException("break exception")

  def main(args: Array[String]) {
    println("begin breakeable function")
    breakable(install)
  }


  def breakable(op: => Unit) {
    try {
      op
    }
    catch {
      case rte:RuntimeException => println(rte.printStackTrace())
    }
  }

  def break = throw breakException

  def install = {

    val env = System.getenv("SCALA_HOM2E")
    if (env == null) {
      println("About to break")
      break
    }

    println("found scala home lets to the real work")
  }
}

