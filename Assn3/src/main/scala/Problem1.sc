import scala.Boolean
import scala.math.Numeric.BigDecimalAsIfIntegral.mkNumericOps

//Problem-1
def compose[T](f: T=> T, g: T=> T):  T=>T = {
  def r(x:T) : T = f(g(x));
  r _
}

val testCompose = compose((x: Int) => x + 1,(x: Int) => x*2)
testCompose(3)

//Problem-2
//Use recursion and your solution to problem 1 to implement the self-composition iterator combinator:
def selfIter[T](f: T=>T, n: Int): T=> T = //f composed with itself n times.
{
  if(n == 0) (x: T) => x
  else compose(f, selfIter(f, n-1))
}

def inc(x: Double) = x + 1
def double(x: Double) = 2 * x

val testInc = selfIter(inc, 3)
val testDouble = selfIter(double, 2)
testInc(2)
testDouble(2)


//Problem-3
def countPass[T](arr: Array[T], test: T => Boolean): Int = {
  var count = 0;
    for(i <- arr) if(test(i)) count += 1 else count
  count
}

var myArr = Array(1, 2, 3, -9, 4)
countPass(myArr, (n: Int) => n > 0)


//Combinator
//Problem-4
//A
def recur(baseVal: Int, combiner: (Int, Int)=>Int): Int=>Int = {
      def f(x: Int): Int = {
        if(x == 0) baseVal else combiner(x, f(x-1))
      }
  f _
}
//B
val c = recur(1, (x, y) => x*y)
c(4)


//Problem-5
def deOptionize[T, S](f: T=>Option[S]): T=>S = {
  (x: T) => {
    val g = f(x)
    g match {
      case None => throw new Exception("The return type does not match")
      case _n => g.get
    }
  }
}

def parseDigits(digits: String): Option[Int] =
  if (digits.matches("[0-9]*")) Some(digits.toInt) else None

val parse = deOptionize(parseDigits)
parse("5678")


//Problem-6

def combinator[T](init: T, n: Int, f: T => T): T = {
  var result = init
  for(i <- 0 to n) result = f(result)
  result
}

combinator(2, 2, (x: Int) => x * x)


def combinatorB[T](init: T, n: Int, f: T => T): T = {
  if(n == 0) init else combinator(f(init), n-1, f)
}

combinatorB(2, 2, (x: Int) => x * x)

//Problem-7
def cube(n: Int) = n * n * n

def unitTest(f: Int => Int, array: Array[(Int, Int)]): Int = {
  var k = 0
    for((i, j) <- array)
      if(f(i) != j) k += 1 else k
  k
}

val arr = Array((1, 1), (2, 8), (3, 9), (4, 64), (5, 124))
unitTest(cube, arr)