import scala.math.Ordering.Implicits._

ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / crossScalaVersions := Seq("2.13.9", "3.2.1")
ThisBuild / scalaVersion := "3.2.1"

def scala3(scalaVer: String) = CrossVersion.partialVersion(scalaVer).exists(_ >= (3, 0))

lazy val root = (project in file("."))
  .settings(
    name := "borerScala3Error",

    libraryDependencies ++= {
      if (scala3(scalaVersion.value)) Seq(
        "io.bullet" %% "borer-core" % "1.10.2",
        "io.bullet" %% "borer-derivation" % "1.10.2"
      ) else Seq(
        "io.bullet" %% "borer-core" % "1.7.2",
        "io.bullet" %% "borer-derivation" % "1.7.2"
      )
    },

  )
