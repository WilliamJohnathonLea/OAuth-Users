name := "OAuth-Users"

version := "1.0"

scalaVersion := "2.12.2"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

libraryDependencies ++= Seq(
  "org.reactivemongo" %% "play2-reactivemongo" % "0.12.4-play26"
)
