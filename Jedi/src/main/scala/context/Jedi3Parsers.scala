package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi3Parsers extends Jedi2Parsers {

  // assignment ::= identifier ~ ":=" ~ expression
  def assignment: Parser[Assignment] = identifier ~ ":=" ~ expression ^^ {
    case i ~ ":=" ~ e => Assignment(i, e)
  }
  // iteration ::= "while" ~ "(" ~ expression ~ ")" ~ expression
  def iteration: Parser[Iteration] = "while" ~ "(" ~ expression ~ ")" ~ expression ^^ {
    case "while"~"("~cond~")"~exp => Iteration(cond, exp)
  }

  // dereference ::= "[" ~ expression ~ "]"
//  def dereference: Parser[FunCall] = "[" ~ expression ~ "]".r ^^ {
//    case "[" ~ expression ~ "]" => FunCall(Identifier("dereference"), List(expression))
//  }
  def dereference: Parser[FunCall]  = "[" ~ expression ~ "]".r ^^{
  case "[" ~ expression ~ "]" => FunCall(Identifier("dereference"), List[Expression](expression))
  }

  override def expression: Parser[Expression] = declaration | conditional | iteration | disjunction | failure("Invalid expression")
  override def term: Parser[Expression]  = lambda | freeze | funCall | block |  assignment | dereference | literal | "("~>expression<~")"

}