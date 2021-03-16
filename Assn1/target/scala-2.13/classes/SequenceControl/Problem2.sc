def order(n: Int): Int = {

  if(n > 0){
    if(n%3 == 0){
      if(n == 50){
        if(n%7 == 0){
          1 * 3 + 5
        }
        else{
          1 * 3 + 6
        }
      }
      else{
        if(n%7 == 0) 1 * 4 + 5
        else 1 * 4 + 6
      }
    }
    else{
      if(n == 50){
        if(n%7 == 0) 2 * 3 + 5
        else 2 * 3 + 6
      }
      else{
        if(n%7 == 0) 2 * 4 + 5
        else 2 * 4 + 6
      }
    }
  }
  else -1
}

order(3)
