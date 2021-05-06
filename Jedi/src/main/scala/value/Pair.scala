package value

import expression.Identifier

case class Pair(value1: Value, value2: Value) extends Value {
  var first = value1
  val second = value2

  override def toString: String = "(" + first.toString + second.toString + ")"
}
