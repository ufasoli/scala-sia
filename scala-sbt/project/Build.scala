
import sbt._
import Keys._

import scala.collection.parallel.Task

object ExampleBuild extends Build {
  val hello = TaskKey [Unit]("hello", "Prints 'Hello World'")

  val helloTask: Setting[Task[Unit]] = hello := {
    println("Hello World")
  }
  val project = Project (
    "example",
    file (".")).settings(helloTask)
}

