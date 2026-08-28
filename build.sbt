name := "scala-akka-actors"
version := "1.0.0"
scalaVersion := "3.4.0"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % "2.9.0",
  "com.typesafe.akka" %% "akka-stream" % "2.9.0",
  "ch.qos.logback" % "logback-classic" % "1.5.0",
  "org.scalatest" %% "scalatest" % "3.2.18" % Test
)
