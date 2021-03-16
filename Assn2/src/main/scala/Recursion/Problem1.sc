def inc(n: Int): Int = n + 1
def dec(n: Int): Int = n - 1
def isZero(n: Int): Boolean = n == 0

//Problem 1
def add(n: Int, m: Int):Int = {
  if(isZero(m)) n
  else add(inc(n), dec(m))
}

add(2, 4)
add(7, 2)
add(0, 8)
add(8, 2)

//Problem 2
def mul(n: Int, m: Int):Int = {
  if(isZero(m)) 0
  else add(n, mul(n, dec(m)))
}

mul(2, 2)
mul(3, 3)
mul(8, 2)

//Problem 3
def exp(m: Int): Int = {
  if(isZero(m)) 1
  else mul(2, exp(dec(m)))
}

exp(3)
exp(5)

//Problem 4
def hyperExp(n: Int): Int = {
  if(isZero(n)) 0
  else exp(hyperExp(dec(n)))
}

hyperExp(0)
hyperExp(1)
hyperExp(2)
hyperExp(3)


//Problem 5
def addTail(n: Int, m: Int): Int = {
  def helper(n: Int, m: Int): Int =
    if(isZero(m)) n else helper(inc(n), dec(m))
  helper(n, m)
}

addTail(2, 4)
addTail(7, 2)
addTail(0, 8)
addTail(8, 2)

def mulTail(n: Int, m: Int):Int = {
  def helper(n: Int, m: Int) =
    if(isZero(m)) 0 else addTail(n, mulTail(n, dec(m)))
  helper(n, m)
}

mulTail(2, 0)
mulTail(3, 3)
mulTail(8, 2)

def expTail(m: Int): Int = {
  def helper(n: Int, m: Int): Int = {
    if(isZero(m)) n else helper(mulTail(n, 2), dec(m))
  }
  helper(1, m)
}

expTail(3)
expTail(5)


def hyperexpTail(n: Int): Int = {
  def helper(m : Int, n: Int): Int = {
    if(isZero(n)) m else helper(expTail(m),dec(n))
  }
  helper(0, n)
}

hyperexpTail(0)
hyperexpTail(1)
hyperexpTail(2)
hyperexpTail(3)

//Problem 9
def fib(n: Int): Int = {
  if(n <= 1) n else fib(n-1) + fib(n-2)
}

fib(1)
fib(2)
fib(5)
fib(6)
fib(8)

def fibTail(n: Int): Int = {
  def helper(a: Int, b: Int, c: Int): Int = {
    if(isZero(c)) b else helper(b, add(a, b), dec(c))
  }

  helper(1, 0, n)
}

fibTail(1)
fibTail(2)
fibTail(5)
fibTail(6)
fibTail(8)


//Problem 10
def choose(n: Int, m: Int): Int = {
  if(m == 0) 1 else (n * choose(n-1, m-1))/m
}

choose(3, 2)
choose(5, 2)