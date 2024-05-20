package com.birds.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.birds.abstracts.Birds;
import com.birds.utilities.RandomGenerator;

/** WaterFowl class defines properties for waterfowl. */
public class WaterFowl extends Birds {

  /**
   * Creates constructor for WaterFowl to initialize its values.
   *
   * @param name name of the bird
   * @param type type of the bird
   * @param wings number of wings on bird
   * @param extinct tells if bird is extinct or not
   * @param habitat gives the habitat of bird
   * @param flying tells if bird can fly
   * @param size_of_birds gives size of bird
   * @param intelligent tells if bird is of intelligent category
   */
  public WaterFowl(
      String name,
      String type,
      int wings,
      String extinct,
      String habitat,
      boolean flying,
      String size_of_birds,
      boolean intelligent) {
    super(name, type, wings, extinct, habitat, flying, size_of_birds, intelligent);
  }

  @Override
  public String getDistinctFeature() {
    return "They live near water sources (fresh or salt).";
  }

  @Override
  public List<String> getListOfLivingHabitats() {
    List<String> habitats = new ArrayList<String>();
    habitats.add("Fresh water lakes");
    habitats.add("Salt water lakes");
    habitats.add("Fresh water ponds");
    return habitats;
  }

  @Override
  public List<String> getListOfFoodItems() {
    List<String> foods = new ArrayList<String>();
    foods.add("vegetation");
    foods.add("aquatic invertebrates");
    foods.add("fish");
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
