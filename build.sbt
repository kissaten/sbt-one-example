// import Dependencies._

// This an example of a simple project definition.
// It should build on both sbt 0.13.15 and sbt 1.0.0-M5
lazy val root = (project in file("."))
  .settings(
    organization in ThisBuild := "com.example",
    scalaVersion in ThisBuild := "2.12.2",
    version      in ThisBuild := "0.1.0-SNAPSHOT",
    name := "Hello",
    test in assembly := {},
    mainClass in assembly := Some("example.Server"),
    assemblyJarName in assembly := "hello.jar",
    assemblyMergeStrategy in assembly := {
      case "META-INF/io.netty.versions.properties" => MergeStrategy.first
      case "BUILD" => MergeStrategy.first
      case x =>
        val oldStrategy = (assemblyMergeStrategy in assembly).value
        oldStrategy(x)
    },
    libraryDependencies ++= Seq(
      "com.twitter" % "finagle-http_2.12" % "6.43.0"
    )
  )
