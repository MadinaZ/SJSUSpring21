package expression

import context.{BreakException, Environment, TypeException}
import value.{Boole, Notification, Value}

case class Iteration(cond: Expression, body: Expression) extends SpecialForm {
  def execute(env: Environment) = {

    while(cond.execute(env) == Boole(true))
      body.execute(env);
    Notification.done
  }
}



//    var result: Value = Notification.unspecified
//    var exe1 = cond.execute(env)
//    if (!exe1.isInstanceOf[Boole]) throw new TypeException("parameter must be boolean.")
//    var exe2 = exe1.asInstanceOf[Boole]
//    while(exe2.value) {
//      result = body.execute(env)
//      exe1 = cond.execute(env)
//      if (!exe1.isInstanceOf[Boole]) throw new TypeException("parameter must be boolean.")
//      exe2 = exe1.asInstanceOf[Boole]
//    }
//    result