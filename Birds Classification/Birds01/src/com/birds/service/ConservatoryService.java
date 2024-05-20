package com.birds.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.birds.abstracts.Birds;
import com.birds.exceptions.AviariesLimitReachedException;
import com.birds.objects.Aviaries;
import com.birds.objects.BirdsOfPreyConservatory;
import com.birds.objects.Conservatory;
import com.birds.objects.DefaultConservatory;
import com.birds.objects.FlightLessConservatory;
import com.birds.objects.WaterFowlConservatory;
import com.birds.types.subtypes.African_Jacana;
import com.birds.types.subtypes.Doves;
import com.birds.types.subtypes.Ducks;
import com.birds.types.subtypes.Eagles;
import com.birds.types.subtypes.Emus;
import com.birds.types.subtypes.Geese;
import com.birds.types.subtypes.Gray_Parrot;
import com.birds.types.subtypes.Great_Auk;
import com.birds.types.subtypes.Hawks;
import com.birds.types.subtypes.Horned_Puffin;
import com.birds.types.subtypes.Kiwis;
import com.birds.types.subtypes.Moas;
import com.birds.types.subtypes.Osprey;
import com.birds.types.subtypes.Rose_ring_parakeet;
import com.birds.types.subtypes.Sulfer_crested_cockatoo;
import com.birds.types.subtypes.Swans;
import com.birds.values.Values;

/**
 * ConservatoryService allows to add birds, view birds, add conservatory, view the list of aviaries,
 * search for a bird, list all birds, their food and quantity as well.
 */

public class ConservatoryService {

  private DefaultConservatory defaultConservatory;
  private FlightLessConservatory flightLessConservatory;
  private WaterFowlConservatory waterFowlConservatory;
  private BirdsOfPreyConservatory birdsOfPreyConservatory;
  private AviaryService aviaryService;
  private FoodService foodService;
  private static int id = 0;

  /** Functionality to add birds to conservatory. */
  public boolean addBirds(int choice) {
    Birds bird = getBirdOfChoice(choice);
    List<Aviaries> aviaries;
    try {
      if (bird.getExtinct().contentEquals(Values.Extinct.EXTINCT.toString())) {
        System.out.println("Cannot add extinct bird");
        return false;
      } else {
        if (bird.getType().contentEquals(Values.Type.PREY.toString())) {
          aviaries = birdsOfPreyConservatory.getAviaries();
          aviaries = addBirdsIntoConservatory(bird, aviaries);
          birdsOfPreyConservatory.setAviaries(aviaries);
        } else if (bird.getType().contentEquals(Values.Type.NOT_PREY.toString())) {
          if (bird.getType().contentEquals(Values.Habitat.WATER.toString())) {
            aviaries = waterFowlConservatory.getAviaries();
            aviaries = addBirdsIntoConservatory(bird, aviaries);
            waterFowlConservatory.setAviaries(aviaries);
          } else {
            aviaries = defaultConservatory.getAviaries();
            aviaries = addBirdsIntoConservatory(bird, aviaries);
            defaultConservatory.setAviaries(aviaries);
          }
        } else {
          aviaries = flightLessConservatory.getAviaries();
          aviaries = addBirdsIntoConservatory(bird, aviaries);
          flightLessConservatory.setAviaries(aviaries);
        }
        System.out.println(bird.getName() + " has been added successfully to the conservatory");
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return false;
    }
    return true;
  }

  /** Functionality to view birds in conservatory. */
  public void viewBirds() {
    List<Birds> listOfBirds = getListOfBirds();
    System.out.println("Total number of birds - " + listOfBirds.size());
    List<Birds> newList = listOfBirds.stream().sorted().collect(Collectors.toList());
    newList.stream().forEach(bird -> System.out.println(bird));
  }

  private Birds getBirdOfChoice(int choice) {
    switch (choice) {
      case 1:
        return new African_Jacana();
      case 2:
        return new Doves();
      case 3:
        return new Ducks();
      case 4:
        return new Eagles();
      case 5:
        return new Emus();
      case 6:
        return new Geese();
      case 7:
        return new Gray_Parrot();
      case 8:
        return new Great_Auk();
      case 9:
        return new Hawks();
      case 10:
        return new Horned_Puffin();
      case 11:
        return new Kiwis();
      case 12:
        return new Moas();
      case 13:
        return new Osprey();
      case 14:
        return new Rose_ring_parakeet();
      case 15:
        return new Sulfer_crested_cockatoo();
      default:
        break;
    }
    return new Swans();
  }

  /**
   * Functionality to add birds to aviary after checking the limit of aviary.
   *
   * @throws AviariesLimitReachedException when the max limit is reached for aviary
   */
  private List<Aviaries> addBirdsIntoConservatory(Birds bird, List<Aviaries> aviariesList)
      throws AviariesLimitReachedException {
    if (aviaryService.getCountOfAviaries() <= 20) {
      if (aviariesList.size() == 0) {
        Aviaries aviary = new Aviaries(id++);
        aviary.addBirds(bird);
        aviariesList.add(aviary);
        aviaryService.addAviaries(aviary);
      } else {
        Aviaries aviary = aviariesList.get(aviariesList.size() - 1);
        if (aviary.getCount_of_birds() < 5) {
          aviary.addBirds(bird);
        } else {
          if (aviaryService.getCountOfAviaries() == 20) {
            throw new AviariesLimitReachedException("Limit of Aviaries has reached");
          }
          Aviaries aviary1 = new Aviaries(id++);
          aviary1.addBirds(bird);
          aviariesList.add(aviary1);
          aviaryService.addAviaries(aviary1);
        }
      }
    } else {
      throw new AviariesLimitReachedException("Limit of Aviaries has reached");
    }
    for (Map.Entry<String, Integer> entry : bird.getListOfFoodQuantities().entrySet()) {
      foodService.addFoodWithQuantity(entry.getKey(), entry.getValue());
    }
    return aviariesList;
  }

  /** Functionality to create conservatory. */
  public void createConservatory() {
    defaultConservatory = new DefaultConservatory();
    birdsOfPreyConservatory = new BirdsOfPreyConservatory();
    waterFowlConservatory = new WaterFowlConservatory();
    flightLessConservatory = new FlightLessConservatory();
    aviaryService = new AviaryService();
    foodService = new FoodService();
    System.out.println("Conservatory created Successfully\n\n");
  }

  /** Functionality to search birds in conservatory. */
  public boolean searchForABird(int choice) {
    Birds bird = getBirdOfChoice(choice);
    Conservatory conservatory;
    if (bird.getType().contentEquals(Values.Type.PREY.toString())) {
      conservatory = birdsOfPreyConservatory;
    } else if (bird.getType().contentEquals(Values.Type.NOT_PREY.toString())) {
      if (bird.getType().contentEquals(Values.Habitat.WATER.toString())) {
        conservatory = waterFowlConservatory;
      } else {
        conservatory = defaultConservatory;
      }
    } else {
      conservatory = flightLessConservatory;
    }
    boolean notPresent = true;
    for (Aviaries aviaries : conservatory.getAviaries()) {
      int count =
          (int)
              aviaries.getBirds().stream()
                  .filter(b -> b.getName().contentEquals(bird.getName()))
                  .count();
      if (count > 0) {
        notPresent = false;
        System.out.println(
            "Aviary with Id-" + aviaries.getId() + " has the bird - " + bird.getName());
      }
    }

    if (notPresent) {
      System.out.println(bird.getName() + " is not present in the conservatory\n");
      return false;
    }
    return true;
  }

  /** Functionality to view list of aviaries in conservatory. */
  public void listAllAviaries() {
    System.out.println("There are totally " + id + " Aviaries");
    System.out.println("Prey Birds Aviaries");
    birdsOfPreyConservatory.getAviaries().forEach(aviary -> System.out.println(aviary));
    System.out.println("\nWaterFowl Birds Aviaries");
    waterFowlConservatory.getAviaries().forEach(aviary -> System.out.println(aviary));
    System.out.println("\nFlightLess Birds Aviaries");
    flightLessConservatory.getAviaries().forEach(aviary -> System.out.println(aviary));
    System.out.println("\nNormal other Birds Aviaries");
    defaultConservatory.getAviaries().forEach(aviary -> System.out.println(aviary));
  }

  /** Functionality to list food and quantity in conservatory. */
  public void listAllFoodsAndQuantities() {
    foodService.listFoodsWithQuantities();
  }

  private List<Birds> getListOfBirds() {
    List<Birds> listOfBirds = new ArrayList<Birds>();

    for (Aviaries aviaries : defaultConservatory.getAviaries()) {
      listOfBirds.addAll(aviaries.getBirds());
    }
    for (Aviaries aviaries : birdsOfPreyConservatory.getAviaries()) {
      listOfBirds.addAll(aviaries.getBirds());
    }
    for (Aviaries aviaries : waterFowlConservatory.getAviaries()) {
      listOfBirds.addAll(aviaries.getBirds());
    }
    for (Aviaries aviaries : flightLessConservatory.getAviaries()) {
      listOfBirds.addAll(aviaries.getBirds());
    }
    return listOfBirds;
  }

  public static int getId() {
    return id;
  }
}
