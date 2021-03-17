//import scala.collection.mutable.ArrayBuffer
//
//trait Instruction {
//  var arr: ArrayBuffer[Int]
//  def execute(reg: Int): Int
//}
//
//class Push(val arg: Int) extends Instruction {
//  def execute(reg: Int):Int = {
//    override arr += arg
//    reg
//  }
//
//}
//
//object Push {
//  def apply(arg: Int) = new Push(arg)
//}
//
//
//class Pop() extends Instruction {
//  def execute(reg: Int) = arr.remove(arr.size-1)
//}
//
//object Pop {
//  def apply() = new Pop()
//}
//
//
//class Top() extends Instruction {
//  def execute(reg: Int) = { arr(arr.size-1) }
//}
//
//object Top {
//  def apply() = new Top()
//}
//
//
//
//class Sum() extends Instruction {
//  def execute(reg: Int) = {
//    reg + arr.last
//    Pop()
//    reg + arr.last
//  }
//}
//
//object Sum {
//  def apply() = new Sum()
//}
//
//class Times() extends Instruction {
//  def execute(reg: Int) = {
//    reg * arr.last
//    Pop()
//    reg * arr.last
//  }
//}
//
//object Times {
//  def apply() = new Times()
//}
//
//
//object StackMachine{
//  var register = 0
//  var program: List[Instruction] = List[Instruction]()
//  def run() = {
//    for(i <- program)
//      register = i.execute(register)
//
//  }
//}
//
//
//object TestStackMachine extends App{
//  StackMachine.program = List(Push(3), Push(4), Push(5), Sum(), Times(), Top())
//  StackMachine.run()
//  println(StackMachine.register)
//}

