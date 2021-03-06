name := "weKanban"

organization := "scalainaction"

version := "0.1"

scalaVersion := "2.10.0"

scalacOptions ++= Seq("-unchecked", "-deprecation")

libraryDependencies ++= Seq(
  "org.scalaz" %% "scalaz-core" % "6.0.3",
  "org.scalaz" %% "scalaz-http" % "6.0.3",
  "org.mortbay.jetty" % "jetty" % "6.1.22" % "container",
  "org.scala-tools.testing" % "specs" % "1.6.2" % "test",
  "com.h2database"%"h2"%"1.2.137",
  "org.squeryl" % "squeryl_2.10" % "0.9.5-6"
  )

seq(webSettings :_* )