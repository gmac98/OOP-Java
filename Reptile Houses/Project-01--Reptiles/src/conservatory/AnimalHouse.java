package conservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AnimalHouse contains the list of habitat and helps coordinate multiple habitats.**/
public class AnimalHouse {

  private int numHabitat;
  private List<Habitat> habitatList;
  private Map<Specie,List<Integer>> specieListMap;

  /** Constructor to initialize habitat number. **/
  public AnimalHouse(int numHabitat) {
    this.numHabitat = numHabitat;
    habitatList = new ArrayList<Habitat>();
  }

  /** Method to add habitats to the animal house. **/
  public boolean addHabitat(Habitat h) {
    if (habitatList.size() < numHabitat) {
      this.habitatList.add(h);
      return true;
    }
    return false;
  }

  /** Getter for the list of habitats. */
  public List<Habitat> getHabitatList() {
    return habitatList;
  }

  /** Setter for the list of habitats. */
  public void setHabitatList(List<Habitat> habitatList) {
    this.habitatList = habitatList;
  }

  /*
   * toString() gives string representation of AnimalHouse.
   */
  @Override
  public String toString() {
    return String.format("Animal House (Num Habitat = %d, "
            + "Habitat list = %s",numHabitat,habitatList);
  }

}
