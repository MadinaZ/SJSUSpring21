package value

import context.TypeException
import expression.Literal

 class Boole(val value: Boolean) extends Literal {
   def &&(other: Boole):Boole = Boole(this.value && other.value)
   def ||(other: Boole):Boole = Boole(other.value || this.value)
   def unary_! = Boole(!this.value)

   override def toString: String = value.toString
   override def hashCode(): Int = super.hashCode()

  override def equals(other: Any): Boolean =
    other match {
      case other: Boole => other.isInstanceOf[Boole] && other.value == this.value
      case _ => false
    }
}

object Boole {
  def apply(bool: Boolean): Boole = new Boole(bool)
  val FALSE: Boole = Boole(false)
  val TRUE: Boole = Boole(true)
}
