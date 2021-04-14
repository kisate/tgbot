version := "0.1"

scalaVersion := "2.13.5"

lazy val root = project.in(file("."))
  .settings(
    name := "tgbot",
    Compile / mainClass := Some("bot.Main"),
    run / mainClass := Some("bot.Main"),
    libraryDependencies += "org.augustjune" %% "canoe" % "0.5.1",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.5" % "test"
  )
  .settings(
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision,
    scalacOptions += "-Ywarn-unused"
  )