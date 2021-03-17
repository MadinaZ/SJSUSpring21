package gladiators

class Gladiator(val name: String) {

  private var healthLevel: Int = 100

  def damage(damageLevel: Int) = {
    healthLevel = healthLevel - damageLevel
    if(healthLevel < 0) healthLevel = 0
  }

  def attack(opponent: Gladiator) = {
    println("Attacker: " + name + "    Victim: " + opponent.name)
    val r = scala.util.Random.nextInt(10)
    if(healthLevel > 0)
      damage(r)
    else
      throw new IllegalArgumentException()
  }

}

object Gladiator{
  def apply(name: String) = new Gladiator(name)
}
