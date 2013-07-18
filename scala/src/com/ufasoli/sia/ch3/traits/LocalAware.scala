package com.ufasoli.sia.ch3.traits

import com.mongodb.DBObject

/**
 * Retrieves documents according to the machine's locale
 * User: ufasoli
 * Date: 12/07/13
 * Time: 17:03
 * project : scala-sia
 */
trait LocalAware  extends ReadOnly{

  override def findOne(doc:DBObject) = {
    // add the locale to the query based on the local machine's locale
    doc.put("locale", java.util.Locale.getDefault.getLanguage)
    super.findOne(doc)
  }


  override def find(doc:DBObject) = {
    // add the locale to the query based on the local machine's locale
    doc.put("locale", java.util.Locale.getDefault.getLanguage)
    super.find(doc)
  }
}
