scalaVersion := "3.4.2"
libraryDependencies ++= Seq(
"com.github.ghostdogpr" %% "caliban" % "2.6.0"

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
