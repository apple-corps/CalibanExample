## To build the API

sbt

calibanGenSchema ./exampleAPI.graphql ./src/main/scala/org/example/api/exampleAPI.scala
--addDerives true --scalarMappings ID:Long
