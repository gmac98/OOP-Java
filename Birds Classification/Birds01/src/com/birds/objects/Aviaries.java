package com.birds.objects;

import java.util.ArrayList;
import java.util.List;
import com.birds.abstracts.Birds;

/**
 * Aviaries class establishes the parameters for Aviary like Aviary ID, the count of birds in
 * aviary, the list of the birds in that aviary, and sets the maximum limit of the aviary to 5.
 */
public class Aviaries {
  private int id;
  private int count_of_birds;
  private List<Birds> birds;
  private final int limit_of_birds = 5;

  /**
   * Creates a constructor to initialize the id and list of birds in aviary.
   *
   * @param id gives the ID of the aviary
   */
  public Aviaries(int id) {
    this.birds = new ArrayList<Birds>();
    this.id = id;
  }

  /** Returns count of birds in particular aviary. */
  public int getCount_of_birds() {
    return count_of_birds;
  }

  /** Sets the count of birds in aviary. */
  public void setCount_of_birds(int count_of_birds) {
    this.count_of_birds = count_of_birds;
  }

  /** Returns the list of birds in aviary. */
  public List<Birds> getBirds() {
    return birds;
  }

  /**
   * Checks the count in aviary to determine if bird can be added or no.
   *
   * @return true if count is less than 5
   */
  public boolean addBirds(Birds bird) {
    if (this.getCount_of_birds() < 5) {
      this.birds.add(bird);
      this.count_of_birds++;
      return true;
    }
    return false;
  }

  /** Returns the max limit of birds in aviary. */
  public int getLimit_of_birds() {
    return limit_of_birds;
  }

  /** Returns the id of the aviary. */
  public int getId() {
    return id;
  }

  /** Sets the id of the aviary. */
  public void setId(int id) {
    this.id = id;
  }

  /** Sets the birds in aviary with the list of birds. */
  public void setBirds(List<Birds> birds) {
    this.birds = birds;
  }

  /*
   * toString() gives the string representation of the aviaries.
   */
  @Override
  public String toString() {
    return "\tAviaries [id="
        + id
        + ", count_of_birds="
        + count_of_birds
        + "birds = "
        + birds
        + "]\n";
  }
}
