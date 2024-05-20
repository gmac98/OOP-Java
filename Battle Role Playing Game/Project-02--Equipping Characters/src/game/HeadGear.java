package game;

/**
 * HeadGear defines a gear item for the player to wear during the game.
 * Based on the values of this item, it increases or decreases the strength of
 * the player.
 */
public class HeadGear extends GearBase implements DefenseValue {

  /**
   * Head Gear initializes the gears that will be added to the chest and to the player
   * in the game. Chest contains multiples of these gear. Player can have only 1 headgear quantity.
   * @param gearName gives the name of the gear item
   * @param defense gives the defense value of the item
   */
  public HeadGear(String gearName, int defense) {
    if (gearName.split(" ").length < 2) {
      throw new IllegalArgumentException("There must be a valid adjective + noun for gear name.");
    }
    if (defense == 0) {
      throw new IllegalArgumentException("Defense value cannot be zero");
    }
    this.gearName = gearName;
    this.defense = defense;
  }

  /**
   * Return the defense value for respective Head Gear.
   * @return gives the defence value of the Head Gear item
   */
  public int getDefense() {
    int temp = defense;
    return temp;
  }

}
