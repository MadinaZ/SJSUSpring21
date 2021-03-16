import scala.math.{floor, random}

def rollDice(): (Int, Int) = {
  def dice(): Int = (floor(random() * 6) + 1).toInt
  (dice(), dice())
}

rollDice()
rollDice()
rollDice()
