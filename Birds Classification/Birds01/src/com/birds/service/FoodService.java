package com.birds.service;

import java.util.HashMap;
import java.util.Map;

/**Functionality to add Food details to conservatory.
 */
public class FoodService {
  Map<String, Integer> map = new HashMap<String, Integer>();

  /**Functionality to view Food list in conservatory.
   */
  public void listFoodsWithQuantities() {
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      System.out.println("Food = " + entry.getKey() + ", Quantity = " + entry.getValue());
    }
  }

  /**Functionality to add Food list to conservatory.
   */
  public void addFoodWithQuantity(String foodItem, Integer quantity) {
    map.put(foodItem, quantity);
  }
}
