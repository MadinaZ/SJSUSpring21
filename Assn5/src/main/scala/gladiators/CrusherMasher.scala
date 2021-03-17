package gladiators

class CrusherMasher(override val name: String) extends Gladiator(name) with Masher with Crusher {
  override def attack(opponent: Gladiator): Unit = {
    super.attack(opponent)
    super.crush(opponent)
    super.mash(opponent)
  }
}
