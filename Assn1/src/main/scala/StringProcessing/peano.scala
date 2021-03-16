package StringProcessing

import scala.io.StdIn.readLine
import scala.io._
import scala.util.control.Breaks.{break, breakable}

class SyntaxException(gripe: String = "ERROR") extends Exception(gripe)
class MissingOperator extends SyntaxException("Missing operator!")
class NumberFormat extends SyntaxException("Illegal operand!")


object peano {


  def execute(cmmd: String): String = {
    // if cmmd is a valid expression, compute its value and return it as a string
    val vals = new Array[Int](50)
    val ops = new Array[Char](20)
    var result = 0
    for(i <- 1 to cmmd.size){
      if(cmmd(i).isDigit)
        vals(i) = cmmd(i)
      else if(cmmd(i) == "+" || cmmd(i) == "*" || cmmd(i) == "/" || cmmd(i) == "%")
        ops(i) = cmmd(i)
      }

    for(i <- 1 to vals.size) {
      ops(i) match {
        case '+' => result = vals(i) + vals(i + 1); println(vals(i) + vals(i + 1))
        case '*' => println(vals(i) * vals(i + 1))
        case '/' => println(vals(i) / vals(i + 1))
        case '%' => println(vals(i) % vals(i + 1))
        case _ => throw new Exception("Invalid")
      }
    }
    result.toString
  }


  // read-execute-print loop
  def repl {
    var str = ""
    while(str != "quit"){
      breakable {
        str = readLine("Enter a string ")
        if(str != " "){
          if(str == "quit") break;
          execute(str)
        }
      }

    }
    // repeatedly:
    //   1. prompt user for a string
    //   2. quit if cmmd == "quit"
    //   3. ignore if cmmd == ""
    //   4. print execute(cmmd) otherwise
    //   5. handle all exceptions
  }

  def main(args: Array[String]): Unit = {
    repl
  }
}