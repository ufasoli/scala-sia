import com.ufasoli.sia.ch3.cas.Person
import com.ufasoli.sia.ch3.traits.Administrable
import com.ufasoli.sia.ch3.{DBCollection, DB, MongoClient, Address}
import com.ufasoli.sia.ch3.factory.pattern.Role
import com.mongodb.{DBCollection => MongoDBCollection, BasicDBObject}

/**
 *
 * User: ufasoli
 * Date: 09/07/13
 * Time: 22:15
 * Project : scala-sia
 */


object CH3 {
  def main(args: Array[String]) {
    val address = new Address("5th avenue", "", "New York", 1111)
    println(address.address1)
    address.address1 = "6th avenue"
    println(address.address1)


    // create a new role from the companion Role obj
    val root = Role("root")
    val superAnalyst = Role("superAnalyst")

    printMongoCollections()

    mongoQuickTour()

    caseClasses()
  }

  def printMongoCollections() {

    def client = new MongoClient("mongo-local", 27017)

    for (collectionName <- client.db("test").collectionNames) println(collectionName)
  }

  def mongoQuickTour() {

    val client = new MongoClient("mongo-local", 27017)
    val db = client.db("sia")

    for (name <- db.collectionNames) println(name)

    val col = db.readOnlyCollection("test")
    println(col.name)

    val adminCol = db.administrableCollection("test")
    adminCol.drop

    val updatableCol = db.updatableCollection("test")

    val doc = new BasicDBObject()
    doc.put("name", "MongoDB")
    doc.put("type", "database")
    doc.put("count", 1)

    val info = new BasicDBObject()
    info.put("x", 203)
    info.put("y", 102)

    doc.put("info", info)

    // add document to collection
    updatableCol += doc

    println(updatableCol.findOne(doc))

    // remove document from the collection
    updatableCol -= doc
    println(updatableCol.findOne(doc))

    // add 100 documents to the collection
    for (i <- 1 to 100) updatableCol += new BasicDBObject("i", i)

    val query = new BasicDBObject
    query.put("i", 71)

    // look for document 71 in the collection
    val cursor = col.find(query)
    while (cursor.hasNext) {
      println(cursor.next())
    }


  }

  def caseClasses() {

    val me = Person("Ulises", "Fasoli")
    val myself = Person("Ulises", "Fasoli")

    println("Me equals myself ? : " + me.equals(myself))

    println("me.hashCode : "+ me.hashCode())
    println("myself.hashCode : " + myself.hashCode())
    println("me.toString : " + me)
    println("myself.toString : " + myself)

  }


}