package conservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** Habitat class houses the species if there is space available in the animalHouse. **/
public class Habitat {
  private int habitatID;
  private int availableSpace;
  private List<FeatureType> featureList;
  private List<Specie> specieList;
  private int minTemp;
  private int maxTemp;
  private boolean hasReptiles;
  private boolean hasAmphibians;
  private int count;
  private Map<Specie, Integer> specieMap;

  /** Constructor to initialize the habitat object. **/
  public Habitat(int habitat,int availableSpace) {
    this.habitatID = habitatID;
    this.availableSpace = availableSpace;
    this.featureList = new ArrayList<FeatureType>(3);
    this.specieList = new ArrayList<Specie>();
  }

  /** Provides a natural features list within the habitats. **/
  public List<FeatureType> getFeatureList() {
    return this.featureList;
  }

  /** Returns the list of specie in habitat. */
  public List<Specie> getSpecieList() {
    return this.specieList;
  }

  /** Returns count of specie in particular habitat. */
  public int getCountOfSpecie() {
    return count;
  }

  public int getAvailableSpace() {
    return availableSpace;
  }

  /** Method to add specie to the Habitat. **/
  public boolean addSpecie(Specie specie) {
    if (availableSpace > specie.animalSize()) {
      this.specieList.add(specie);
      availableSpace = availableSpace - specie.animalSize();
      count++;
      return true;
    }
    return false;
  }

  public int getHabitatID() {
    return this.habitatID;
  }

  /** Sets the specie in habitat with the list of specie. */
  public void setSpecie(List<Specie> specieList) {
    this.specieList = specieList;
  }

  /*
   * toString() gives the string representation of the aviaries.
   */
  @Override
  public String toString() {
    return String.format("Habitat [id =%d ,specie count=%d, Specie =%s ]",
            habitatID,count,specieList);
  }

}
