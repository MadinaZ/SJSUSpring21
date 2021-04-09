package value

import context.{IllegalValueException, TypeException}

case class Inexact(val value: Double) extends Numeric with Ordered[Value] {
  override def *(other: Value): Numeric =
    other match {
//      case x: Exact => Exact(this.value + x.value)
      case x: Inexact => Inexact(this.value.toDouble * x.value)
      case _ => throw new TypeException("Numeric operand required")
    }

  override def /(other: Value): Numeric =
    other match {
      //      case x: Exact => Exact(this.value / x.value)
      case x: Inexact => {
        if(x.value == 0) throw new IllegalValueException("Divided by 0")
        Inexact(this.value.toDouble / x.value)
      }
      case _ => throw new TypeException("Numeric operand required")
    }

  override def -(other: Value): Numeric =
    other match {
//      case x: Exact => Exact(this.value + x.value)
      case x: Inexact => Inexact(this.value.toDouble - x.value)
      case _ => throw new TypeException("Numeric operand required")
    }

  override def +(other: Value): Addable =
    other match {
      //      case x: Exact => Exact(this.value + x.value)
      case x: Inexact => Inexact(this.value.toDouble + x.value)
      case _ => throw new TypeException("Numeric operand required")
    }

  override def unary_-(): Numeric = Inexact(-this.value)

  override def compare(that: Value): Int =
    that match {
      case x: Exact => this.value.compare(x.value)
      case x: Inexact => this.value.toDouble.compare(x.value)
      case _ => throw new TypeException("Arguments must be comparable")
    }

  override def toString: String = this.value.toString
}
