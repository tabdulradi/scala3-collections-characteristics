inThisBuild(
  scalaVersion := "3.1.0"
)

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-collections-characteristics ",
    description := "Part of my Scala 3 training material. All rights reserved",
    version := "0.1.0",
    scalacOptions ++= Seq(
      "-Ykind-projector",
      // "-Yexplicit-nulls",
      "-source", "future",
    )
  )
  .enablePlugins(JmhPlugin)

lazy val bench = 
  project.dependsOn(root % "test->test").enablePlugins(JmhPlugin)