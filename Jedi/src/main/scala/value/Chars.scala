package value

case class Chars(value: String) extends Addable with Ordered[Value] with Equals {
   override def compare(that: Value) = {
    if(this.value < that.toString) -1
    else if(this.value > that.toString) 1
    else 0
  }

  override def +(other: Value) = Chars(this.value + other.toString)
  def size(): Exact = Exact(value.size)
  override def toString: String = value
  override def hashCode(): Int = super.hashCode()

  def subChars(from: Exact, to: Exact): Chars = {
    Chars(value.substring(from.value, to.value))
  }

}
