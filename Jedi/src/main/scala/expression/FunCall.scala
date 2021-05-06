package expression
import context.{Environment, TypeException, UndefinedException, alu, flags}
import value.{Closure, Thunk, Value}

case class FunCall(val identifier: Identifier, operands: List[Expression]) extends Expression {
  override def execute(env: Environment): Value = {

//    if(env.contains(identifier)){
//      var args: List[Value] = Nil
//      if(flags.paramPassing == flags.BY_NAME){
//        args = operands.map(MakeThunk(_).execute(env))
//      }
//      else
//        args = operands.map(_.execute(env))
//    }
//
//    try{
//
//      identifier.execute(env).isInstanceOf[Closure]
//      return identifier.execute(env).asInstanceOf[Closure].apply(args)
//
//    }
//    catch{
//      case e: UndefinedException => return alu.execute(identifier, args)
//      case e: Exception => throw e
//    }


//    var args: List[Value] = Nil
//
//    if (env.contains(identifier)) {
//      if (flags.paramPassing == flags.BY_NAME) {
//        args = operands.map(new Thunk(_, env))
//      } else { //by ref
//        args = operands.map(_.execute(env))
//      }
//      env(identifier).asInstanceOf[Closure].apply(args)
//    } else {
//      args = operands.map(_.execute(env))
//      alu.execute(identifier, args)
//    }
//  }

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

//case class FunCall(val operator: Identifier, val operands: List[Expression]) extends Expression {
//
//
//  def execute(env: Environment): Value = {
//
//    try {
//      val maybeClosure = operator.execute(env)
//      if (maybeClosure.isInstanceOf[Closure]) {
//        val closure = maybeClosure.asInstanceOf[Closure]
//        val args = flags.paramPassing match {
//          case flags.BY_REF => operands.map(_.execute(env))
//          case flags.BY_NAME => operands.map(new Thunk(_, env))
//        }
//        closure(args, env)
//      } else {
//        throw new TypeException("Only functions")
//      }
//    } catch {
//      case e: UndefinedException =>
//        val args = operands.map(_.execute(env))
//        alu.execute(operator, args)
//    }
//  }
//}
