package Mathematics

import scala.math.{acos, sqrt}

object vector {

  def sum(v1: (Double, Double, Double), v2: (Double, Double, Double)): (Double, Double, Double) = {
    val a = v1._1 + v2._1
    val b = v1._2 + v2._2
    val c = v1._3 + v2._3
    (a, b, c)
  }
  // v1 + v2

  def mul(a: Double,v: (Double, Double, Double)): (Double, Double, Double) = {
    val x = a * v._1
    val y = a * v._2
    val z = a * v._3
    (x, y, z)
  }
  // = a * v

  def dot(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double = {
    (v1._1 * v2._1) + (v1._2 * v2._2) + (v1._3 * v2._3)
  }
  //= v1 * v2

  def length(v: (Double, Double, Double)): Double = {
    sqrt(v._1*v._1 + v._2*v._2 + v._3*v._3)
  }
  // = |v|

  def theta(v1: (Double, Double, Double), v2: (Double, Double, Double)): Double = {
    acos(dot(v1, v2)/ length(v1) * length(v2))
  }
  // = angle (in radians) between v1 and v2

}


object VectorTest extends App {
  val v1 = (2.0, 2.0, 2.0)
  val v2 = (1.0, 0.0, 0.0)
  val v3 = (0.0, 1.0, 0.0)

  println("sum(v3, v2) = " + vector.sum(v3, v2))
  println("mul(3, v1) = " + vector.mul(3, v1))

  println("dot(v1, v2) = " + vector.dot(v1, v2))
  println("dot(v2, v3) = " + vector.dot(v2, v3))
  println("dot(v1, v1) = " + vector.dot(v1, v1))

  println("length(v1) = " + vector.length(v1))
  println("length(v2) = " + vector.length(v2))

  println("theta(v1, v2) = " + vector.theta(v1, v2))
  println("theta(v3, v2) = " + vector.theta(v3, v2))
  println("pi/2 = " + Math.PI/2)
}
