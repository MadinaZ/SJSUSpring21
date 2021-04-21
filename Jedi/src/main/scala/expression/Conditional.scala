package expression
import context.{Environment, alu}
import value.{Boole, Notification, Value}

case class Conditional(val exp1: Expression, val exp2: Expression, val exp3: Expression = null) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val res: Value = exp1.execute(env)
    if(!res.isInstanceOf[Boole]) return Notification.unspecified
    if(res.asInstanceOf[Boole].value)
      exp2.execute(env)
    else if(exp2 != null)
      exp2.execute(env)
    else
      Notification.done
  }
}
