package expression

import context.Environment
import value.Value

trait Literal extends Expression with Value{
    def execute(env: Environment) = this //the value of the literal is itself
}
