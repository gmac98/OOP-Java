# Project-02--Equipping Characters

## Overview

  - Problem definition defines a game battle where two players are initialized with basic attack and defense strength. Then, the players dress i.e equip with fighting gear items like head gear, hand gear, foot gear and jewellry. All these items temporarily adds or subtracts in the case of a cursed item, to the players attack power and defensive strength.
  - The problem has been solved using class hierarcy and polymorphism. Gear is a super class to HeadGear, HandGear, FootGear and Jewelry class, hence gear items of the following type can be added to chest of Gear. Two Characters have been initialized and 20 random items are assigned to each Player. Multiple gears of same type display combined name in the Character gear list.
  - Once the Players are eqipped with gear, they battle, damage value is calculated and result is displayed. User may choose to have a rematch of players, if they wish to do so.


## Features

- All the classes have been added as per the modified design and do not contain any errors.
- Interfaces ( Gear, AttackValue and DefenseValue ) give the  high-level understanding of the components of the project.
- BattleDriver correctly initializes 4 head gears, 8 foot gears, 15 hand gears, and 15 jewelry to the chest Gear.
- Two Players were initialized with basic attack and defense strength and randomnly assigned 20 items. Each Player with its gear items is displayed in the output, players battle wherein damage of each player and battle result is displayed.
- If user chooses to have a rematch, players are again dressed with equipment, else the program stops.

### How To Run. 
How to run the jar file

```sh
$ java BattleDriver.java // To run the driver program
$ Yes               // Enter input choice if user wishes to have a rematch
$ No                // To exit application and stop program run
```

## How to Use the Program. 
Run the battleDriver class which contains initialization of gears, players and starts battle between two players. Player equipment and battle result will be displayed to the screen. When prompted, if user wishes to have a rematch between players, enter "Yes", else enter "No" to stop and exit application.

### Description of Example Runs. 

Run 1
  1. Run the BattleDriver.class
  2. Output displaying Player 1 creation will be output to screen.
  3. Output displaying Player 1 equipments will be printed to screen.
  4. Output displaying Player 2 creation will be output to screen.
  5. Output displaying Player 2 equipments will be printed to screen.
  6. Battle result will be printed to screen.
  7. User input "Yes" to have a rematch, else input "No" to exit application.

## Design/Model Changes. 
Two new interfaces (AttackValue and DefenseValue) were added to the application so as to provide an efficient application of attackValue and defenseValue to various gear items.

## Assumptions. 
- Cursed items are denoted as items having negative attack or defense value.
- As cursed gears can have negative values for attack and defense value hence there cannot be validation on these fields besides them being non-zero.

## Limitations. 
- Application lacks the ability to reduce strength of worn out items across certain types of equipments.
- The functionality to print discarded items is limited to certain gear types and has not been extended to all gear types.