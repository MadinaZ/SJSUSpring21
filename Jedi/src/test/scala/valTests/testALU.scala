package valTests
import context._
import value._
import expression._

object testALU extends App {
  try {
    println(alu.execute(Identifier("add"), List(Exact(5), Exact(6), Exact(7))))     // 18
    println(alu.execute(Identifier("add"), List(Chars("abc"), Exact(6), Exact(7)))) // abc67
    println(alu.execute(Identifier("less"), List(Chars("abc"), Chars("def"))))  // true
    println(alu.execute(Identifier("equals"), List(Chars("abc"), Chars("abc"))))  // true
    println(alu.execute(Identifier("unequals"), List(Chars("af"), Chars("a")))) //true
    println(alu.execute(Identifier("not"), List(Boole(true)))) //false
    println(alu.execute(Identifier("div"), List(Exact(4), Exact(2))))     // 2
    println(alu.execute(Identifier("sub"), List(Exact(8), Exact(6))))    // 2

  } catch {
    case e: Exception => println(e)
  }


}
