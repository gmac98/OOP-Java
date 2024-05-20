package conservatory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/** Test class for testing Specie. **/
public class SpecieTest {

  TrackingSystem ts = new TrackingSystem();
  Habitat h = new Habitat(1,10);
  Specie a = new Amphibian("Tree Frog","Tree frogs have a white spot beneath "
          + "each eye and a dark stripe from the rear of the eyes to the front of the legs.",
          Size.SMALL, Status.ABUNDANT, FeatureType.TREE_BRANCHES,
          10,32,true,false);

  Specie r = new Reptile("Dessert Tortoise","Desert tortoises dig underground "
          + "burrows in order to hide from the sun in the deep desert.",Size.MEDIUM,
          Status.ABUNDANT,FeatureType.DESSERT,20,60,
          false,true);

  @Test
  public void addOneSpecieTest() {
    assertEquals(true,h.addSpecie(a));
  }

}