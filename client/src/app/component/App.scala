package app.component

import app.{Action, Model}
import slinky.core.FunctionalComponent
import slinky.core.annotations.react
import slinky.core.facade.Hooks
import slinky.web.html._
import typings.material_ui.core._
import typings.material_ui.styles._

import scala.scalajs.js.Dynamic

@react
object App {
  case class Props(model: Model, dispatch: Action => Unit)

  private val useStyles = makeStyles(theme =>
    Dynamic.literal(
      appBarSpacer = theme.mixins.toolbar,
      appBarTitle = Dynamic.literal(
        flexGrow = 1
      ),
      navLink = Dynamic.literal(
        margin = theme.spacing(1, 1.5)
      ),
      centered = Dynamic.literal(
        textAlign = "center"
      )
    )
  )

  val component = FunctionalComponent[Props] { props =>

    val classes = useStyles()

    Hooks.useState()

    div(
      div(className := classes.appBarSpacer.toString),
      AppBar(position = "fixed")(
        Container(maxWidth = "md")(
          Toolbar(disableGutters = true)(
            Link(
              className = classes.appBarTitle.toString,
              href = "#",
              color = "inherit")(
              Typography(variant = "h6")(
                "Example"
              )
            ),
            Link(
              className = classes.navLink.toString,
              href = "https://github.com/lavrov/scalajs-slinky-mill",
              color = "inherit")(
              "GitHub"
            )
          )
        )
      ),
      main(
        Container(maxWidth = "md")(
            p(className := classes.centered.toString)(
              s"Counter: ${props.model.counter}"
            ),
            p(className := classes.centered.toString)(
              Button(
                onClick := { () => props.dispatch(Action.Increment(1)) } )(
                "Increment"
              )
            )
        )
      )
    )
  }
}

