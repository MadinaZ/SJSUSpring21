package expression
import context.{Environment, TypeException, UndefinedException, alu, flags}
import value.{Closure, Thunk, Value}

case class FunCall(val identifier: Identifier, operands: List[Expression]) extends Expression {
  override def execute(env: Environment): Value = {

    val args: List[Value] = operands.map(_.execute(env))//result of evaluating operands

    try{
      identifier.execute(env).isInstanceOf[Closure]
      return identifier.execute(env).asInstanceOf[Closure].apply(args)
    }
    catch{
      case e: UndefinedException => return alu.execute(identifier, args)
      case e: Exception => throw e
    }

    }

}
