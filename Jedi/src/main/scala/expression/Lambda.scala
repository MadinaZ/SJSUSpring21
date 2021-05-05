package expression
import context.Environment
import value.{Closure, Value}

case class Lambda(params: List[Identifier], body: Expression) extends SpecialForm {
  override def execute(env: Environment): Value = new Closure(env, body,params)

}
