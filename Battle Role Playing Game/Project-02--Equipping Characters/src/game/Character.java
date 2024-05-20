package game;

import java.util.List;

/**
 * Character class represents the player of the game where each player has a player ID,
 * basic attack strength and defense strength. When player enters battle, he equips himself
 * with multiple gears which add or subtract(in case of cursed gear) from his strength.
 */
public class Character {
  private final int charId;
  private int initialAttack;
  private int initialDefense;
  private List<HeadGear> headGearList;
  private List<HandGear> handGearList;
  private List<FootGear> footGearList;
  private List<Jewelry> jewelryList;
  private final int head1;
  private final int hand1;
  private final int foot1;

  /**
   * Character constructor initializes the parameters of the player
   * like the player ID, basic attack and defense strength. Gear items that the player
   * is dressed with are loaded to the respective gear lists.
   */
  public Character(int charId,int basicAttack,int basicDefense,
                   List<HeadGear> headGearList,List<HandGear> handGearList,
                   List<FootGear> footGearList,List<Jewelry> jewelryList) {
    if (charId < 0 || basicAttack < 0 || basicDefense < 0) {
      throw new IllegalArgumentException("Negative values are not allowed for character ID, "
              + "initial attack value, "
              + "initial defense value.");
    }
    this.charId = charId;
    this.initialAttack = basicAttack;
    this.initialDefense = basicDefense;
    this.headGearList = headGearList;
    this.handGearList = handGearList;
    this.footGearList = footGearList;
    this.jewelryList = jewelryList;
    this.head1 = 1;
    this.hand1 = 10;
    this.foot1 = 2;
  }

  /** Combines two headgear to merge into one gear piece with totalled attack and defence.
   * @param head passes the head gear list
   * @return combined headgear element
   */
  public GearBase addCharHeadGear(List<HeadGear> head) {
    if (head.size() > 1) {
      throw new IllegalArgumentException("Quantity of Headgear cannot exceed 1");
    }
    if (headGearList.size() == head1) {
      initialDefense += head.get(0).getDefense();
      return new HeadGear(head.get(0).getGearName(),head.get(0).getDefense());
    }
    return null;
  }

  /** Combines two handgear to merge into one gear piece with totalled attack and defence.
   * @param hand passes the hand gear list
   * @return combined handgear element
   */
  public GearBase addCharHandGear(List<HandGear> hand) {
    if (hand.size() > hand1) {
      throw new IllegalArgumentException("Quantity of Handgear cannot exceed 10");
    }
    while (hand.size() != 1) {
      GearBase new2 = hand.get(0).combine(hand.get(0),hand.get(1));
      initialAttack += new2.getAttack();
      initialDefense += new2.getDefense();
      hand.remove(hand.get(0));
      hand.remove(hand.get(0));
      hand.add((HandGear) new2);
    }
    return new HandGear(hand.get(0).getGearName(),hand.get(0).getAttack(),hand.get(0).getDefense());
  }

  /** Combines jewelry items to merge into one gear piece with totalled attack and defence.
   * @param jewel passes the jewelry item list
   * @return combined jewelry element
   */
  public GearBase addCharJewelry(List<Jewelry> jewel) {
    while (jewel.size() != 1) {
      GearBase new2 = jewel.get(0).combine(jewel.get(0),jewel.get(1));
      initialAttack += new2.getAttack();
      initialDefense += new2.getDefense();
      jewel.remove(jewel.get(0));
      jewel.remove(jewel.get(0));
      jewel.add((Jewelry) new2);
    }
    return new Jewelry(jewel.get(0).getGearName(),
            jewel.get(0).getAttack(),jewel.get(0).getDefense());
  }

  /** Combines foot gear items to merge into one gear piece with totalled attack and defence.
   * @param foot passes the foot gear list
   * @return combined foot gear element
   */
  public GearBase addCharFootGear(List<FootGear> foot) {
    if (foot.size() > foot1 ) {
      throw new IllegalArgumentException("Quantity of Footgear cannot exceed 2");
    }
    while (foot.size() != 1) {
      GearBase new3 = foot.get(0).combine(footGearList.get(0),footGearList.get(1));
      initialAttack += new3.getAttack();
      foot.remove(foot.get(0));
      foot.remove(foot.get(0));
      foot.add((FootGear) new3);
    }
    return new FootGear(foot.get(0).getGearName(),foot.get(0).getAttack());
  }

  /**
   * Return the attack value for respective Player character.
   * @return gives the attack value of the Player character
   */
  public int getAttack() {
    int temp1 = initialAttack;
    return (int)temp1;
  }

  /**
   * Return the defense value for respective Player character.
   * @return gives the defence value of the Player character
   */
  public int getDefense() {
    int temp2 = initialDefense;
    return (int)temp2;
  }

  @Override
  public String toString() {
    return String.format("Player{"
            + "charId=" + charId + ", attack total=" + initialAttack
            + ", defense total=" + initialDefense + ",\n HeadGearList ="
            + headGearList + ",\n HandGearList =" + handGearList
            + ",\n FootGearList =" + footGearList + ",\n JewelryList =" + jewelryList + '}');
  }
}
