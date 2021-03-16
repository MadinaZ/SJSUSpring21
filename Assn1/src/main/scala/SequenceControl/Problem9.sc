def sqrt(x: Double) : Option[Double] = if (x < 0)None else Some(math.sqrt(x))

def log(x: Double) :Option[Double] = if (x <= 0) None else Some(math.log(x))

def Sqrt1(x: Option[Double]): Option[Double] = {
  x match{
    case None => None
    case Some(x) => sqrt(x)
  }
}

def Log1(x: Option[Double]): Option[Double] = {
  x match{
    case None => None
    case Some(x) => log(x)
  }
}

def sqrtLog(x: Option[Double]) : Option[Double] = Log1(Sqrt1(x))

sqrtLog(Some(100))
sqrtLog(Some(25))
sqrtLog(Some(7))