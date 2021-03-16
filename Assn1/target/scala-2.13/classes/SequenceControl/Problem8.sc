final case class CustomException(private val message: String = "",
                                 private val cause: Throwable = None.orNull)
  extends Exception(message, cause)


def realm1(n: Int): Int = {
  if(n > 0)
    if(n%2 != 0) 1
    else throw new Exception("Invalid")
  else throw new CustomException("Invalid")
}// = 1 if n belongs to realm 1, throws an exception otherwise

def realm2(n: Int): Int = {
  if(n > 0)
    if(n%2 == 0){
      if(n%3 != 0) 2
      else throw new IllegalArgumentException("Invalid")
    }
    else throw new IllegalArgumentException("Invalid")
  else throw new CustomException("Invalid")
}// = 2 if n belongs to realm 2, throws an exception otherwise

def realm3(n: Int): Int = {
  if(n > 0)
    if(n%6 == 0){
      if(n%7 == 0) 3
      else throw new Exception("Invalid")
    }
    else throw new CustomException("Invalid")
  else throw new CustomException("Invalid")
} // = 3 if n belongs to realm 3, throws an exception otherwise

def realm(n: Int): Int  = 0// = the realm of n


try {
  realm1(14)
}
catch {
  case e: IllegalArgumentException => realm3(14)
  case e: CustomException => realm(14)
  case e: Exception => realm2(14)
  case e: InterruptedException => realm1(14)
}

