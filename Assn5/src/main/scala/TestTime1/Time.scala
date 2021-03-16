package TestTime1

class Time(val hour: Int, val minute: Int = 0) {
  val minutesSinceMidNight = hour * 60 + minute

  if(hour > 23 || hour < 0 || minute > 59 || minute < 0)
    throw new IllegalArgumentException

  override def toString: String = {
    if(minute < 10) hour.toString + ":" + ("%02d").format(minute)
    else hour.toString + ":" + minute.toString
  }

  def before(other: Time) = this.minutesSinceMidNight < other.minutesSinceMidNight

}

object Time{
  def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
}