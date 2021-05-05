package expression

import context.Environment
import value.{Text, Thunk, Value}

case class Identifier(val name: String) extends Expression {
  override def toString = name
   def execute(env: Environment) = {
     val result: Value = env(this)
     result match {
       case thunk: Thunk => thunk.apply()
       case _ => result
     }
   }
}
