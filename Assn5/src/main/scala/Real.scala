//
//class Real(val scalaValue: Double) extends Ordered[Real] with Equals {
//  //  def * (other: Real) = Real(this.scalaValue * other.scalaValue)
//  def *(other: Real) = this.scalaValue * other.scalaValue
//
//  override def compare(that: Real): Int = scalaValue.compareTo(that.scalaValue)
//
//  override def <(other: Real): Boolean = this.scalaValue.compare(other.scalaValue) < 0
//
//  def ==(other: Real): Boolean = this.scalaValue.equals(other.scalaValue)
//
//  override def canEqual(that: Any): Boolean = true
//}
//
//object RealTest extends App {
//  def apply(scalaValue: Double) = new Real(scalaValue)
//
//  var r1 = Real(3.14)
//  var r2 = Real(2.71)
//  println("r1 * r2 = " + (r1 * r2))
//  println("r1 == r2 = " + (r1 == r2))
//  println("r1 < r2 = " + (r1 < r2))
//}

