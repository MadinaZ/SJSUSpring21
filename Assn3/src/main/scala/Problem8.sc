//Problem-1
//def halt(currentState: S, cycle: Int) =
//  if (currentState is final?) true else false

def controlLoop[S](
                    state: S,
                    cycle: Int,
                    halt: (S, Int)=> Boolean,
                    update: (S, Int)=>S): S = {
  if(halt(state, cycle)) state else controlLoop(update(state, cycle+1), cycle+1, halt, update)
}

//Problem-2
controlLoop[Int](
  1,
  0,
  (state, _) => state > 100000,
  (state, _) => state * 2,
)

//Problem-3
def solve(f: Double=>Double): Double = { //r where |f(r)| <= delta
  val delta = 1e-6
  def der(x: Double) = (f(x + delta) - f(x)) / delta
  controlLoop[Double](
    1.0,
    0,
    (state, _) => math.abs(f(state)) < delta,
    (state, _) => state - f(state) / der(state)
  )
}

//Problem-4
def squareRoot(x: Double) = solve((n: Double) => n * n - x)
squareRoot(25)

//Problem-5
def cubeRoot(x: Double) = solve((n: Double) => n * n * n - x)
cubeRoot(5)

//Problem-6
def nthRoot(x: Double, n: Int) = solve((y: Double) => math.pow(y, n) - x)
nthRoot(25, 5)

//Problem-7
def compInterest(n: Double, r: Double): Double = {
  controlLoop[Double](
    n,
    0,
    (_, cycle) => cycle >= 12,
    (state, _) => state + state * r / 12
  )
}

compInterest(1, 1)
