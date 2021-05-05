package value

import context.{Environment, JediException, TypeException, flags}
import expression.{Expression, Identifier}

case class Closure(defEnv: Environment, body: Expression, params: List[Identifier]) extends Value {
  def apply(args: List[Value], env: Environment = null): Value ={
    if(args.length != params.length) throw new JediException("Wrong number of arguments")
    val closureEnv = new Environment(defEnv)
    closureEnv.bulkPut(params, args)
    body.execute(closureEnv)

  }

}
