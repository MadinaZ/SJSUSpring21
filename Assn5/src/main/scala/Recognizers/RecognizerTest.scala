package Recognizers

object RecognizerTests extends App with Recognizers {

  // exp1 ::= 00 ~ 11 | 111
  def exp1 = pipe(follows(matches("00"), matches("11")), matches("111"))

  println(exp1("0011")) // = true
  println(exp1("111"))  // = true
  println(exp1("000011")) // = false, too many 0's

  // exp2 ::= (00)* ~ (111) ~ (00)?
  var exp2 = follows(follows(rep(matches("00")), matches("111")), opt(matches("00")))
  println(exp2("0000111")) // = true
  println(exp2("00000011100")) // = true
  println(exp2("00011100")) // = false, #leading zeroes must be even
  println(exp2("11100")) // = true
}