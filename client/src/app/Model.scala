package app


case class Model(counter: Int)

object Model {

  val initial: Model = Model(0)

  def reduce(model: Model, action: Action): Model =
    action match {
      case Action.Increment(value) => model.copy(counter = model.counter + value)
    }
}

sealed trait Action
object Action {
  case class Increment(value: Int) extends Action
}