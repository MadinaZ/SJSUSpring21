def kingdom(n: Int): Int = {
  if (n > 10) {
    if (n % 2 == 0) {
      if (n % 100 == 0){2}
      else {1}
    }
    else 4
  }
  else if(n <= 10) 3
  else 4
}





kingdom(200);
kingdom(80);
kingdom(10);
kingdom(17)
