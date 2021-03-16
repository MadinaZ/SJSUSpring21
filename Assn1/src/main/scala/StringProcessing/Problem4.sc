import scala.math.random
import scala.util.Random

def mkWord(size: Int = 5): String = {
  var str = ""
  for(i <- 1 to size) str = str.concat(Random.alphanumeric.filter(_.isLetter).head.toLower.toString())
  str
}


def mkSentence(size: Int = 10): String = {
  var str = Array[String]()
  for(_ <- 1 to size) {
    str = str :+ mkWord((random() * 10 + 1).toInt)
  }
  str.mkString(" ").concat(".").capitalize
}

mkSentence()
mkSentence(5)