import scala.collection.mutable.ArrayBuffer

var arr: ArrayBuffer[Int] = ArrayBuffer[Int]()

trait Instruction {
  def execute()
}

class Push(val arg: Int) extends Instruction {
  def execute() ={
    arr += arg
  }
}

object Push {
  def apply(arg: Int) = new Push(arg)
}


class Pop() extends Instruction {
  def execute() ={
    if(arr.size == 0) throw new IllegalArgumentException
    arr.remove(arr.size-1)
  }
}

object Pop {
  def apply() = new Pop()
}


class Top() extends Instruction {
  def execute() = {print(arr(arr.size-1))  }
}

object Top {
  def apply() = new Top()
}



class Sum() extends Instruction {
  def execute() = {
    if(arr.size == 0) throw new IllegalArgumentException

    var value = arr(arr.size-1)
    arr.remove(arr.size-1)
    value = value + arr(arr.size-1)
    arr.remove(arr.size-1)
    arr += value
  }
}

object Sum {
  def apply() = new Sum()
}

class Times() extends Instruction {
  def execute() = {
    if(arr.size == 0) throw new IllegalArgumentException

    var value = arr(arr.size-1)
    arr.remove(arr.size-1)
    value = value * arr(arr.size-1)
    arr += value
  }
}

object Times {
  def apply() = new Times()
}


object StackMachine{
  var program: List[Instruction] = List[Instruction]()
  def run() = {
    for(i <- program){
      i.execute()
    }
  }
}



StackMachine.program = List(Push(3), Push(4), Push(5), Sum(), Times(), Top())
StackMachine.run()

StackMachine.program = List(Push(10), Push(10), Times(), Push(20), Sum(), Top())
StackMachine.run()



