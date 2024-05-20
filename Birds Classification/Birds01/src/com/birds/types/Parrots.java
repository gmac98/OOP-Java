package com.birds.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.birds.abstracts.Birds;
import com.birds.utilities.RandomGenerator;

/**Parrots class defines properties for parrots.
 */
public class Parrots extends Birds {

  /**
   * Creates constructor for Parrots to initialize its values.
   * @param name name of the bird
   * @param type type of the bird
   * @param wings number of wings on bird
   * @param extinct tells if bird is extinct or not
   * @param habitat gives the habitat of bird
   * @param flying tells if bird can fly
   * @param size_of_birds gives size of bird
   * @param intelligent tells if bird is of intelligent category
   */
  public Parrots(
      String name,
      String type,
      int wings,
      String extinct,
      String habitat,
      boolean flying,
      String size_of_birds,
      boolean intelligent) {
    super(name, type, wings, extinct, habitat, flying, size_of_birds, flying);
    // TODO Auto-generated constructor stub
  }

  @Override
  public String getDistinctFeature() {
    String features =
        "short, curved beak. Parrots are known for their intelligence and ability to mimic sounds. "
            + "They can learn upto 100 words. Favourite Saying can be:'Hello,Hello','How do you do'";
    return features;
  }

  @Override
  public List<String> getListOfLivingHabitats() {
    List<String> habitats = new ArrayList<String>();
    habitats.add("tropical rainforest");
    habitats.add("canopy");
    return habitats;
  }

  @Override
  public List<String> getListOfFoodItems() {
    List<String> foods = new ArrayList<String>();
    foods.add("nuts");
    foods.add("fruits");
    foods.add("seeds");
    foods.add("insects");
    return foods;
  }

  @Override
  public Map<String, Integer> getListOfFoodQuantities() {
    List<String> foodItems = getListOfFoodItems();
    Map<String, Integer> foodListWithQuantities = new HashMap<String, Integer>();
    for (String item : foodItems) {
      foodListWithQuantities.put(
          item, new Integer(RandomGenerator.getRandomNumberUsingInts(1, 10)));
    }
    return foodListWithQuantities;
  }
}
