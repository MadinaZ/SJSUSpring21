package gladiators

trait Slasher {
  def slash(opponent: Gladiator) = {
    println("Slashing " + opponent.name)
    opponent.damage(5)
  }
}
