ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.8"

lazy val root = (project in file("."))
  .settings(
    name := "HelloWorld"
  )
lazy val akkaHttpVersion = "10.2.8"
lazy val akkaVersion     = "2.6.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http"           % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-actor"          % akkaVersion,
  "com.typesafe.akka" %% "akka-stream"         % akkaVersion
)