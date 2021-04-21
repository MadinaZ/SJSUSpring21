package expression
import context.Environment
import value.{Notification, Value}

case class Declaration(x: Identifier, exp: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = {
    env.put(x, exp.execute(env))
    Notification.ok
  }
}
