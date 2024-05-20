import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import game.Character;
import game.FootGear;
import game.HandGear;
import game.HeadGear;
import game.Jewelry;
import static org.junit.Assert.assertEquals;

/**
 * Testing Character class to verify correct creation of Character.
 * It also verifies invalid conditions of character class.
 */
public class CharacterTest {
  @Test
  public void testCharacter() {
    List<HeadGear> headGearChar = new ArrayList<>();
    List<HandGear> handGearChar = new ArrayList<>();
    List<FootGear> footGearChar = new ArrayList<>();
    List<Jewelry> jewelryChar = new ArrayList<>();

    Character char1 = new Character(1,10,15,headGearChar,handGearChar,footGearChar,jewelryChar);
    assertEquals(
        "Player{charId=1, attack total=10, defense total=15,\n"
            + " HeadGearList =[],\n"
            + " HandGearList =[],\n"
            + " FootGearList =[],\n"
            + " JewelryList =[]}",
        char1.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidCharacter() {
    List<HeadGear> headGearChar = new ArrayList<>();
    List<HandGear> handGearChar = new ArrayList<>();
    List<FootGear> footGearChar = new ArrayList<>();
    List<Jewelry> jewelryChar = new ArrayList<>();

    Character char1 = new Character(1,-10,15,headGearChar,handGearChar,footGearChar,jewelryChar);
    assertEquals(
        "Player{charId=1, attack total=-10, defense total=15,\n"
            + " HeadGearList =[],\n"
            + " HandGearList =[],\n"
            + " FootGearList =[],\n"
            + " JewelryList =[]}",
        char1.toString());
  }
}
