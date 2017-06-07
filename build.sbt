import com.atlassian.labs.gitstamp.GitStampPlugin._

// Place useful git info in MANIFEST.MF
Seq(gitStampSettings: _*)

lazy val scalaexamples =
  (project in file(".")).
    settings(
      name := "scalaexamples",
      organization := "com.wiladamec",
      version := "1.0",
      scalaVersion := "2.11.8",
      test in assembly := {},
      parallelExecution in Test := false
    )
