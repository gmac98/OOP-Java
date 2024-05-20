# Project-01--Reptiles

## Overview

  - Problem definition defines a tracking system for Cold Blooded Conservatory to be able to add animals to its Reptile houses and be able to track every animal in its Habitat as well as in the Reptile houses.
  - The problem has been solved using class hierarcy and polymorphism. The Specie is a super class to Reptile and Amphibian class, hence an animal can be initialized as reptile or amphibian. This animal is then added to the AnimalHouse which emcompasses several houses for reptiles and amphibians, each house can further have multiple habitats and each habitat has atmost 3 natural features.


## Features

- All the classes have been added as per the modified design and do not contain any errors.
- The display features do not always work as needed due to exeception and object handling.

### How To Run. 
How to run the jar file

```sh
$ java Driver.java // To run the driver program
$ 1                // Enter input choice amongst given options to see the output
$ 6                // To exit application
```

## How to Use the Program. 
Read the instructions provided on console interface and input appropriate choice to view the output for the given choice.

### Description of Example Runs. 

Run 1
  1. read a message from the screen
  2. input choice amongst the given choices on screen
  3. output will be displayed on screen
  4. input next choice
  5. input exit application choice to exit program run

## Design/Model Changes. 
A new class called TrackingSystem was introduced to monitor the whole conservatory system and give the required user outputs. Additionally, another called AnimalHouse was created to handle multiple habitats.

## Assumptions. 
- The animal house can have a maximum of 20 habitats and each of these habitats can have a maximum of 3 features. 
- The co-exist characteristics of the specie is  a boolean value signifying whether a specie is capable of coexisting or not. 
- As reptiles and amphibians cannot be mixed together, each are placed into separte houses, namely reptile house and amphibian house under super class Animal House.

## Limitations. 
- The program is not able to efficiently obtain the required display lists to display through the driver class.
- The functionality of checking overlapping temperature ranges was not implemented.