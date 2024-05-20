package game;

/**
 * Gear Base provides a base class to gear item classes like HeadGear, FootGear,
 * HandGear and Jewelry. It provides a method to combine multiple gear names of items
 * when a player wears multiple gears of the same item type.*/
public class GearBase implements Gear {

  String gearName;
  int attack;
  int defense;

  @Override
  public String getGearName() {
    String temp = gearName;
    return temp;
  }

  @Override
  public int getAttack() {
    int temp1 = attack;
    return temp1;
  }

  @Override
  public int getDefense() {
    int temp2 = defense;
    return temp2;
  }

  /**
   * Combine method combines the gear names if a player of the game wears multiple gears of the
   * same gear type. It also combines its attack and defence value. It combines gear names by
   * combining adjectives and using single noun from the items.
   * @param item1 it gives the first item of the gear to be combined
   * @param item2 it gives the second item of the gear to be combined
   * @return returns the combined of the gear
   */
  public GearBase combine(GearBase item1, GearBase item2) {
    if (item1 instanceof HandGear && item2 instanceof HandGear) {
      String name = item1.getGearName().split(" ")[0];
      String combinedName = name + "," + item2.getGearName();
      return new HandGear(
              combinedName,
              (item1.getAttack() + item2.getAttack()),
              (item1.getDefense() + item2.getDefense()));
    } else if (item1 instanceof FootGear && item2 instanceof FootGear) {
      String name = item1.getGearName().split(" ")[0];
      String combinedName = name + "," + item2.getGearName();
      return new FootGear(
              combinedName,
              (item1.getAttack() + item2.getAttack()));
    } else {
      String name = item1.getGearName().split(" ")[0];
      String combinedName = name + "," + item2.getGearName();
      return new Jewelry(
              combinedName,(item1.getAttack() + item2.getAttack()),
              (item1.getDefense() + item2.getDefense()));
    }
  }

  @Override
  public String toString() {
    return "{"
            + "gearName='"
            + this.gearName
            + '\''
            + ", attackValue="
            + this.attack
            + ", defenseValue="
            + this.defense
            + '}';
  }

}
