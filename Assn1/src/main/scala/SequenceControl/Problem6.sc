def printSum(n: Int, m: Int)
{
  for(i <- 0 until n; j <- 0 until m){
    println(i + " + " + j + " = " + (i + j))
  }
}

printSum(3, 4)