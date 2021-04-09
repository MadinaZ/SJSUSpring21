package value

import context.TypeException
import expression.Literal

trait Addable extends Literal{
    def +(other: Value): Addable
}
