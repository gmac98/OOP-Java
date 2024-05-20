package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Battle Driver is the driver class that allows two players to battle. Each player has ID and
 * basic strength and gets equipped with gears before battle. Post battle, damage is calculated
 * and result is displayed. User can ask for a rematch if they want players to battle again.
 */
public class BattleDriver {
  /**
   * Main class contains the driver functionality
   * of coordinating the fight between two players.
   * @param args input arguments to the main method
   */
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String move;

    Gear g1 = new HeadGear("Fantastic Hat",10);
    Gear g2 = new HeadGear("Mighty Visor",15);
    Gear g3 = new HeadGear("Bulky Helmet",5);
    Gear g4 = new HeadGear("Shiny Helmet",10);

    Gear g5 = new FootGear("Stealthy Sneakers",5);
    Gear g6 = new FootGear("Super Boots",15);
    Gear g7 = new FootGear("Speedy Sneakers",5);
    Gear g8 = new FootGear("Hefty Boots",5);
    Gear g9 = new FootGear("Stealthy Hoverboard",10);
    Gear g10 = new FootGear("Super Hoverboard",5);
    Gear g11 = new FootGear("Bulky Hoverboard",10);
    Gear g12 = new FootGear("Shiny Hoverboard",5);

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
    Gear g24 = new HandGear("Sturdy Glove", 0, 10);
    Gear g25 = new HandGear("Super Shield", 5, 0);
    Gear g26 = new HandGear("Sturdy Knife", 0, -10);
    Gear g27 = new HandGear("Invisibility Sword", 0, 10);


    Gear g28 = new Jewelry("Power Ring", 0, 5);
    Gear g29 = new Jewelry("Sturdy Crown", 10, 0);
    Gear g30 = new Jewelry("Shiny Ribbon", 0, 5);
    Gear g31 = new Jewelry("Electric Brooch", 10, 0);
    Gear g32 = new Jewelry("Invisibility Pendant", 0, 5);
    Gear g33 = new Jewelry("Speedy Collar", 10, 0);
    Gear g34 = new Jewelry("Flaming Necklace", 0, 5);
    Gear g35 = new Jewelry("Burning Crown", 10, 0);
    Gear g36 = new Jewelry("Flaming Ring", 0, 5);
    Gear g37 = new Jewelry("Magic Crown", 10, 0);
    Gear g38 = new Jewelry("Healing Ribbon", 0, -5);
    Gear g39 = new Jewelry("Electric Pendant", 10, 0);
    Gear g40 = new Jewelry("Invisibility Brooch", 0, 5);
    Gear g41 = new Jewelry("Flaming Collar", -10, 0);
    Gear g42 = new Jewelry("Burning Necklace", 0, 5);
    Gear[]
            chest = {g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12, g13, g14,
              g15, g16, g17, g18, g19, g20, g21, g22, g23, g24,
                g25, g26, g27, g28, g29, g30, g31, g32, g33, g34,
              g35, g36, g37, g38, g39, g40, g41, g42};
    do {

      List<HeadGear> headGearList1 = new ArrayList<>();
      List<HandGear> handGearList1 = new ArrayList<>();
      List<FootGear> footGearList1 = new ArrayList<>();
      List<Jewelry> jewelryList1 = new ArrayList<>();

      Random r = new Random();
      int k;
      for (k = 0; k < 20; k++) {
        int randomNumber = r.nextInt(chest.length);
        if (chest[randomNumber] instanceof HeadGear) {
          headGearList1.add((HeadGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof HandGear) {
          handGearList1.add((HandGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof FootGear) {
          footGearList1.add((FootGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof Jewelry) {
          jewelryList1.add((Jewelry) chest[randomNumber]);
        }
      }
      System.out.println(headGearList1);
      System.out.println(handGearList1);
      System.out.println(footGearList1);
      System.out.println(jewelryList1);

      List<HeadGear> headGearChar = new ArrayList<>();
      List<HandGear> handGearChar = new ArrayList<>();
      List<FootGear> footGearChar = new ArrayList<>();
      List<Jewelry> jewelryChar = new ArrayList<>();
      Character char1 = new Character(1,10,15,headGearChar,
              handGearChar,footGearChar,jewelryChar);
      System.out.println(char1.toString());

      int i;
      for (i = 0; i < headGearList1.size(); i++) {
        if (headGearChar.size() == 0) {
          headGearChar.add(headGearList1.get(i));
          char1.addCharHeadGear(headGearChar);
        } else {
          if (headGearList1.get(i).getDefense() > headGearChar.get(0).getDefense()) {
            System.out.println("Discarded items:" + headGearChar.get(0));
            headGearChar.remove(0);
            headGearChar.add(headGearList1.get(i));
            char1.addCharHeadGear(headGearChar);
          }
        }
      }

      List<HandGear> handGearList11 = new ArrayList<>();
      if (handGearList1.size() == 1) {
        handGearChar.add(handGearList1.get(0));
      } else if (handGearList1.size() > 1) {
        for (i = 0; i < handGearList1.size(); i++) {
          handGearChar.add(handGearList1.get(i));
          if (i == 9) {
            break;
          }
        }
        GearBase gear11 = char1.addCharHandGear(handGearChar);
        handGearList11.add((HandGear) gear11);
      }

      List<FootGear> footGearList12 = new ArrayList<>();
      for (i = 0; i < footGearList1.size(); i++) {
        if (i == 0) {
          footGearChar.add(footGearList1.get(i));
        } else if (i == 1) {
          footGearChar.add(footGearList1.get(i));
          GearBase gear12 = char1.addCharFootGear(footGearChar);
          footGearList12.add((FootGear) gear12);
        }
      }

      List<Jewelry> jewelryList11 = new ArrayList<>();
      if (jewelryList1.size() == 1) {
        jewelryChar.add(jewelryList1.get(0));
      } else if (jewelryList1.size() > 1) {
        for (i = 0; i < jewelryList1.size(); i++) {
          jewelryChar.add(jewelryList1.get(i));
        }
        GearBase gear13 = char1.addCharJewelry(jewelryChar);
        jewelryList11.add((Jewelry) gear13);
      }

      System.out.println(char1.toString() + "\n");

      List<HeadGear> headGearList2 = new ArrayList<>();
      List<HandGear> handGearList2 = new ArrayList<>();
      List<FootGear> footGearList2 = new ArrayList<>();
      List<Jewelry> jewelryList2 = new ArrayList<>();

      for (k = 0; k < 20; k++) {
        int randomNumber = r.nextInt(chest.length);
        if (chest[randomNumber] instanceof HeadGear) {
          headGearList2.add((HeadGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof HandGear) {
          handGearList2.add((HandGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof FootGear) {
          footGearList2.add((FootGear) chest[randomNumber]);
        } else if (chest[randomNumber] instanceof Jewelry) {
          jewelryList2.add((Jewelry) chest[randomNumber]);
        }
      }
      System.out.println(headGearList2);
      System.out.println(handGearList2);
      System.out.println(footGearList2);
      System.out.println(jewelryList2);
      List<HeadGear> headGearChar2 = new ArrayList<>();
      List<HandGear> handGearChar2 = new ArrayList<>();
      List<FootGear> footGearChar2 = new ArrayList<>();
      List<Jewelry> jewelryChar2 = new ArrayList<>();

      Character char2 = new Character(2,20,15,headGearChar2,
              handGearChar2,footGearChar2,jewelryChar2);
      System.out.println(char2.toString());

      for (i = 0; i < headGearList2.size(); i++) {
        if (headGearChar2.size() == 0) {
          headGearChar2.add(headGearList2.get(i));
          char2.addCharHeadGear(headGearChar2);
        } else {
          if (headGearList2.get(i).getDefense() > headGearChar2.get(0).getDefense()) {
            System.out.println("Discarded items:" + headGearChar2.get(0));
            headGearChar2.remove(0);
            headGearChar2.add(headGearList2.get(i));
            char2.addCharHeadGear(headGearChar2);
          }
        }
      }

      List<HandGear> handGearList12 = new ArrayList<>();
      if (handGearList2.size() == 1) {
        handGearChar2.add(handGearList2.get(0));
      } else if (handGearList2.size() > 1) {
        for (i = 0; i < handGearList2.size(); i++) {
          handGearChar2.add(handGearList2.get(i));
          if (i == 9) {
            break;
          }
        }
        GearBase gear11 = char2.addCharHandGear(handGearChar2);
        handGearList12.add((HandGear) gear11);
      }

      List<FootGear> footGearList13 = new ArrayList<>();
      for (i = 0; i < footGearList2.size(); i++) {
        if (i == 0) {
          footGearChar2.add(footGearList2.get(i));
        } else if (i == 1) {
          footGearChar2.add(footGearList2.get(i));
          GearBase gear12 = char2.addCharFootGear(footGearChar2);
          footGearList13.add((FootGear) gear12);
        }
      }

      List<Jewelry> jewelryList12 = new ArrayList<>();
      if (jewelryList2.size() == 1) {
        jewelryChar2.add(jewelryList2.get(0));
      } else if (jewelryList2.size() > 1) {
        for (i = 0; i < jewelryList2.size(); i++) {
          jewelryChar2.add(jewelryList2.get(i));
        }
        GearBase gear13 = char1.addCharJewelry(jewelryChar2);
        jewelryList12.add((Jewelry) gear13);
      }

      System.out.println(char2.toString());

      System.out.println("\nStarting Battle:");
      int char1Damage = char2.getAttack() - char1.getDefense();
      System.out.println("Player 1 damage = " + char1Damage);
      int char2Damage = char1.getAttack() - char2.getDefense();
      System.out.println("Player 2 damage = " + char2Damage);
      if (char1Damage > char2Damage) {
        System.out.println("Player 2 wins!");
      } else if (char1Damage < char2Damage) {
        System.out.println("Player 1 wins!");
      } else {
        System.out.println("It is a tie!");
      }

      System.out.println("Do you want to play a rematch? Yes or No");
      move = input.next();
    }
    while (!move.equals("No"));



  }

}
