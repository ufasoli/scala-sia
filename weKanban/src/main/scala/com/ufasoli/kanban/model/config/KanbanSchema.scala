package com.ufasoli.kanban.model.config

import org.squeryl._
import com.ufasoli.kanban.model.Story
import java.sql.DriverManager
import org.squeryl.adapters._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.adapters.H2Adapter

object KanbanSchema extends Schema{

  val stories = table[Story]("STORIES")

  def main(args:Array[String]){
    println("Initializing the weKanban schema")
    init
    inTransaction { drop ; create }
  }

  def init = {
    import org.squeryl.SessionFactory
    Class.forName("org.h2.Driver")

    if(SessionFactory.concreteFactory.isEmpty){
      SessionFactory.concreteFactory = Some(() =>
        Session.create(DriverManager.getConnection("jdbc:h2:tcp:localhost/~/test", "sa","" ), new H2Adapter)
      )
    }
  }

}
