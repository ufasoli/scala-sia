import com.ufasoli.sia.ch5.http.server.Resource
import com.ufasoli.sia.ch5.{BTaxStrategy, ATaxStrategy, TaxStrategy}

/**
 *
 * User: ufasoli
 * Date: 27/08/13
 * Time: 14:51
 * project : scala-sia
 */

object CH5{

  def main(args: Array[String]) {




    //This function takes an instance of TaxStrategy and returns a function of type String => Double, which
    // encapsulates the taxing strategy.
    def taxtIt:TaxStrategy => String => Double = s => p => s.taxIt(p)

    def taxIt_a:String => Double = taxtIt(new ATaxStrategy)
    def taxIt_b:String => Double = taxtIt(new BTaxStrategy)

  }
}

