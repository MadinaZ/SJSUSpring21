package expression
import context.{Environment, TypeException, UndefinedException, alu, flags}
import value.{Closure, Thunk, Value}

case class FunCall(val identifier: Identifier, operands: List[Expression]) extends Expression {
  override def execute(env: Environment): Value = {
      var args: List[Value] = Nil

      if (env.contains(identifier)) {
        if (flags.paramPassing == flags.BY_NAME) {
          args = operands.map(new Thunk(_, env))
        } else {
          args = operands.map(_.execute(env))
        }
        identifier.execute(env) match {
          case f: Closure => f.apply(args, env)
          case _ => throw new TypeException("Only functions")
        }
      } else {
        args = operands.map(_.execute(env))
        alu.execute(identifier, args)
      }
    }

}
