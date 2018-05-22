lazy val scalaexamples =
  (project in file(".")).
    settings(
      name := "scalaexamples",
      organization := "com.wiladamec",
      version := "1.0",
      scalaVersion := "2.12.6",
      test in assembly := {},
      parallelExecution in Test := false
    )
