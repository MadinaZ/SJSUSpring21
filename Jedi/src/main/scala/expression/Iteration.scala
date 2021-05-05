package expression

import context.{BreakException, Environment, TypeException}
import value.{Boole, Notification, Value}

case class Iteration(cond: Expression, body: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = {
    var result: Value = Notification.ok
    var condVal = cond.execute(env)
    var break = false

    while(!break && condVal.isInstanceOf[Boole] && condVal.asInstanceOf[Boole].value) {
      try {
        result = body.execute(env)
        condVal = cond.execute(env)
      }
      catch {
        case be: BreakException => break = true
        case e: Exception => throw e
      }
    }

    if(!condVal.isInstanceOf[Boole]) throw new TypeException("While loops need Booles")

    result
  }
}
