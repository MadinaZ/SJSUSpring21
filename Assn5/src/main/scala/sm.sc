trait Instruction {
  def execute()
}

object StackMachine{
  var register = 0
  var program: List[Instruction] = List[Instruction]()
  def run() = {
    for(i <- program)
      register = i.execute(register)
  }
}

object TestStackMachine extends App{
  StackMachine.program = List(Push(3), Push(4), Push(5), Sum(), Times(), Top())
  StackMachine.run()
}

