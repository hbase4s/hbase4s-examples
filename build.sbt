
lazy val Versions = new {
  val hbase4s = "0.1.1"
}

lazy val hbase4sExamples = (project in file("."))
  .settings(
    scalaVersion := "2.11.8",
    organization := "io.github.hbase4s",
    moduleName := "hbase4s-examples",
    version := "0.1.2",
    licenses := Seq("MIT" -> url("https://opensource.org/licenses/MIT")),
    homepage := Some(url("http://github.com/hbase4s")),
    scalacOptions in ThisBuild ++= Seq(
      "-language:experimental.macros",
      "-target:jvm-1.8",
      "-encoding", "UTF-8",
      "-language:reflectiveCalls",
      "-language:experimental.macros",
      "-language:implicitConversions",
      "-language:higherKinds",
      "-language:postfixOps",
      "-deprecation", // warning and location for usages of deprecated APIs
      "-feature", // warning and location for usages of features that should be imported explicitly
      "-unchecked", // additional warnings where generated code depends on assumptions
      "-Xlint", // recommended additional warnings
      "-Xcheckinit", // runtime error when a val is not initialized due to trait hierarchies (instead of NPE somewhere else)
      "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
      "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
      "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures
      "-Ywarn-dead-code", // Warn when dead code is identified
      "-Ywarn-unused", // Warn when local and private vals, vars, defs, and types are unused
      "-Ywarn-unused-import", //  Warn when imports are unused (don't want IntelliJ to do it automatically)
      "-Ywarn-numeric-widen" // Warn when numerics are widened
    ),
    libraryDependencies ++= Seq(
      "io.github.hbase4s" %% "hbase4s-core" % Versions.hbase4s
    )
  )
