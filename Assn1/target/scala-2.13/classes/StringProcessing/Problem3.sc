import scala.util.Random

def mkWord(size: Int = 5): String = {
  var str = ""
  for(i <- 1 to size) str = str.concat(Random.alphanumeric.filter(_.isLetter).head.toLower.toString())
  str
}

mkWord()
mkWord(10)
