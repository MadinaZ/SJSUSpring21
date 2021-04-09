package value

import context.TypeException
import expression.Literal

 class Boole(val value: Boolean) extends Literal {
    def &&(other: Value):Boole=
      other match {
      case other: Boole => Boole(this.value && other.value)
      case  _ => throw new TypeException("Type Error")
      }

   def ||(other: Value):Boole =
     other match {
     case _ => throw new TypeException("Type Error")
     case other: Boole => Boole(other.value || this.value)
   }

    def unary_! = Boole(!this.value)

  override def toString = value.toString
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
