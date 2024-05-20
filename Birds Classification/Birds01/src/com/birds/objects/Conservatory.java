package com.birds.objects;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates class Conservatory that houses maximum of 20 aviaries and provides information about
 * aviaries in it.
 */
public class Conservatory {
  int id;
  int limitOfAviariesInConservatory = 20;
  List<Aviaries> aviaries;

  /** Creates constructor for Conservatory. */
  public Conservatory() {
    aviaries = new ArrayList<Aviaries>();
  }

  /** Getter for the list of aviaries. */
  public List<Aviaries> getAviaries() {
    return aviaries;
  }

  /** Setter for the list of aviaries. */
  public void setAviaries(List<Aviaries> aviaries) {
    this.aviaries = aviaries;
  }

  /** Getter for the ID of aviaries. */
  public int getId() {
    return id;
  }

  /** Setter for the ID of aviaries. */
  public void setId(int id) {
    this.id = id;
  }

  /** Getter for the limit of aviaries in conservatory. */
  public int getLimitOfAviariesInConservatory() {
    return limitOfAviariesInConservatory;
  }

  /** Setter for the limit of aviaries in conservatory. */
  public void setLimitOfAviariesInConservatory(int limitOfAviariesInConservatory) {
    this.limitOfAviariesInConservatory = limitOfAviariesInConservatory;
  }

  /** Getter for the count of aviaries in conservatory. */
  public int getCountOfAviaries() {
    return this.aviaries.size();
  }

  /*
   * toString() gives string representation of aviaries.
   */
  @Override
  public String toString() {
    return "Conservatory [id="
        + id
        + ", limitOfAviariesInConservatory="
        + limitOfAviariesInConservatory
        + ", aviaries="
        + aviaries
        + "]";
  }
}
