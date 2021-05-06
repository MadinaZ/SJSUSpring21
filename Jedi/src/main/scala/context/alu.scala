package context

import value._
import expression._

import scala.collection.IterableOnce.iterableOnceExtensionMethods
import scala.collection.mutable.ArrayBuffer

object alu {

  def execute(opcode: Identifier, args: List[Value]): Value = opcode.name match {
    case "add" => add(args)            // n-ary
    case "mul" => mul(args)            // n-ary
    case "sub" => sub(args)            // n-ary
    case "div" => div(args)            // n-ary
    case "less" => less(args)          // binary
    case "equals" => same(args)        // binary
    case "more" => more(args)          // binary
    case "unequals" => unequals(args)  // binary
    case "not" => not(args)            // unary
    // TBC
    case "write" => write(args)
    case "cons" => cons(args)
    case "car" => car(args)
    case "cdr" => cdr(args)
    case "dereference" => dereference(args)
    case "var" => makeVar(args)
    case "list" => list(args)
    case "nil" => nil(args)

    case _ => throw new UndefinedException(opcode)
  }

  private def nil(args: List[Value]): Value = {empty}
  private def write(args: List[Value]): Value = { println(args(0)); Notification.done }

  private def dereference(args: List[Value]) = {
    if(args.isEmpty) throw new TypeException("Nothing to dereference")
    args.head.asInstanceOf[Variable].value
  }

  def makeVar(args: List[Value]) = {
    if (args.isEmpty) throw new TypeException("error")
    new Variable(args.head)
  }

  //returns new instance of Pair
  private def cons(args: List[Value]): Value = {
    if(args.size != 2) throw new TypeException("2 inputs required")
    else new Pair(args(0), args(1))
  }

  private def list(args: List[Value]): Value = {
    if(args.size < 2) Pair(args.head,getEmpty())
    else Pair(args.head, list(args.tail))
  }

  private def getEmpty(): Value ={
    empty
  }

    private def car(args:List[Value]) = {
      if(args.size != 1) throw new TypeException("1 input required by car")
      if (!args(0).isInstanceOf[Pair]) throw new TypeException("Pair input required by car")
      args(0).asInstanceOf[Pair].first
    }

  private def cdr(args:List[Value]) = {
    if(args.size != 1) throw new TypeException("1 input required by car")
    if (!args(0).isInstanceOf[Pair]) throw new TypeException("Pair input required by car")
    args(0).asInstanceOf[Pair].second
  }



  private def add(args: List[Value]): Value = {

    def helper(result: Addable, unseen: List[Value]): Addable =
      if(unseen == Nil) result
      else helper(result + unseen.head, unseen.tail)

    if(args.size < 2) throw new TypeException("2 or more inputs required by +")
    args(0) match {
      case n: Addable => helper(args(0).asInstanceOf[Addable], args.tail )
      case _ => throw new TypeException("Inputs to + must be addable")
    }
  }


  private def less(args: List[Value]): Value = {
    if(args.size != 2) throw new TypeException("2 inputs required by <")
    if(!args(0).isInstanceOf[Ordered[Value]]) throw new TypeException("Inputs to < must be orderable")
    Boole(args(0).asInstanceOf[Ordered[Value]] < args(1))
  }

  private def more(args: List[Value]): Value = {
    if(args.size != 2) throw new TypeException("2 inputs required by >")
    if(!args(0).isInstanceOf[Ordered[Value]]) throw new TypeException("Inputs to > must be orderable")
    Boole(args(0).asInstanceOf[Ordered[Value]] > args(1))
  }

  private def same(args: List[Value]): Value = {
    if(args.size != 2) throw new TypeException("2 inputs required by same")
    Boole(args(0) == args(1))
  }

  private def unequals(args: List[Value]): Value = {
    if(args.size != 2) throw new TypeException("2 inputs required by unequals")
    Boole(!args(0).equals(args(1)))
  }

  private def not(args: List[Value]): Value = {
    if(!args(0).isInstanceOf[Boole]) throw new TypeException("Must be Boole")
    !args(0).asInstanceOf[Boole]
  }

  private def mul(args: List[Value]): Value = {

    def helper(result: Numeric, unseen: List[Value]): Addable =
      if(unseen == Nil) result
      else helper(result * unseen.head, unseen.tail)

    if(args.size < 2) throw new TypeException("2 or more inputs required by +")
    args(0) match {
      case n: Addable => helper(args(0).asInstanceOf[Numeric], args.tail )
      case _ => throw new TypeException("Inputs to + must be addable")
    }
  }

  private def div(args: List[Value]): Value = {

    def helper(result: Numeric, unseen: List[Value]): Addable =
      if(unseen == Nil) result
      else helper(result / unseen.head, unseen.tail)

    if(args.size < 2) throw new TypeException("2 or more inputs required by +")
    args(0) match {
      case n: Addable => helper(args(0).asInstanceOf[Numeric], args.tail )
      case _ => throw new TypeException("Inputs to + must be addable")
    }
  }

  private def sub(args: List[Value]): Value = {

    def helper(result: Numeric, unseen: List[Value]): Addable =
      if(unseen == Nil) result
      else helper(result - unseen.head, unseen.tail)

    if(args.size < 2) throw new TypeException("2 or more inputs required by +")
    args(0) match {
      case n: Addable => helper(args(0).asInstanceOf[Numeric], args.tail )
      case _ => throw new TypeException("Inputs to + must be addable")
    }
  }


}