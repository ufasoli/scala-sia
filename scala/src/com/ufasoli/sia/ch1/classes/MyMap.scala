package com.ufasoli.sia.ch1.classes

import scala.language.dynamics
/**
 *
 * User: ufasoli
 * Date: 03/07/13
 * Time: 13:55
 * project : scala
 */
class MyMap extends Dynamic {
  private val map = Map("foo" -> "1", "bar" -> 2)

  /**
   * this method will be called automatically
   * when an unknown method of the MyMapClass is invoked
   * @param fieldName  the name of the map key
   * @return the value associated with the map key or None if the key doesn't exists
   */
  def selectDynamic(fieldName: String) = map.get(fieldName)


}
