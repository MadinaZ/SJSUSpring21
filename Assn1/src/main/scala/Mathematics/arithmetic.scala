package Mathematics

import scala.math.log10


object arithmetic {

  def sqrt(n: Int): Option[Int] = {
    var result = 1
    var i = 0
    if(n < 0) None // = None if n < 0
    else{
      while(result <= n){
        i += 1
        result = i * i
      }
    }// = largest int m such that m * m <= n
    Some(i - 1)
  }

  def log(n: Int): Option[Int] = {
    if(n <= 0) None // = None if N <= 0
    else Some((log10(n)/log10(2)).toInt)// = largest m such that 2^m <= n
  }

  def isPrime(n: Int): Option[Boolean] = n match {
    case x if x < 0 => None
    case 0 => Some(false)
    case 1 => Some(false)
    case 2 => Some(true)
    case _ => {
      var prime = true
      for(
        i <- 2 until n
        if prime
      ) {
        if(n % i == 0) prime = false
      }
      Some(prime)
    }
  }
    // = true if n has no divisors > 1

  def gcd(n: Int, m: Int): Option[Int] = {

//    if(m == 0) Some(n)
//    else if(n < 0) None
//    else if(m < 0) None
//    else gcd(m, n%m)

    if (n == 0) Some(m)
    else if(n < 0) None
    else if(m < 0) None
    else gcd(m % n, n);
  }

  def lcm(n: Int, m: Int): Option[Int] = {
    if(n < 0) None
    else if(m < 0) None
    else{
      val res: Int = gcd(n, m).get
      Some(n / res * m)
    }
    // = None if n < 0 or m < 0
    // = smallest k such that n a,d m divide k
  }

  def phi(n: Int): Option[Int] = {
    var result = 6
    if(n < 0) None
    else{
      for(i <- 2 until n + 1){
        if(gcd(n, i) == 1) {
           result += 1
        }
        Some(result)
      }
      Some(result)
    }
    // = None if n < 0
    // = # of k <= n such that gcd(k, n) = 1
  }

}

object testArith extends App {
  println("gcd(15, 12) = " + arithmetic.gcd(15, 12))
  println("lcm(15, 12) = " + arithmetic.lcm(15, 12))
  println("gcd(13, 12) = " + arithmetic.gcd(13, 12))
  println("gcd(-13, 12) = " + arithmetic.gcd(-13, 12))
  println("phi(9)= " + arithmetic.phi(9))
  println("sqrt(49) = " + arithmetic.sqrt(49))
  println("sqrt(37) = " + arithmetic.sqrt(37))
  println("sqrt(35) = " + arithmetic.sqrt(35))
  println("log(64) = " + arithmetic.log(64))
  println("log(130) = " + arithmetic.log(130))
  println("log(9) = " + arithmetic.log(9))
  println("log(0) = " + arithmetic.log(0))
  println("isPrime(23) = " + arithmetic.isPrime(23))
  println("isPrime(59) = " + arithmetic.isPrime(59))
  println("isPrime(75) = " + arithmetic.isPrime(75))
}