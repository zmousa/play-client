name := """play-client"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)
libraryDependencies += "com.fasterxml.jackson.core" % "jackson-databind" % "2.7.6"
libraryDependencies += "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.7.6"
