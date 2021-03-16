package Mathematics

import scala.math.sqrt

object poly {

  def roots(p: (Double, Double, Double)): Option[(Double, Double)] = {
    // = None if p has no real roots
    // = Some((r1, r2)) where p(r1) == p(r2) == 0
    if (p._2 * p._2 - 4.0 * p._1 * p._3 < 0) None
    else Some(
      (-p._2 + sqrt(p._2 * p._2 - 4.0 * p._1 * p._3)) / (2 * p._1),
      (-p._2 - sqrt(p._2 * p._2 - 4.0 * p._1 * p._3)) / (2 * p._1))
  }

  def deriv(p: (Double, Double, Double)): (Double, Double, Double) ={
    var n = 3
    if(p._3 == 0) n = 1
    else n = 0
    val x = p._1*(p.productArity - 1 - n)
    val y = p._2 * (p.productArity - 2 - n)
    val z = p._3 * (p.productArity - 3)
    (x, y, z)
  }
  // = derivative of p (which should be degree 1

  def eval(a: Double, p: (Double, Double, Double)): Double = {
    (p._1 * a * a) + (p._2 * a) + p._3
  }
  // = p(a)
}

object PolyTest extends App {
  val p = (3.0, 9.0, -30.0) // = (3x - 6) * (x + 5)

  println("eval(6, p) = " + poly.eval(6, p))
  println("eval(2, p) = " + poly.eval(2, p))
  println("eval(-5, p) = " + poly.eval(-5, p))

  println("roots(p) = " + poly.roots(p))

  println("deriv(p) = " + poly.deriv(p))
  println("deriv2(p) = " + poly.deriv(poly.deriv(p)))

}