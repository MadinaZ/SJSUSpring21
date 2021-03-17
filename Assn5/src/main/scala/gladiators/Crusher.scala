package gladiators

trait Crusher {
  def crush(opponent: Gladiator) = {
    println("Crashing " + opponent.name)
    opponent.damage(5)
  }
}
