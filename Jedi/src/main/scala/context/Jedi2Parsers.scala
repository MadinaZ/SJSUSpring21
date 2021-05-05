package context

import scala.util.parsing.combinator._
import expression._
import value._

class Jedi2Parsers extends Jedi1Parsers {

  // params parser
  // a parameter list is zero or more comma-separated identifiers bracketed by parentheses:
  // params ::= "(" ~ (identifier ~ ("," ~ identifier)*)? ~ ")"
  def params: Parser[List[Identifier]] = "(" ~> opt(identifier ~ rep("," ~> identifier)) <~ ")" ^^ {
    case None => Nil
    case Some(x ~ Nil) => List(x)
    case Some(x ~ more) => x :: more
  }

  // lambda parser
  // lambda ::= "lambda" ~ params ~ expression
//  def lambda: Parser[Lambda] = "lambda" ~> params ~ expression ^^ {
//    case param ~ exp => Lambda(param, exp)
//  }

  def lambda: Parser[Lambda] = "lambda" ~ params ~ expression ^^ {
    case "lambda" ~ params ~ expression => Lambda(params, expression)
  }

  // block parser
  // a block is one or more semi-colon separated expressions bracketed by curly braces:
  // block ::= "{" ~ expression ~ (";" ~ expression)* ~ "}"
  def block: Parser[Block] = "{" ~> expression ~ rep(";" ~> expression) <~ "}" ^^ {
    case x ~ Nil => Block(List(x))
    case x ~ more => Block(x :: more)
  }

  def freeze: Parser[MakeThunk] = "freeze(" ~> expression <~ ")" ^^ {
    case exp => MakeThunk(exp)
  }

  // override of term parser
  override def term: Parser[Expression] = lambda | freeze | funCall | block | literal | "(" ~> expression <~ ")"
}


