package com.birds.abstracts;

import java.util.List;
import java.util.Map;

/**
 * Creates an abstract class bird that provides all the
 * information about the bird like its type, distinct features,if they are extinct or no,
 * number of wings, if the bird can fly, its habitat,what they eat and in what quantity.
 */
public abstract class Birds implements Comparable<Birds> {
  private String name = null;
  private String type = null;
  private int wings = 0;
  private String extinct = null;
  private String habitat = null;
  private boolean flying = true;
  private String size_of_birds = null;
  private boolean intelligent = false;

  /**
   * Constructs a constructor for Birds that gives a complete description of the bird.
   *
   * @param name the name of the bird
   * @param type the type of the bird
   * @param wings the number of wings on the bird
   * @param extinct gives the value for if the bird is extinct or no
   * @param habitat gives the land or water habitat for bird
   * @param flying tells if the bird can fly as flightless birds don't fly
   * @param size_of_birds gives the size of the bird
   * @param intelligent tells if the bird is an intelligent type of bird or no
   */
  public Birds(
      String name,
      String type,
      int wings,
      String extinct,
      String habitat,
      boolean flying,
      String size_of_birds,
      boolean intelligent) {
    super();
    this.name = name;
    this.type = type;
    this.wings = wings;
    this.extinct = extinct;
    this.habitat = habitat;
    this.flying = flying;
    this.size_of_birds = size_of_birds;
    this.intelligent = intelligent;
  }

  /**
   * Getter to fetch the name of the bird.
   * @return the name of the bird
   */

  public String getName() {
    return name;
  }

  /**
   * Setter to set the name of the bird.
   * @param name sets the name of the bird
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Getter to get the type of bird.
   * @return the type of the bird
   */

  public String getType() {
    return type;
  }

  /**
   * Setter to set the Type of bird.
   * @param type gives the type of the bird
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * Getter to get the number of wings on the bird.
   * @return the number of wings on the bird
   */
  public int getWings() {
    return wings;
  }

  /**
   * Setter to set the number of wings on the bird.
   * @param wings sets the number of wings of the bird
   */
  public void setWings(int wings) {
    this.wings = wings;
  }

  /**
   * Getter to get if the bird is extinct or no.
   * @return whether the bird is extinct or no
   */
  public String getExtinct() {
    return extinct;
  }

  /**
   * Setter to set if the bird is extinct or no.
   * @param extinct sets the value for if the bird is extinct or no
   */
  public void setExtinct(String extinct) {
    this.extinct = extinct;
  }

  /**
   * Getter to get the habitat of the bird.
   * @return the habitat value of the bird
   */
  public String getHabitat() {
    return habitat;
  }

  /**
   * Setter to set the habitat of the bird.
   * @param habitat gives the habitat of the bird
   */
  public void setHabitat(String habitat) {
    this.habitat = habitat;
  }

  /**
   * Gives a boolean value to tell if the bird can fly or no.
   * @return flying value for tell if the bird can fly or no
   */
  public boolean isFlying() {
    return flying;
  }

  /**
   * Setter to set if the bird can fly or no.
   * @param flying gives if the bird can fly or no
   */
  public void setFlying(boolean flying) {
    this.flying = flying;
  }

  /**
   * Getter to get the size of the bird.
   * @return the size value of bird
   */
  public String getSize_of_birds() {
    return size_of_birds;
  }

  /**
   * Setter to set the size of the bird.
   * @param size_of_birds gives the size of the bird
   */
  public void setSize_of_birds(String size_of_birds) {
    this.size_of_birds = size_of_birds;
  }

  /**
   * Gives a boolean value telling if the bird belongs to intelligent category or no.
   * @return the value for if the bird is of intelligent classification or no
   */
  public boolean isIntelligent() {
    return intelligent;
  }

  /**
   * Setter to set the value about if the bird is intelligent or no.
   * @param intelligent gives the value for if the bird is set to be intelligent category or no
   */
  public void setIntelligent(boolean intelligent) {
    this.intelligent = intelligent;
  }

  /**
   * Fetches the distinct features of the bird.
   */
  public abstract String getDistinctFeature();

  /**
   * Fetches the list of living habitat of the bird.
   */
  public abstract List<String> getListOfLivingHabitats();

  /**
   * Fetches the list of food items to be stored for the birds.
   */
  public abstract List<String> getListOfFoodItems();

  /**
   * Fetches the list of food quantities to be stored for the birds.
   */
  public abstract Map<String, Integer> getListOfFoodQuantities();

  /* (non-Javadoc)
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Birds o) {
    return this.getName().substring(0, 3).compareTo(o.getName().substring(0, 3));
  }

  @Override
  public String toString() {
    return "Birds [name="
        + name
        + ", type="
        + type
        + ", wings="
        + wings
        + ", extinct="
        + extinct
        + ", habitat="
        + habitat
        + ", flying="
        + flying
        + ", size_of_birds="
        + size_of_birds
        + ", intelligent="
        + intelligent
        + ", getDistinctFeature()="
        + getDistinctFeature()
        + ", getListOfLivingHabitats()="
        + getListOfLivingHabitats()
        + ", getListOfFoodItems()="
        + getListOfFoodItems()
        + ", getListOfFoodQuantities()="
        + getListOfFoodQuantities()
        + "]";
  }
}
