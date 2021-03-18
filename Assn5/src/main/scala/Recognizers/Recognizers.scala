package Recognizers

import scala.util.control.Breaks.break

trait Recognizers {

  // matches(s) = s
  def matches(s: String) : String => Boolean = {
    def r(s1: String) = s1.trim.equalsIgnoreCase(s)
    r _
  }

  // opt(r) = r?
  def opt(r: String => Boolean): String => Boolean = {
    (str: String) => if(str.isEmpty) false else r(str)
  }

  // pipe(r1, r2) = r1 | r2
  def pipe(r1: String => Boolean, r2: String => Boolean) : String => Boolean = {
    (str: String) => if(r1(str) || r2(str)) true else false
  }

  // follows(r1, r2) = r1 ~ r2
  def follows(r1: String => Boolean, r2: String => Boolean) : String => Boolean = {
   val list1: List[String] = List("0", "00", "000", "0000", "00000", "000000", "1", "11", "111",
   "1111", "11111", "111111")
    val list2: List[String] = List("0", "00", "000", "0000", "00000", "000000", "1", "11", "111",
      "1111", "11111", "111111")
    (str: String) => {
      for(x <- list1) {
        for(y <- list2){
          if(r1(x) == true || r2(y) == true || r1(y) == true || r2(x) == true){
            if(x + y == str || x == str || y == str) true
          }
        }
      }
      false
    }
  }

  // rep(r) = r*
  def rep(r: String => Boolean): String => Boolean = {
    //r1 uses recursion and iteration!
    def r1(s: String): Boolean = {
      var result = false
      if (s == "") result = true
      else {
        for(i <- 0 to s.length if !result)
          result = r(s.take(i)) && r1(s.drop(i))
      }
      result
    }
    r1 _
  }
}