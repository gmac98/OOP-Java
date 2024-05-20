package game;

/**
 * Gear provides the different gear items that players can wear during battle. Each item
 * has a name (adjective + noun) and/or attack value and defense value. At the start of
 * the battle, the gears are assigned to the chest. A player can be randomnly assigned 20
 * gears. When a player wears multiple gears of same type, their names are combined together
 * to display player gears.
 */
public interface Gear {

  /** Retrieves the name/combined name of the gear item.
   * @return the name/combined name of the gear item
   */
  String getGearName();

  /**
   * Returns the attack value for respective Gear item.
   * @return gives the attack value of the Gear item
   */
  int getAttack();

  /**
   * Return the defense value for respective Gear item.
   * @return gives the defense value of the Gear item
   */
  int getDefense();

}
