package expression
import context.Environment
import value.Value

case class Block(exps: List[Expression]) extends SpecialForm {
  override def execute(env: Environment) = {
    val tempEnv = new Environment(env)
//    val results: List[Value] = exps.map(exp => exp.execute(tempEnv))
//    results.last
//    if(exps.tail.size == 0) exps.head.execute(tempEnv)
//    else {exps.head.execute(tempEnv); Block(exps.tail).execute(tempEnv)}
    if(exps.tail.size == 0) exps.head.execute(tempEnv) else {exps.head.execute(tempEnv); Block(exps.tail).execute(tempEnv)}
  }
}
