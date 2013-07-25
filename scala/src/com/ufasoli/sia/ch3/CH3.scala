import com.ufasoli.sia.ch3.cas.{Query, Person}
import com.ufasoli.sia.ch3.traits.{PersonTrait, SalesPerson, Administrable}
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

    mongoRequestWithQuery()

    namedParameters()
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

    println("me.hashCode : " + me.hashCode())
    println("myself.hashCode : " + myself.hashCode())
    println("me.toString : " + me)
    println("myself.toString : " + myself)

  }

  def mongoRequestWithQuery() {

    val client = mongoClient()
    val db = client.db("sia")

    val col = db.readOnlyCollection("test")

    val writecol = db.updatableCollection("test")

    for(i <- 1 to 100 ) writecol += new BasicDBObject("i", i)

    val rangeQuery = new BasicDBObject("i", new BasicDBObject("$gt", 20))
    val richQuery = Query(rangeQuery).skip(20).limit(10)

    val result = col.find(richQuery)
    println("*****************")
    println("mongoRequestWithQuery")
    println("*****************")
    while (result.hasNext) {
      println(result.next())
    }


  }

  def mongoClient() = {
    new MongoClient("mongo-local", 27017)


  }

  def namedParameters(){
    println("****************")
    println("NAMED PARAMETERS")
    println("****************")
    val p = new Person(lastName = "Fasoli", firstName = "Ulises")

    println(p)

    // you can mix and match named and unnamed arguments but it's not
    // a good practice
    val p2 = new Person("Ulises", lastName = "Fasoli" )

    println(p2)

    println("****************")
    println("NAMED with Inheritance and Override")
    println("****************")

    val s = new SalesPerson
    s.grade(yrs=1)

    // the following will not compile as the subclass SalesPerson redefines
    // the integer value with the name yrs
//    s.grade(years=1)


    // the following will work because we are
    // forcing the type of s2 to PersonTrait and not SalesPerson

     val s2:PersonTrait = new SalesPerson
    println(s2.grade(years = 1))


    val s3 = new SalesPerson
    // the value of the named argument can also be a block
    println("Te following is a calculated value for a named variable")
    println(s3.grade(yrs={val x=10; x+1}))

  }




}