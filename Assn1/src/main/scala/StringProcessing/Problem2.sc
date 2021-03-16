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

def isPal2(s: String): Boolean = isPal(s.replaceAll("\\s+|[.,\\/!#$%*?\\^\\*;:{}=\\-_`~()'\"]", "").toLowerCase())

isPal2("A man, a plan, a canal, Panama!")
isPal2("Race car")
isPal2("Race kar")