package conservatory;

import java.util.Scanner;

/** Driver class to demonstrate run of the program. **/
public class Driver {

  /** Main method that interacts with the user to obtain input and display output. **/
  public static void main(String[] args) {
    HabitatService habitatService = new HabitatService();
    TrackingSystem ts = new TrackingSystem();
    System.out.print("Conservatory created Successfully\n");

    Specie s1 = new Reptile("Dessert Tortoise","Desert tortoises dig underground "
            + "burrows in order to hide from the sun in the deep desert.",Size.MEDIUM,
            Status.ABUNDANT,FeatureType.DESSERT,20,60,
            false,true);
    Specie s2 = new Amphibian("Tree Frog","Tree frogs have a white spot beneath "
            + "each eye and a dark stripe from the rear of the eyes to the front of the legs.",
            Size.SMALL, Status.ABUNDANT, FeatureType.TREE_BRANCHES,
            10,32,true,false);
    Habitat h1 = new Habitat(1,20);
    Habitat h2 = new Habitat(2,30);
    h1.addSpecie(s1);
    h2.addSpecie(s2);
    AnimalHouse ah1 = new ReptileHouse(1);
    AnimalHouse ah2 = new AmphibianHouse(1);
    ah1.addHabitat(h1);
    ah2.addHabitat(h2);
    ts.addSpecies(s1);
    ts.addSpecies(s2);

    Scanner input = new Scanner(System.in);

    while (true) {
      System.out.println("1. View natural features in alphabetical order");
      System.out.println("2. View all species in Conservatory in alphabetical order");
      System.out.println("3. Search for a specie");
      System.out.println("4. List the habitats in the Conservatory");
      System.out.println("5. View habitat sign");
      System.out.println("6. Exit the application");

      int choice = input.nextInt();

      switch (choice) {
        case 1:
          ts.listNaturalFeatures();
          break;
        case 2:
          ts.viewSpecie();
          break;
        case 3:
          ts.searchSpecie(s1);
          break;
        case 4:
          ts.listHabitat();
          break;
        case 5:
          //viewHabitatSign();
          break;
        case 6:
          System.out.println("Application stopped Successfully");
          System.exit(1);
          break;
        default:
          System.out.println("Invalid input");
          break;
      }
    }
  }

}
