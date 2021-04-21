package value

class Notification(val message: String) extends Value {
  override def toString: String = message
}

object Notification{
  def apply(message: String) = new Notification(message)
  val ok = Notification("ok")
  val done = Notification("done")
  val unspecified = Notification("unspecified")
}
