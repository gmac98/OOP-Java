package com.birds.driverClass;

import java.util.Scanner;
import com.birds.service.ConservatoryService;

/**
 * DriverClass contains the user input design so that user can interact with the system to
 * create a conservatory for birds, add birds to conservatory after rescuing it,
 * lookup a bird, lookup the conservatory, lookup the list of aviaries
 * and the food with quantity that need to be maintained in the conservatory.
 */
public class DriverClass {

  private static boolean createdConservatory = false;

  /**
   * Creates a main method to input values from user.
   */
  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    ConservatoryService conservatoryService = new ConservatoryService();

    while (true) {
      System.out.println("1. Create a conservatory");
      System.out.println("2. Add a bird");
      System.out.println("3. View the birds in Conservatory in alphabetical order");
      System.out.println("4. Search for a bird");
      System.out.println("5. List the aviaries in the Conservatory");
      System.out.println("6. List of the foods and its quantities");
      System.out.println("7. Exit the application");

      int choice = input.nextInt();

      if (choice != 1 && !createdConservatory) {
        System.out.println(
            "There is no conservatory for the operation to succeed. Create Conservatory\n\n");
      } else if (choice == 1 && createdConservatory) {
        System.out.println("Conservatory already exists");
      } else {
        switch (choice) {
          case 1:
            createConservatory(conservatoryService);
            break;
          case 2:
            addBirds(conservatoryService, input);
            break;
          case 3:
            viewBirds(conservatoryService);
            break;
          case 4:
            searchForABird(conservatoryService, input);
            break;
          case 5:
            listAllAviaries(conservatoryService);
            break;
          case 6:
            listAllFoodsAndQuantities(conservatoryService);
            break;
          case 7:
            System.out.println("Application stopped Successfully");
            System.exit(1);
          default:
            System.out.println("Please enter correct operation");
        }
      }
    }
  }

  private static void listAllFoodsAndQuantities(ConservatoryService conservatoryService) {
    conservatoryService.listAllFoodsAndQuantities();
  }

  private static void listAllAviaries(ConservatoryService conservatoryService) {
    conservatoryService.listAllAviaries();
  }

  private static void searchForABird(ConservatoryService conservatoryService, Scanner input) {
    System.out.println(
        "Choose the bird number to search for\n"
            + "1. African Jacana\n"
            + "2. Doves "
            + "3. Ducks  "
            + "4. Eagles  "
            + "5. Emus  "
            + "6. Geese  "
            + "7. Gray Parrot  "
            + "8. Great Auk  "
            + "9. Hawks  "
            + "10. Horned Puffin  "
            + "11. Kiwis  "
            + "12. Moas  "
            + "13. Osprey  "
            + "14. Rose Ring Parakeet  "
            + "15. Sulfer Crested Cockatoo  "
            + "16. Swans  ");
    int choice = input.nextInt();
    conservatoryService.searchForABird(choice);
  }


  private static void viewBirds(ConservatoryService conservatoryService) {
    conservatoryService.viewBirds();
  }

  private static void addBirds(ConservatoryService conservatoryService, Scanner input) {
    System.out.println(
        "Choose the bird number to add\n"
            + "1. African Jacana "
            + "2. Doves  "
            + "3. Ducks  "
            + "4. Eagles  "
            + "5. Emus  "
            + "6. Geese  "
            + "7. Gray Parrot  "
            + "8. Great Auk  "
            + "9. Hawks  "
            + "10. Horned Puffin  "
            + "11. Kiwis  "
            + "12. Moas  "
            + "13. Osprey  "
            + "14. Rose Ring Parakeet  "
            + "15. Sulfer Crested Cockatoo  "
            + "16. Swans  ");
    int choice = input.nextInt();

    if (choice >= 1 && choice <= 16) conservatoryService.addBirds(choice);
    else System.out.println("You have entered the wrong choice. Please start again");
  }

  private static void createConservatory(ConservatoryService conservatoryService) {
    conservatoryService.createConservatory();
    createdConservatory = true;
  }
}
