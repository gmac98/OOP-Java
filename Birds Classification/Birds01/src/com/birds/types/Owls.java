package com.birds.types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.birds.abstracts.Birds;
import com.birds.utilities.RandomGenerator;

/**Owls class defines properties for owls.
 */
public class Owls extends Birds {

  /**
   * Creates constructor for Owls to initialize its values.
   * @param name name of the bird
   * @param type type of the bird
   * @param wings number of wings on bird
   * @param extinct tells if bird is extinct or not
   * @param habitat gives the habitat of bird
   * @param flying tells if bird can fly
   * @param size_of_birds gives size of bird
   * @param intelligent tells if bird is of intelligent category
   */
  public Owls(
      String name,
      String type,
      int wings,
      String extinct,
      String habitat,
      boolean flying,
      String size_of_birds,
      boolean intelligent) {
    super(name, type, wings, extinct, habitat, flying, size_of_birds, flying);
  }

  @Override
  public String getDistinctFeature() {
    String features = "facial disk that frames the eyes and the bill";
    return features;
  }

  @Override
  public List<String> getListOfLivingHabitats() {
    List<String> habitats = new ArrayList<String>();
    habitats.add("Forests");
    habitats.add("Deserts");
    habitats.add("Prairies");
    habitats.add("Arctic Tundra");
    return habitats;
  }

  @Override
  public List<String> getListOfFoodItems() {
    List<String> foods = new ArrayList<String>();
    foods.add("small birds");
    foods.add("invertibrates");
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
