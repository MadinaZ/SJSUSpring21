package value

case class Notification(val message: String) extends Value {
  override def toString: String = message

  val ok = Notification("ok")
  val done = Notification("done")
  val unspecified = Notification("unspecified")
}
