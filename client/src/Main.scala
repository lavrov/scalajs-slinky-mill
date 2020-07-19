
import app.component._
import app.{Action, Model}
import org.scalajs.dom
import slinky.core.FunctionalComponent
import slinky.core.facade.Hooks
import slinky.web.ReactDOM

import scala.scalajs.js.annotation.JSExportTopLevel

object Main {

  def initialize(dispatch: Action => Unit): Unit = {
    // make requests, open websocket connection etc
  }

  private val Root = FunctionalComponent[Unit] { _ =>

    val (state, dispatch) = Hooks.useReducer[Model, Action](Model.reduce, Model.initial)

    Hooks.useEffect(() => initialize(dispatch), List.empty)

    App(state, dispatch)
  }

  @JSExportTopLevel("main")
  def main(): Unit = {

    ReactDOM.render(
      Root(),
      dom.document.getElementById("root")
    )
  }
}
