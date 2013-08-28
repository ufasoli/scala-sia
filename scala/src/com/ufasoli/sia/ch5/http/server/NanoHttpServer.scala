package com.ufasoli.sia.ch5.http.server

import Pure._
import java.io.File
import scala.io.Source

/**
 *
 * User: ufasoli
 * Date: 28/08/13
 * Time: 15:12
 * project : scala-sia
 */
object NanoHttpServer {

  case class IOResource(name:String) extends Resource{

    def exists: Boolean = new File(name).exists

    def contents: List[String] = Source.fromFile(new File(name)).getLines.toList

    def contentLenght: Int = Source.fromFile(new File(name)).count(x => true)
  }

  implicit val ioResourceLocator: ResourceLocator = name => IOResource(name)

}
