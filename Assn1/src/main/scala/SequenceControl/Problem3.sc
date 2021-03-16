//the return type of the function was not specified
//it is declared as a procedure, which should not return
//any value, but alter the state. Since we are returning
//a value we have to specify the return type
def species(n: Int) : Int = {
  if (0 < n)
    if (n % 2 == 0) 1
    else 2
  else
    0
}

species(3)
species(2)
species(-1)