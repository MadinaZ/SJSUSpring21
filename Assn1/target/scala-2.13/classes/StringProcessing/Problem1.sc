import scala.math.floor

def isPal(s: String): Boolean = {
  val half = floor(s.length / 2).toInt
  var checker = true
  for {
    i <- 0 to half
    j = s.length - i - 1
  } if(s.charAt(i) != s.charAt(j)) checker = false
  checker
}

isPal("$3.1441.3$")
isPal("rotator")                                //> res0: Boolean = true
isPal("cat")                                    //> res1: Boolean = false
isPal("Civic")
