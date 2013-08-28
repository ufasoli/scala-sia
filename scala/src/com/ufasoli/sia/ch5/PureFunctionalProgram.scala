/**
 *
 * User: ufasoli
 * Date: 27/08/13
 * Time: 14:51
 * project : scala-sia
 */

object PureFunctionalProgram {


  def main(args: Array[String]) {

    println(singleExpression(args.toList))


  }

  def singleExpression: List[String] => (List[Int], List[Int]) = {
    a =>
      a map (_.toInt) partition (_ < 30)
  }

}