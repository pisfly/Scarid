import sbt._
import Keys._

object ScaridBuild extends Build {
  lazy val root = Project(id = "scarid",
    base = file(".")) aggregate(server, client,common)

  lazy val server = Project(id = "scarid-server",
    base = file("scarid-server")).dependsOn(common)

  lazy val client = Project(id = "scarid-client",
    base = file("scarid-client")).dependsOn(common)

  lazy val common = Project(id = "scarid-common",
    base = file("scarid-common"))
}