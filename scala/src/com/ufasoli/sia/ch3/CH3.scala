import com.ufasoli.sia.ch3.Address

/**
 *
 * User: ufasoli
 * Date: 09/07/13
 * Time: 22:15
 * Project : scala-sia
 */


object CH3{
  def main(args: Array[String]) {
    val address = new Address("5th avenue", "", "New York", 1111)
    println(address.address1)
    address.address1 = "6th avenue"
    println(address.address1)


  }
}