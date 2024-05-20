package game;

/**
 * Gear items have the ability to add defense value to the basic defense strength of
 * the player. This value is added to the gear items with the defense value.
 */
public interface DefenseValue {
  /**
   * Retrieves the defense value for respective Gear.
   * @return gives the defence value of the Gear item
   */
  int getDefense();
}
