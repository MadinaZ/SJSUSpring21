package expression

import context.{Environment, TypeException}
import value.{Notification, Value, Variable}

case class Assignment(left: Identifier, right: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val variable = left.execute(env)
    variable match {
      case v: Variable =>
        v.value = right.execute(env)
        Notification.done
      case _ => throw new TypeException("Can't assign non-variable")
    }
  }
}
