package TestTime2

object TestTime2 extends App {
  try {
    val t1 = Time(22, 5)
    val t2 = Time(20, 10)

    println("t1 = " + t1)
    println("t2 = " + t2)
    println("t1 < t2 = " + t1.before(t2))
    t1.hour = 20 //t1.hour_=(20)
    println("t1 < t2 = " + t1.before(t2)) //t1.hour_
    t1.minute = 60 //t1.hour_=(60)
  } catch {
    case e: IllegalArgumentException => println(e)
  }

}
