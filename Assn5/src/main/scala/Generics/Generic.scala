package Generics
import scala.collection.mutable.ArrayBuffer

class Generic[T](private var arr: ArrayBuffer[T] = ArrayBuffer[T]()) {

 def enqueue[S](item: T) = {
    arr += item
 }

  def dequeue[S](): T = {
    val item: T = arr.head
      arr = arr.tail
    item
  }

  def front[T]()= {
      println(arr.head)
  }

  def isEmpty(): Boolean = {
      if(arr.size == 0) true
      else false
  }

  override def toString: String = arr.toString
}

object Queue extends App{
  def apply[T](elems: T*) = {new Generic[T]()}

  def test1() {
    val waitingList = Queue[String]("Sid", "Barb", "Joel")

    waitingList.enqueue("Bob")
    waitingList.enqueue("Martha")
    waitingList.enqueue("Katy")
    waitingList.enqueue("Joe")
    waitingList.enqueue("Paul")

    println(waitingList)
    waitingList.front()

    while(!waitingList.isEmpty()){
      waitingList.dequeue()
    }

    println(waitingList)
  }

  test1()
}