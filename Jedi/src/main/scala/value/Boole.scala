package value

import expression.Literal

case class Boole(value: Boolean) extends Literal {
    def &&(other: Boole): Boole = Boole(this.value && other.value)
    def ||(other: Boole): Boole = Boole(this.value || other.value)
    def unary_!(): Boole = Boole(!value)

  override def toString = this.value.toString
  override def hashCode(): Int = super.hashCode()

  override def equals(other: Any): Boolean =
    other match {
      case x: Boole => x.isInstanceOf[Boole] && x.value == this.value
      case _ => false
    }
}

//object Boole {
//  def apply(bool: Boolean) = new Boole(bool)
//  val FALSE: Boolean = false
//  val TRUE: Boolean = true
//}


