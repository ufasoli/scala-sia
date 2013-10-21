package com.ufasoli.kanban

import scalaz._
import Scalaz._
import scalaz.http._
import response._
import request._
import servlet._
import HttpServlet._
import Slinky._

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 18.10.13
 * Time: 17:51
 *
 */
final class WeKanbanApplication extends StreamStreamServletApplication {
  val application = new ServletApplication[Stream, Stream] {
    def application(implicit servlet: HttpServlet, servletRequest:
    HttpServletRequest, request: Request[Stream]) = {
      def found(x: Iterator[Byte]) : Response[Stream] = OK << x.toStream
      println("************************************")
      HttpServlet.resource(found, NotFound.xhtml)
    }
  }
}
