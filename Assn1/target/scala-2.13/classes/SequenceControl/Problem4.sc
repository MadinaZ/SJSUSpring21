def tax(n: Double): Double = {
  n match {
    case x if x < 0 => throw new Exception("Invalid income")
    case x if x < 20000 => 0
    case x if x < 30000 => 0.05 * n
    case x if x < 40000 => 0.11 * n
    case x if x < 60000 => 0.23 * n
    case x if x < 100000 => 0.32 * n
    case x if x >= 100000 => 0.5 * n
  }
}

tax(12300)                                  //> res0: Double = 0.0
tax(29000)                                  //> res1: Double = 1450.0
tax(125000)                                 //> res2: Double = 62500.0
tax(1000000)                                //> res3: Double = 500000.0
try {
  tax(-100000)
} catch {
  case e: Exception => println(e)
}
