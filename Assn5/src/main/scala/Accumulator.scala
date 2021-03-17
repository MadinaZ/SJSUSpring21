trait Instruction {
  def execute(reg: Int): Int
}

class Add(val arg: Int) extends Instruction {
  def execute(reg: Int): Int = reg + arg
}

object Add {
  def apply(arg: Int) = new Add(arg)
}

class Mul(val arg: Int) extends Instruction {
  def execute(reg: Int): Int = reg * arg
}

object Mul {
  def apply(arg: Int) = new Mul(arg)
}

object Accumulator{
  var register = 0
  var program: List[Instruction] = List[Instruction]()
  def run() = {
    for(i <- program)
      register = i.execute(register)
  }
}

object TestAccumulator extends App{
  Accumulator.program = List(Add(3), Mul(5), Add(1), Mul(2))
  Accumulator.run()
  println(Accumulator.register)                     //> res6: Int = 32
  // computing (((10 * 2) + 3) * 5)
  Accumulator.register = 0
  Accumulator.program = List(Add(10), Mul(2), Add(3), Mul(5))
  Accumulator.run()
  println(Accumulator.register)                     //> res6: Int = 32
}
