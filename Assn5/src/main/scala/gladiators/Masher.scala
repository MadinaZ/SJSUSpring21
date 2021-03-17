package gladiators

trait Masher {
    def mash(opponent: Gladiator) = {
      println("Mashing " + opponent.name)
      opponent.damage(5)
    }
}
