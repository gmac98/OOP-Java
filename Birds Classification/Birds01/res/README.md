# Birds
Birds is an Abstract Class, Conservatory class contains the functionality for Conservatory and Aviaries class contains the functionality for Aviary.
DriverClass of the Birds01 package can be used to create conservatory, add birds to it, lookup birds, loopup aviaries, lookup conservatory, list foods and their quantity. ConservatoryServiceTest contains the test cases for testing methods in the class.

# How to run program

  - Run the DriverClass for user input and output -- The program is complete and runs end-to-end.
  - Tests are in ConservatoryServiceTest class -- All tests run correctly.

# Plan to test DriverClass

1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. Exit the application

There are six operations as listed above. We will try to test every operation.

Testing First Operation

	Step 1. Press 1 and Output should be - Conservatory created Successfully
			As the conservatory wasn't created before hand, we have to create it.
	
	Step 2. Press 1 and Output should be - Conservatory already exists
			As the conservatory was created in the previous step, we get a warning saying that Conservatory already exists.
	
	Step 3. Restart the application and Press any number between 2 - 5.
			Output - There is no conservatory for the operation to succeed. Create Conservatory
			As there is no conservatory to act upon.We get a warning to create conservatory.

			
Testing Second Operation
	
	Step 1. Press 2 and Output should be - list of birds to add
			Choose the bird number to add
			1. African Jacana 
			2. Doves  
			3. Ducks  
			4. Eagles  
			5. Emus  
			6. Geese  
			7. Gray Parrot  
			8. Great Auk  
			9. Hawks  
			10. Horned Puffin  
			11. Kiwis  
			12. Moas  
			13. Osprey  
			14. Rose Ring Parakeet  
			15. Sulfer Crested Cockatoo  
			16. Swans
	
	Step 2. Choose the bird to add, example - 1 
			Output -  AFRICAN_JACANA has been added successfully to the conservatory
	
	Step 3. Try to add as many as possible with different types
			Maximum allowed per Aviary = 5
			Maximum Aviary allowed = 20
			Maximum allowed birds = 100
			Aviaries are created as per the requirement
	Step 4. If the limit is reached, 100 birds are present, 101 bird cannot be added
			Output - Limit of Aviaries has reached
			
	
Testing Third Operation
	
	Step 1. Perform First and Second operation
	Step 2. Press 3
			Output - List of birds in Alphabetical order along with their characteristics

Testing Fourth Operation
	Step 1. Perform First and Second Operation
	Step 2. Search for the bird added. example - 2 was added before
			Output - Aviary with Id-0 has the bird - AFRICAN_JACANA
			Bird along with which Aviary its present is printed.
	Step 3. If bird of a type is not present but selected to search, for example - Eagles
			Output - EAGLES is not present in the conservatory

Testing Fifth Operation
	Step 1. Perform First and Second Operations
	Step 2. Press 5 and Enter
			Output- There are totally 1 Aviaries
					Prey Birds Aviaries
					
					WaterFowl Birds Aviaries
					
					FlightLess Birds Aviaries
					
					Normal other Birds Aviaries
						Aviaries [id=0, count_of_birds=1birds = [Birds [name=AFRICAN_JACANA, type=NOT_PREY, wings=2, extinct=HALF_EXTINCT, habitat=WATER, flying=false, size_of_birds=MEDIUM, intelligent=false, getDistinctFeature()=size from 0.006 to 4.4 pounds]
					]]
			Categorically printing the Aviaries.

Testing Sixth Operation
	Step 1. Perform First and Second Operations
	Step 2. Press 6 and Enter
			Output- Food = Item Name and Quantity = "<<some number>>"

Testing Seventh Operation
	Step 1. Press 7 and Enter
			Output - Application stopped Successfully
### Program Run 1
"D:\CS 5010\projects\Birds01\out\production\Birds01" com.birds.driverClass.DriverClass

1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
1
Conservatory created Successfully


1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
2
Choose the bird number to add
1. African Jacana 2. Doves  3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
1
AFRICAN_JACANA has been added successfully to the conservatory
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
2
Choose the bird number to add
1. African Jacana 2. Doves  3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
7
GRAY_PARROT has been added successfully to the conservatory
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
3
Total number of birds - 2
Birds [name=AFRICAN_JACANA, type=NOT_PREY, wings=2, extinct=HALF_EXTINCT, habitat=WATER, flying=false, size_of_birds=MEDIUM, intelligent=false, getDistinctFeature()=size from 0.006 to 4.4 pounds, getListOfLivingHabitats()=[Wet lands, Fresh waters, Salt waters, Ocean], getListOfFoodItems()=[insects, larvae, aquatic invertibrates, small fish], getListOfFoodQuantities()={small fish=7, aquatic invertibrates=2, larvae=4, insects=6}]
Birds [name=GRAY_PARROT, type=NOT_PREY, wings=2, extinct=NOT_EXTINCT, habitat=LAND, flying=false, size_of_birds=SMALL, intelligent=false, getDistinctFeature()=short, curved beak. Parrots are known for their intelligence and ability to mimic sounds. They can learn upto 100 words. Favourite Saying can be:'Hello,Hello','How do you do', getListOfLivingHabitats()=[tropical rainforest, canopy], getListOfFoodItems()=[nuts, fruits, seeds, insects], getListOfFoodQuantities()={fruits=2, nuts=9, seeds=4, insects=9}]
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
4
Choose the bird number to search for
1. African Jacana
2. Doves 3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
7
Aviary with Id-0 has the bird - GRAY_PARROT
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
5
There are totally 1 Aviaries
Prey Birds Aviaries

WaterFowl Birds Aviaries

FlightLess Birds Aviaries

Normal other Birds Aviaries
	Aviaries [id=0, count_of_birds=2birds = [Birds [name=AFRICAN_JACANA, type=NOT_PREY, wings=2, extinct=HALF_EXTINCT, habitat=WATER, flying=false, size_of_birds=MEDIUM, intelligent=false, getDistinctFeature()=size from 0.006 to 4.4 pounds, getListOfLivingHabitats()=[Wet lands, Fresh waters, Salt waters, Ocean], getListOfFoodItems()=[insects, larvae, aquatic invertibrates, small fish], getListOfFoodQuantities()={small fish=1, aquatic invertibrates=7, larvae=5, insects=8}], Birds [name=GRAY_PARROT, type=NOT_PREY, wings=2, extinct=NOT_EXTINCT, habitat=LAND, flying=false, size_of_birds=SMALL, intelligent=false, getDistinctFeature()=short, curved beak. Parrots are known for their intelligence and ability to mimic sounds. They can learn upto 100 words. Favourite Saying can be:'Hello,Hello','How do you do', getListOfLivingHabitats()=[tropical rainforest, canopy], getListOfFoodItems()=[nuts, fruits, seeds, insects], getListOfFoodQuantities()={fruits=9, nuts=8, seeds=6, insects=8}]]]

1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
6
Food = small fish, Quantity = 9
Food = fruits, Quantity = 8
Food = nuts, Quantity = 5
Food = seeds, Quantity = 7
Food = aquatic invertibrates, Quantity = 7
Food = larvae, Quantity = 4
Food = insects, Quantity = 9
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
7
Application stopped Successfully

Process finished with exit code 1
### Program Run 2
"D:\CS 5010\projects\Birds01\out\production\Birds01" com.birds.driverClass.DriverClass

1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
1
Conservatory created Successfully


1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
2
Choose the bird number to add
1. African Jacana 2. Doves  3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
4
EAGLES has been added successfully to the conservatory
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
2
Choose the bird number to add
1. African Jacana 2. Doves  3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
1
AFRICAN_JACANA has been added successfully to the conservatory
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
3
Total number of birds - 2
Birds [name=AFRICAN_JACANA, type=NOT_PREY, wings=2, extinct=HALF_EXTINCT, habitat=WATER, flying=false, size_of_birds=MEDIUM, intelligent=false, getDistinctFeature()=size from 0.006 to 4.4 pounds, getListOfLivingHabitats()=[Wet lands, Fresh waters, Salt waters, Ocean], getListOfFoodItems()=[insects, larvae, aquatic invertibrates, small fish], getListOfFoodQuantities()={small fish=7, aquatic invertibrates=2, larvae=7, insects=9}]
Birds [name=EAGLES, type=PREY, wings=2, extinct=NOT_EXTINCT, habitat=LAND, flying=true, size_of_birds=LARGE, intelligent=false, getDistinctFeature()=Sharped hooked beak with visible nostrils, getListOfLivingHabitats()=[Mountainous Plains, Deserts, Moist Areas, Tropical Areas], getListOfFoodItems()=[insects, small mammals, other birds, fish], getListOfFoodQuantities()={other birds=7, fish=2, insects=1, small mammals=8}]
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
4
Choose the bird number to search for
1. African Jacana
2. Doves 3. Ducks  4. Eagles  5. Emus  6. Geese  7. Gray Parrot  8. Great Auk  9. Hawks  10. Horned Puffin  11. Kiwis  12. Moas  13. Osprey  14. Rose Ring Parakeet  15. Sulfer Crested Cockatoo  16. Swans  
4
Aviary with Id-0 has the bird - EAGLES
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
5
There are totally 2 Aviaries
Prey Birds Aviaries
	Aviaries [id=0, count_of_birds=1birds = [Birds [name=EAGLES, type=PREY, wings=2, extinct=NOT_EXTINCT, habitat=LAND, flying=true, size_of_birds=LARGE, intelligent=false, getDistinctFeature()=Sharped hooked beak with visible nostrils, getListOfLivingHabitats()=[Mountainous Plains, Deserts, Moist Areas, Tropical Areas], getListOfFoodItems()=[insects, small mammals, other birds, fish], getListOfFoodQuantities()={other birds=1, fish=4, insects=2, small mammals=6}]]]


WaterFowl Birds Aviaries

FlightLess Birds Aviaries

Normal other Birds Aviaries
	Aviaries [id=1, count_of_birds=1birds = [Birds [name=AFRICAN_JACANA, type=NOT_PREY, wings=2, extinct=HALF_EXTINCT, habitat=WATER, flying=false, size_of_birds=MEDIUM, intelligent=false, getDistinctFeature()=size from 0.006 to 4.4 pounds, getListOfLivingHabitats()=[Wet lands, Fresh waters, Salt waters, Ocean], getListOfFoodItems()=[insects, larvae, aquatic invertibrates, small fish], getListOfFoodQuantities()={small fish=3, aquatic invertibrates=2, larvae=3, insects=6}]]]

1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
6
Food = small fish, Quantity = 2
Food = other birds, Quantity = 3
Food = fish, Quantity = 1
Food = aquatic invertibrates, Quantity = 9
Food = larvae, Quantity = 4
Food = insects, Quantity = 3
Food = small mammals, Quantity = 2
1. Create a conservatory
2. Add a bird
3. View the birds in Conservatory in alphabetical order
4. Search for a bird
5. List the aviaries in the Conservatory
6. List of the foods and its quantities
7. Exit the application
7
Application stopped Successfully

Process finished with exit code 1
### Test Cases Run 
Conservatory created Successfully


AFRICAN_JACANA has been added successfully to the conservatory
Cannot add extinct bird
Conservatory created Successfully


AFRICAN_JACANA has been added successfully to the conservatory
Aviary with Id-1 has the bird - AFRICAN_JACANA
PIGEONS is not present in the conservatory

Conservatory created Successfully


AFRICAN_JACANA has been added successfully to the conservatory
Aviary with Id-2 has the bird - AFRICAN_JACANA
PIGEONS is not present in the conservatory