import mill._
import mill.scalalib._
import mill.scalalib.scalafmt.ScalafmtModule
import mill.scalajslib._


object client extends JsModule {
  def ivyDeps = Agg(
    ivy"me.shadaj::slinky-web::${Versions.slinky}",
  )

  /**
   * fastOpt deletes whole dest directory which breaks webpack hot reload
   */
  def compileJs: T[PathRef] = T {
    val fastOptDir = fastOpt().path / os.up
    val outputDir = T.ctx.dest
    os.copy.over(fastOptDir, outputDir, replaceExisting = true)
    PathRef(outputDir)
  }
}

trait Module extends ScalaModule with ScalafmtModule {
  def scalaVersion = "2.13.2"
  def scalacOptions = List(
    "-language:higherKinds",
    "-Ymacro-annotations",
  )

  def scalacPluginIvyDeps = Agg(
    ivy"org.typelevel:::kind-projector:0.11.0",
    ivy"com.olegpy::better-monadic-for:0.3.1",
  )
  trait TestModule extends Tests {
    def ivyDeps = Agg(
      ivy"org.scalameta::munit:0.7.9",
    )
    def testFrameworks = Seq("munit.Framework")
  }
}

trait JsModule extends Module with ScalaJSModule {
  def scalaJSVersion = "1.1.0"
  def moduleKind = mill.scalajslib.api.ModuleKind.CommonJSModule
}

object Versions {
  val slinky = "0.6.5"
}

