name := "vulnerable-scala-app"

version := "0.1"

scalaVersion := "2.13.6"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-blaze-server" % "0.21.24", // Dependency issue
  "org.http4s" %% "http4s-dsl" % "0.21.24",
  "org.tpolecat" %% "doobie-core" % "0.9.0" // Placeholder for database interaction
)