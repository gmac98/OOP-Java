package game;

/**
 * HandGear defines a gear item for the player to wear during the game.
 * Based on the values of this item, it increases or decreases the strength of
 * the player.
 */
public class HandGear extends GearBase implements AttackValue,DefenseValue {

  /**
   * Hand Gear initializes the gears that will be added to the chest and to the player in the
   * game. Chest contains multiples of these gear. Player can have only 10 handgear quantity.
   * @param gearName gives the name of the gear item
   * @param attack gives the attack value of the item
   * @param defense gives the defense value of the item
   */
  public HandGear(String gearName, int attack, int defense) {
    if (gearName.split(" ").length < 2) {
      throw new IllegalArgumentException("There must be a valid adjective + noun for gear name.");
    }
    this.gearName = gearName;
    this.attack = attack;
    this.defense = defense;
  }

  /**
   * Return the attack value for respective Hand Gear.
   * @return gives the attack value of the Hand Gear item
   */
  @Override
  public int getAttack() {
    int temp1 = attack;
    return temp1;
  }

  /**
   * Return the defense value for respective Hand Gear.
   * @return gives the defense value of the Hand Gear item
   */
  @Override
  public int getDefense() {
    int temp2 = defense;
    return temp2;
  }
}
