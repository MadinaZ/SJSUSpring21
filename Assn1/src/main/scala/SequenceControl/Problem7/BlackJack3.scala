package SequenceControl.Problem7

import scala.util._
import util.control.Breaks._

////Problem 3: Scala BlackJack version 3
object BlackJack3 extends App {

  val gen = new Random(System.currentTimeMillis())

  val cards = new Array[Int](52)
  for(i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1

  var total = 0

  // iterate through cards incrementing total, use break to continue and break
  for(i <- 0 until 52 if(cards(i) > 0)){
      breakable {
        if(total >= 21) break
        total += cards(i)
      }
  }

  println("total = " + total)
}
