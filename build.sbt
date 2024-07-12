scalaVersion := "3.4.2"
libraryDependencies ++= Seq(
"com.github.ghostdogpr" %% "caliban" % "2.6.0",
"org.postgresql" % "postgresql" % "42.7.3", // or the JDBC driver for your database
"ch.qos.logback" % "logback-classic" % "1.5.6",
"org.slf4j" % "slf4j-api" % "2.0.13",
// ProtoQuill Dependencies
// Syncronous JDBC Modules
"io.getquill" %% "quill-jdbc" % "4.8.5",
// Or ZIO Modules
"io.getquill" %% "quill-jdbc-zio" % "4.8.5",
// Add for Caliban Integration
"io.getquill" %% "quill-caliban" % "4.8.5",
)

enablePlugins(CalibanPlugin)

import _root_.caliban.tools.Codegen

lazy val myproject = project
  // enable caliban codegen plugin
  .enablePlugins(CalibanPlugin)
  .settings(
    // add code generation settings
    Compile / caliban / calibanSettings ++= Seq(
      calibanSetting(file("./exampleAPI.graphql"))(
        // important to set this, otherwise you'll get client code
        _.genType(Codegen.GenType.Schema)
          // you can customize the codegen further with this DSL
          .clientName("exampleAPI.scala")
          .packageName("org.example.api")
      )
    )
  )
