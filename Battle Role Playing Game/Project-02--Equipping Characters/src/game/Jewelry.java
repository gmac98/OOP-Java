package game;

/**
 * Jewelry defines a gear item for the player to wear during the game.
 * Based on the values of this item, it increases or decreases the strength of
 * the player.
 */
public class Jewelry extends GearBase implements AttackValue,DefenseValue {

  /**
   * Jewelry initializes the gears that will be added to the chest and to the player in the
   * game. Chest contains multiples of these gear. Player can have unlimited jewelry quantity.
   * @param gearName gives the name of the gear item
   * @param attack gives the attack value of the item
   * @param defense gives the defense value of the item
   */
  public Jewelry(String gearName, int attack, int defense) {
    if (gearName.split(" ").length < 2) {
      throw new IllegalArgumentException("There must be a valid adjective + noun for gear name.");
    }
    this.gearName = gearName;
    this.attack = attack;
    this.defense = defense;
  }

  /**
   * Returns the attack value for respective Jewelry.
   * @return gives the attack value of the Jewelry item
   */
  public int getAttack() {
    int temp1 = attack;
    return temp1;
  }

  /**
   * Return the defense value for respective Jewelry.
   * @return gives the attack value of the Jewelry item
   */
  public int getDefense() {
    int temp2 = defense;
    return temp2;
  }
}
