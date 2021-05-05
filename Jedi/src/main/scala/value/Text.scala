package value

import context.Environment
import expression.Expression

class Text(val body: Expression) extends Value {
  def apply(env: Environment) = ???

}
