package expression
import context.{Environment, TypeException}
import value.{Boole, Value}

case class Conjunction(exps: List[Expression]) extends SpecialForm {
  override def execute(env: Environment): Value = {
    var res = true
    for(exp <- exps if res){
      val x = exp.execute(env)
      if(!x.isInstanceOf[Boole]) throw new TypeException("Must be Boole")
      res = x.asInstanceOf[Boole].value && res
    }
    Boole(res)
  }
}
