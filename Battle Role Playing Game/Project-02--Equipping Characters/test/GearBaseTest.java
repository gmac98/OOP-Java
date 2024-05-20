import org.junit.Test;

import game.FootGear;
import game.Gear;
import game.HandGear;
import game.HeadGear;
import game.Jewelry;
import static org.junit.Assert.assertEquals;

/**
 * Testing of the various gear equipments to verify they are correctly created
 * and validate necessary conditions.
 */
public class GearBaseTest {
  @Test
  public void testHeadGear() {
    Gear a1 = new HeadGear("Fantastic Hat", 5);
    assertEquals("{gearName='Fantastic Hat', attackValue=0, defenseValue=5}",a1.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidHeadGear() {
    Gear a1 = new HeadGear("Fantastic Hat", 0);
    assertEquals("{gearName='Fantastic Hat', attackValue=0, defenseValue=5}",a1.toString());
  }

  @Test
  public void testHandGear() {
    Gear a1 = new HandGear("Fantastic Glove",10,0);
    assertEquals("{gearName='Fantastic Glove', attackValue=10, defenseValue=0}",a1.toString());
  }


  @Test (expected = IllegalArgumentException.class)
  public void testInvalidHandGear() {
    Gear a1 = new HandGear("Glove",10, 10);
    assertEquals("{gearName='Glove', attackValue=10, defenseValue=0}",a1.toString());
  }

  @Test
  public void testFootGear() {
    Gear a1 = new FootGear("Fantastic Boot",10);
    assertEquals("{gearName='Fantastic Boot', attackValue=10, defenseValue=0}",a1.toString());
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidFootGear() {
    Gear a1 = new FootGear("Fantastic Boot",0);
  }

  @Test
  public void testJewelry() {
    Gear a1 = new Jewelry("Fantastic Ring",0,15);
    assertEquals("{gearName='Fantastic Ring', attackValue=0, defenseValue=15}",a1.toString());
  }


  @Test (expected = IllegalArgumentException.class)
  public void testInvalidJewelry() {
    Gear a1 = new Jewelry("Ring",10, 10);
    assertEquals("{gearName='Ring', attackValue=10, defenseValue=10}",a1.toString());
  }
}
