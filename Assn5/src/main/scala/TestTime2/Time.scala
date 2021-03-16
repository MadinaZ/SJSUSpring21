package TestTime2

class Time(var _hour: Int, var _minute: Int = 0) {
  def hour = _hour
  def hour_=(h: Int) = {
    if(h < 0 || 23 < h)
      throw new IllegalArgumentException
    _hour = h
  }

  def minute = _minute
  def minute_=(m: Int) = {
    if(m < 0 || m > 59)
      throw new IllegalArgumentException
    _minute = m
  }

  def minutesSinceMidNight = _hour * 60 + _minute

  if(_hour > 23 || _hour < 0 || _minute > 59 || _minute < 0)
    throw new IllegalArgumentException

//    if(_minute < 10){
//      var str: String = _minute.toString.format("%07d")
//      _minute = str.toInt
//    }

  override def toString: String = {
    if(_minute < 10) _hour.toString + ":" + ("%02d").format(_minute)
    else _hour.toString + ":" + _minute.toString
  }

  def before(other: Time) = this.minutesSinceMidNight < other.minutesSinceMidNight

}

object Time{
  def apply(hour: Int, minute: Int = 0) = new Time(hour, minute)
}