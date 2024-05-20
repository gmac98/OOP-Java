package game;

/**
 * FootGear defines a gear item for the player to wear during the game.
 * Based on the values of this item, it increases or decreases the strength of
 * the player.
 */
public class FootGear extends GearBase implements AttackValue {

  /**
   * Foot Gear initializes the gears that will be added to the chest and to the player in the
   * game. Chest contains multiples of these gear. Player can have only 4 footgear quantity.
   * @param gearName gives the name of the gear item
   * @param attack gives the attack value of the item
   */
  public FootGear(String gearName, int attack) {
    if (gearName.split(" ").length < 2) {
      throw new IllegalArgumentException("There must be a valid adjective + noun for gear name.");
    }
    if (attack == 0) {
      throw new IllegalArgumentException("Attack value cannot be zero");
    }
    this.gearName = gearName;
    this.attack = attack;
  }

  /**
   * Returns the attack value for respective Foot Gear.
   * @return gives the attack value of the Foot Gear item
   */
  @Override
  public int getAttack() {
    int temp = attack;
    return temp;
  }

}
