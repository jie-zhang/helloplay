name := "helloplay"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  jdbc,
  anorm,
  cache,
  "com.novus" %% "salat" % "1.9.5"
)     

play.Project.playScalaSettings


// add by jie-zhang@2014/02/26:
// For [routes] file to recognize the [ObjectId] type.
routesImport += "se.radley.plugin.salat.Binders._"

templatesImport += "org.bson.types.ObjectId"

