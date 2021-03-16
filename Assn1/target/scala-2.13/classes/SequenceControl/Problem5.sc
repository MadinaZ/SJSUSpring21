def drawRectangle(h: Int, w: Int)
{
    for (i <- 1 to h) {
      for(j <- 1 to w){
        print("*")
      }
      println()
    }
}

drawRectangle(3, 4)