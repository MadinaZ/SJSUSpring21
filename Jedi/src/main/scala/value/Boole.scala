package value

import expression.Literal

case class Boole(value: Boolean) extends Literal {
    def &&(other: Boole) = Boole(this.value && other.value)
    def ||(other: Boole) = Boole(this.value || other.value)
    def unary_-() = Boole(!this.value)

  override def toString = this.value.toString
  override def hashCode(): Int = super.hashCode()

  override def equals(other: Any): Boolean =
    other match {
      case x: Boole => x.isInstanceOf[Boole] && x.value == this.value
    }
}
