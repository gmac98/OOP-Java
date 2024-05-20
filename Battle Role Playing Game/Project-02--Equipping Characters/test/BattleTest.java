import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import game.Character;
import game.FootGear;
import game.Gear;
import game.HandGear;
import game.HeadGear;
import game.Jewelry;
import static org.junit.Assert.assertEquals;

/**
 * This class tests all the functionality related to the battle between two players
 * like testing that the quantity of gears do not exceed, names combine correctly.
 */
public class BattleTest {

  Gear g1 = new HeadGear("Fantastic Hat",10);
  Gear g2 = new HeadGear("Mighty Visor",15);
  Gear g5 = new FootGear("Stealthy Sneakers",5);
  Gear g6 = new FootGear("Super Boots",15);
  Gear g7 = new FootGear("Speedy Sneakers",5);
  Gear g13 = new HandGear("Super Glove", 5, 0);
  Gear g14 = new HandGear("Sturdy Shield", 0, 10);
  Gear g15 = new HandGear("Super Sword", 15, 0);
  Gear g16 = new HandGear("Shiny Shield", 0, 10);
  Gear g17 = new HandGear("Bulky Sword", 5, 0);
  Gear g18 = new HandGear("Magic Knife", 0, 10);
  Gear g19 = new HandGear("Invisibility Bracelet", 5, 0);
  Gear g20 = new HandGear("Electric Duster", 0, 10);
  Gear g21 = new HandGear("Invisibility Duster", 5, 0);
  Gear g22 = new HandGear("Electric Bracelet", 0, 10);
  Gear g23 = new HandGear("Electric Sword", -5, 0);
  Gear g28 = new Jewelry("Power Ring", 0, 5);
  Gear g29 = new Jewelry("Sturdy Crown", 10, 0);
  Gear g30 = new Jewelry("Shiny Ribbon", 0, -5);
  Gear g31 = new Jewelry("Electric Brooch", -1, 0);
  Gear g32 = new Jewelry("Invisibility Pendant", 0, -5);

  List<HeadGear> headGearChar = new ArrayList<>();
  List<HandGear> handGearChar = new ArrayList<>();
  List<FootGear> footGearChar = new ArrayList<>();
  List<Jewelry> jewelryChar = new ArrayList<>();

  Character char1 = new Character(1,10,15,headGearChar,handGearChar,footGearChar,jewelryChar);

  @Test
  public void testCombine() {

    handGearChar.add((HandGear) g13);
    handGearChar.add((HandGear) g14);
    char1.addCharHandGear(handGearChar);
    assertEquals(
        "Player{charId=1, attack total=15, defense total=25,\n"
            + " HeadGearList =[],\n"
            + " HandGearList =[{gearName='Super,Sturdy Shield', attackValue=5, defenseValue=10}],\n"
            + " FootGearList =[],\n"
            + " JewelryList =[]}",
        char1.toString());
  }

  @Test
  public void testCombine2() {

    footGearChar.add((FootGear) g5);
    footGearChar.add((FootGear) g6);
    char1.addCharFootGear(footGearChar);
    assertEquals(
        "Player{charId=1, attack total=30, defense total=15,\n"
            + " HeadGearList =[],\n"
            + " HandGearList =[],\n"
            + " FootGearList =[{gearName='Stealthy,Super Boots', attackValue=20,"
            + " defenseValue=0}],\n"
            + " JewelryList =[]}",
        char1.toString());
  }

  @Test
  public void testCombine3() {

    jewelryChar.add((Jewelry) g28);
    jewelryChar.add((Jewelry) g29);
    char1.addCharJewelry(jewelryChar);
    assertEquals(
        "Player{charId=1, attack total=20, defense total=20,\n"
            + " HeadGearList =[],\n"
            + " HandGearList =[],\n"
            + " FootGearList =[],\n"
            + " JewelryList =[{gearName='Power,Sturdy Crown', attackValue=10, defenseValue=5}]}",
        char1.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testHeadGearCount() {
    headGearChar.add((HeadGear) g1);
    headGearChar.add((HeadGear) g2);
    char1.addCharHeadGear(headGearChar);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testFootGearCount() {
    footGearChar.add((FootGear) g5);
    footGearChar.add((FootGear) g6);
    footGearChar.add((FootGear) g7);
    char1.addCharFootGear(footGearChar);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testHandGearCount() {
    handGearChar.add((HandGear) g13);
    handGearChar.add((HandGear) g14);
    handGearChar.add((HandGear) g15);
    handGearChar.add((HandGear) g16);
    handGearChar.add((HandGear) g17);
    handGearChar.add((HandGear) g18);
    handGearChar.add((HandGear) g19);
    handGearChar.add((HandGear) g20);
    handGearChar.add((HandGear) g21);
    handGearChar.add((HandGear) g22);
    handGearChar.add((HandGear) g23);
    char1.addCharHandGear(handGearChar);
  }

  @Test
  public void testWearGear() {
    headGearChar.add((HeadGear) g2);
    char1.addCharHeadGear(headGearChar);
    footGearChar.add((FootGear) g6);
    footGearChar.add((FootGear) g7);
    char1.addCharFootGear(footGearChar);
    handGearChar.add((HandGear) g20);
    handGearChar.add((HandGear) g21);
    handGearChar.add((HandGear) g22);
    handGearChar.add((HandGear) g23);
    char1.addCharHandGear(handGearChar);
    jewelryChar.add((Jewelry) g28);
    jewelryChar.add((Jewelry) g29);
    char1.addCharJewelry(jewelryChar);
    assertEquals(
        "Player{charId=1, attack total=40, defense total=75,\n"
            + " HeadGearList =[{gearName='Mighty Visor', attackValue=0, defenseValue=15}],\n"
            + " HandGearList =[{gearName='Electric,Invisibility,Electric,Electric Sword', "
            + "attackValue=0, defenseValue=20}],\n"
            + " FootGearList =[{gearName='Super,Speedy Sneakers', attackValue=20, "
            + "defenseValue=0}],\n"
            + " JewelryList =[{gearName='Power,Sturdy Crown', attackValue=10, defenseValue=5}]}",
        char1.toString());
  }

  @Test
  public void testAttackValue() {
    headGearChar.add((HeadGear) g2);
    char1.addCharHeadGear(headGearChar);
    footGearChar.add((FootGear) g6);
    footGearChar.add((FootGear) g7);
    char1.addCharFootGear(footGearChar);
    handGearChar.add((HandGear) g20);
    handGearChar.add((HandGear) g21);
    handGearChar.add((HandGear) g22);
    handGearChar.add((HandGear) g23);
    char1.addCharHandGear(handGearChar);
    jewelryChar.add((Jewelry) g28);
    jewelryChar.add((Jewelry) g29);
    char1.addCharJewelry(jewelryChar);
    assertEquals(40,char1.getAttack());
  }

  @Test
  public void testDefenseValue() {
    headGearChar.add((HeadGear) g2);
    char1.addCharHeadGear(headGearChar);
    footGearChar.add((FootGear) g6);
    footGearChar.add((FootGear) g7);
    char1.addCharFootGear(footGearChar);
    handGearChar.add((HandGear) g20);
    handGearChar.add((HandGear) g21);
    handGearChar.add((HandGear) g22);
    handGearChar.add((HandGear) g23);
    char1.addCharHandGear(handGearChar);
    jewelryChar.add((Jewelry) g28);
    jewelryChar.add((Jewelry) g29);
    char1.addCharJewelry(jewelryChar);
    assertEquals(75,char1.getDefense());
  }

  @Test
  public void testCursedItem() {
    jewelryChar.add((Jewelry) g30);
    jewelryChar.add((Jewelry) g31);
    jewelryChar.add((Jewelry) g32);
    char1.addCharJewelry(jewelryChar);
    assertEquals(8,char1.getAttack());
    assertEquals(0,char1.getDefense());
  }


}
