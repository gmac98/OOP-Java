package conservatory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** TrackingSystem keeps a track of the conservatory
 * and which habitat it encompasses as well as which animals
 * are conserved in it.
 **/
public class TrackingSystem {
  private Specie s;
  private static int id = 0;
  private AmphibianHouse amphibianHouse;
  private ReptileHouse reptileHouse;
  private Map<Specie,Integer> specieCount;
  private HabitatService habitatService;
  private Habitat habitat;
  //private List<AnimalHouse> animalHouseList;

  /** Functionality to add specie to conservatory. */
  public boolean addSpecies(Specie s) {
    this.s = s;
    List<Habitat> habitatList;
    try {
      if (!s.animalStatus()) {
        throw new IllegalArgumentException("Extinct specie cannot be added.");
      } else {
        if (s instanceof Reptile) {
          habitatList = reptileHouse.getHabitatList();
          habitatList = addIntoConservatory(s, habitatList);
          reptileHouse.setHabitatList(habitatList);
        } else {
          habitatList = amphibianHouse.getHabitatList();
          habitatList = addIntoConservatory(s, habitatList);
          amphibianHouse.setHabitatList(habitatList);
        }
        System.out.println("Specie has been added successfully to the conservatory.");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  /**
   * Functionality to add specie to habitat after checking the limit of habitat.
   *
   * @throws IllegalStateException when the max limit is reached for aviary
   */
  private List<Habitat> addIntoConservatory(Specie s, List<Habitat> habitatList)
          throws IllegalStateException {
    if (habitatService.getCountOfHabitat() <= 20) {
      if (habitatList.size() == 0) {
        Habitat h = new Habitat(id++,habitat.getAvailableSpace());
        h.addSpecie(s);
        habitatList.add(h);
        habitatService.addHabitat(h);
      } else {
        Habitat h = habitatList.get(habitatList.size() - 1);
        if (habitat.getAvailableSpace() > s.animalSize()) {
          h.addSpecie(s);
        } else {
          if (habitatService.getCountOfHabitat() == 20) {
            throw new IllegalStateException("Max limit of habitats reached.");
          }
          Habitat h1 = new Habitat(id++,30);
          h1.addSpecie(s);
          habitatList.add(h);
          habitatService.addHabitat(h);
        }
      }
    } else {
      throw new IllegalStateException("Limit of Habitats has reached.");
    }
    return habitatList;
  }

  /** Functionality to view species in conservatory. */
  public void viewSpecie() {
    List<Specie> listOfSpecie = listOfSpecie();
    System.out.println("Total number of specie - " + listOfSpecie.size());
    List<Specie> newList = listOfSpecie.stream().sorted().collect(Collectors.toList());
    newList.stream().forEach(s -> System.out.println(s));
  }

  private List<Specie> listOfSpecie() {
    List<Specie> listOfSpecie = new ArrayList<Specie>();
    for (Habitat aviaries : reptileHouse.getHabitatList()) {
      listOfSpecie.addAll(aviaries.getSpecieList());
    }
    for (Habitat aviaries : amphibianHouse.getHabitatList()) {
      listOfSpecie.addAll(aviaries.getSpecieList());
    }
    return listOfSpecie;
  }

  /** Functionality to search specie in conservatory. */
  public boolean searchSpecie(Specie s) {
    this.s = s;
    AnimalHouse animalHouse;
    if (s instanceof Reptile) {
      animalHouse = reptileHouse;
    } else {
      animalHouse = amphibianHouse;
    }
    boolean notPresent = true;
    for (Habitat habitat : animalHouse.getHabitatList()) {
      int count =
              (int)
                      habitat.getSpecieList().stream()
                              .filter(b -> b.animalName().contentEquals(s.animalName()))
                              .count();
      if (count > 0) {
        notPresent = false;
        System.out.println(
                "Habitat " + habitat.getHabitatID());
      }
    }

    if (notPresent) {
      System.out.println(s.animalName() + " is not present in the conservatory.\n");
      return false;
    }
    return true;
  }

  /** Functionality to view list of aviaries in conservatory. */
  public void listHabitat() {
    System.out.println("There are total " + id + " habitats.");
    System.out.println("Reptile Habitats-");
    reptileHouse.getHabitatList().forEach(habitat -> System.out.println(habitat));
    System.out.println("\nAmphibian Habitats-");
    amphibianHouse.getHabitatList().forEach(habitat -> System.out.println(habitat));
  }

  public void listNaturalFeatures() {
    reptileHouse.getHabitatList().forEach(habitat -> System.out.println(habitat.getFeatureList()));
  }
  //return strings, not objects as strings are immutable(cannot be changed)

  //public String lookUpSpecie() {}


  //public String habitatSign() {}


  //public String habitatMap() {}


  //public String listSpecie() {}

  @Override
  public String toString() {
    return String.format("Tracking System (species = %d )",this.specieCount.size());
  }

}
