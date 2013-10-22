package com.ufasoli.kanban.model


import org.squeryl._
import org.squeryl.PrimitiveTypeMode._
import org.squeryl.annotations._
import config.KanbanSchema._

class Story(val number: String, val title: String, val phase: String) {

  private[this] def validate = {
    if (number.isEmpty || title.isEmpty) {
            throw new ValidationException("Both number and title are required")
    }

    if(!stories.where(a => a.number === number).isEmpty){
      throw new ValidationException("The story number is not unique")
    }
  }
}

class ValidationException(message: String) extends RuntimeException(message)
