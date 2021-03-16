//Problem-1
//Iterative Solution
def sumOfCubes(arr: List[Int]) = {
  var result = 0
  for(i <- arr if i%2 != 0) {
    result = result + (i*i*i)
  }
  result
}

sumOfCubes(List(1, 2, 3))

//Recursive Solution
def sumOfCubesRecur(arr: List[Int]): Int = {
  if(arr == Nil) 0
  else if(arr.head%2 != 0) math.pow(arr.head, 3).toInt + sumOfCubesRecur(arr.tail)
  else sumOfCubesRecur(arr.tail)
}

sumOfCubesRecur(List(1, 2, 3))

//Tail Recursive Solution
def sumOfCubesTail(arr: List[Int]) = {
  def helper(result: Int, unseen: List[Int]): Int = {
    if(unseen == Nil) result
    else if(unseen.head%2 != 0)  helper(result + math.pow(unseen.head, 3).toInt, unseen.tail)
    else helper(result, unseen.tail)
  }
  helper(0, arr)
}

sumOfCubesTail(List(1, 2, 3))

//Pipelining
def cube(a: Int):Int = a*a*a
def isOdd(a: Int): Boolean = a%2 != 0
def pipe(arr: List[Int]): Int = arr.filter(isOdd _).map(cube _).reduce(_ + _).toInt

pipe(List(1, 2, 3))


//Problem-2

//Iterative
def sumOfSums(list: List[List[Int]]) = {
  var result = 0
  for(i <- list.indices)
    for (j <- list(i).indices)
      result = result + list(i)(j)
//      println(list(i))
  result
}

sumOfSums(List(List(1, 2, 3), List(4, 5, 6)))

//Recursive Solution
def sumOfSumsRecur(list: List[List[Int]]): Int = {
  def helper(l: List[Int]): Int = {
      if(l == Nil) 0
      else helper(l.tail) + l.head
  }
  if(list == Nil) 0
  else helper(list.head) + sumOfSumsRecur(list.tail)

}

sumOfSumsRecur(List(List(1, 2, 3), List(4, 5, 6)))

//Tail Recursive Solution
def sumOfSumsTail(list: List[List[Int]]): Int = {
    def helper(l: List[List[Int]]): Int = {
      def helper2(li: List[Int]): Int = {
        if(li == Nil) 0
        else helper2(li.tail) + li.head
      }
      if(l == Nil) 0
      else helper2(l.head) + helper(l.tail)
    }
  helper(list)
}

sumOfSumsTail(List(List(1, 2, 3), List(4, 5, 6)))


//Pipeline Solution
def sumOfSumsPipe(list: List[List[Int]]): Int = list.map(l => l.reduce(_ + _)).reduce(_ + _)
 sumOfSumsPipe(List(List(1, 2, 3), List(4, 5, 6)))


//Problem-6
//Iterative Solution
def pred[T](list: List[T], f: T => Boolean): Int = {
  var result = 0
  for(i <- list if f(i)) result +=1
  result
}

pred(List(1, 2, 3), isOdd _)

//Recursive Solution
def predRecur[T](list: List[T], f: T => Boolean): Int = {
  if(list == Nil) 0
  else if (f(list.head)) 1 + predRecur(list.tail, f)
  else predRecur(list.tail, f)
}

predRecur(List(1, 2, 3), isOdd _)

//Tail Recursive Solution
def predTail[T](list: List[T], f: T => Boolean): Int = {
  def helper(l: List[T], count: Int): Int = {
    if(l == Nil) count
    else if(f(l.head)) helper(l.tail, count + 1)
    else helper(l.tail, count)
  }
  helper(list, 0)
}

predTail(List(1, 2, 3), isOdd _)


//Pipeline Solution
def predPipe[T](list: List[T], f: T => Boolean): Int =
  list.filter(x => f(x)).size

predPipe(List(1, 2, 3), isOdd _)

//Problem-7
//Iterative Solution
def predTrue[T](list: List[T], f: T => Boolean): Boolean = {
  var result = 0
  for(i <- list if f(i)) result +=1
  if(result == list.size) true
  else false
}

predTrue(List(1, 5, 3), isOdd _)

//Recursive Solution
def predTrueRecur[T](list: List[T], f: T => Boolean): Boolean = {
  if(list == Nil) true
  else f(list.head) && predTrueRecur(list.tail, f)
}

predTrueRecur(List(1, 2, 3), isOdd _)

//Tail Recursive Solution
def predTrueTail[T](list: List[T], f: T => Boolean): Boolean = {
  def helper(l: List[T], value: Boolean): Boolean = {
    if(l == Nil) true
    else helper(l.tail, value && f(l.head))
  }
  helper(list, true)
}

predTrueTail(List(1, 7, 3, 9), isOdd _)


//Pipeline Solution
def predTruePipe[T](list: List[T], f: T => Boolean): Boolean =
  list.map(x => f(x)).reduce(_ && _)

predTruePipe(List(1, 21, 3), isOdd _)


//Problem-13
//An infinitely long stream of 1's
def ones(): Stream[Int] = 1 #:: ones()
val s1 = ones().take(10)
s1.toList

//The stream of all non-negative integers
def nonNegativeInts(n: Int): Stream[Int] = n #:: nonNegativeInts(n+1)
val s2 = nonNegativeInts(0).take(10)
s2.toList

//The stream of all non-negative even integers
def nonNegativeEven(n: Int): Stream[Int] = n #:: nonNegativeEven(n + 2)
val s3 = nonNegativeEven(0).take(10)
s3.toList

//The stream of all squares of integers
def squares(n: Int): Stream[Int] = (n*n) #:: squares(n+1)
val s4 = squares(0).take(10)
s4.toList

//Problem-15
def spellCheck(doc: List[String], dictionary: List[String]): List[String] =
  doc.filter((x: String) => !dictionary.contains(x)).map((str: String) => str)

spellCheck(List("mom", "ala", "dad", "hhh"), List("mom", "ada", "dad"))


//Problem-16
def evalMono(n: (Double, Double), x: Double): Double = n._1 * math.pow(x, n._2)

def evalPoly(poly: List[(Double, Double)], x: Double): Double =
  poly.map(p => evalMono(p, x)).sum

evalMono((3, 2), 5)
evalPoly(List((3.0, 2.0), (-5.0, 0.0)), 2)