package game;

/**
 * Gear items have the ability to add attack value to the basic attack strength of
 * the player. This value is added to the gear items with the attack value.
 */
public interface AttackValue {
  /**
   * Retrieves the attack value for respective Gear.
   * @return gives the attack value of the Gear item
   */
  int getAttack();
}
