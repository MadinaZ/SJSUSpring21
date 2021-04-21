package expression
import context.{Environment, UndefinedException, alu}
import value.Value

case class FunCall(val identifier: Identifier, operands: List[Expression]) extends Expression {
  override def execute(env: Environment): Value = {
    val ops = operands.map(_.execute(env))
    try{
      alu.execute(identifier, ops)
    }
    catch {
      case e: UndefinedException => throw e
      case e: Exception => throw e
    }
  }
}
