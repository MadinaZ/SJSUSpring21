package SequenceControl.Problem7
import scala.util._
import util.control.Breaks._

//Problem 2: Scala BlackJack version 2
object BlackJack2 extends App {

  val gen = new Random(System.currentTimeMillis())

  val cards = new Array[Int](52)
  for(i <- 0 until 52) cards(i) = if (gen.nextBoolean()) gen.nextInt(11) else -1

  var total = 0

  // iterate through cards incrementing total, use break to continue and break
  for(i <- 0 until 52){
    try{
      if(cards(i) > 0){
        if(total >= 21) throw new Exception
        total += cards(i)
      }
    }
    catch {
      case _: Throwable =>
    }
  }

  println("total = " + total)
}
