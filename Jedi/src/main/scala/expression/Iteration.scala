package expression

import context.{BreakException, Environment, TypeException}
import value.{Boole, Notification, Value}

case class Iteration(cond: Expression, body: Expression) extends SpecialForm {
  def execute(env: Environment) = {

    while(cond.execute(env) == Boole(true))
      body.execute(env)
    Notification.done
  }
}

