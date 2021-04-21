package expression
import context.{Environment, alu}
import value.{Boole, Notification, Value}

case class Conditional(exp1: Expression, exp2: Expression, exp3: Expression = null) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val res: Value = exp1.execute(env)
    if(!res.isInstanceOf[Boole]) return Notification.unspecified
    if(res.asInstanceOf[Boole].value)
      exp2.execute(env)
    else if(exp2 != null)
      exp3.execute(env)
    else
      Notification.done
  }
}
