package value

import context.Environment
import expression.{Expression, SpecialForm}

class Thunk(body: Expression, defEnv: Environment) extends Closure(defEnv, body, Nil){
  private var cache: Value = null;

  def apply()  = {
    if(cache == null) {
      cache = super.apply(Nil)
    }
    cache
  }

}

