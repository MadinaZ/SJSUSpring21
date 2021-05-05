package expression
import context.Environment
import value.Value

case class Block(exps: List[Expression]) extends SpecialForm {
  override def execute(env: Environment): Value = {
    val tempEnv = new Environment(env)
    val results: List[Value] = exps.map(exp => exp.execute(tempEnv))
    results.last
  }
}
