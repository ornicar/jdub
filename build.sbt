name := "Jdub for Scala 2.9.1"

organization := "com.codahale"

version := "0.0.7-SNAPSHOT"

crossScalaVersions := Seq("2.9.1")

resolvers ++= Seq(
  "Twitter Repository" at "http://maven.twttr.com",
  "repo.codahale.com" at "http://repo.codahale.com/"
)

libraryDependencies <++= scalaVersion { scalaVersion =>
  Seq(
    "com.yammer.metrics" % ("metrics-scala_" + scalaVersion) % "2.0.0-BETA17",
    "com.codahale" % ("logula_" + scalaVersion) % "2.1.3",
    "org.apache.tomcat" % "tomcat-dbcp" % "7.0.22",
    "com.codahale" % ("simplespec_" + scalaVersion) % "0.5.2",
    "org.hsqldb" % "hsqldb" % "2.2.4"
  )
}
