# Project 05 -- Cross-Stitch Application

## Overview
- Controller takes input from the user and tells the model what to do. Here, we have two controllers- one is View Controller and other is Console Controller as we are displaying user input and output via console and GUI.
- View Controller takes user input from its GUI window by displaying all its options to the user, user selects certain operations using buttons and menu options. View passes these inputs to the ViewController and the controller tells the model to compute the required functionality. Once computed, it returns the result to the controller and the controller passes it to the view to display output to user via GUI.
- Console controller takes a batch file of commands and tells the model to perform those functionalities, model performs the required operations and passes output to controller. Controller saves and displays output to the user.
- Model creates a model that can be used to manipulate images to produce some interesting effects. Images can be manipulated by sharpening, blurring, greyscaling, sepia toning, dithering, mosaic, pixelation and cross-stitch pattern generation.
- The model uses ImageUtilities class to read the original image and performs functionality on it. It converts every image into a 3D array of RGB values for each pixel position.
- It implements various image processing kernels, matrices and techniques on the 3D array of pixels of the image to produce the desired effect on the image and then writes this modified image to file.


## Features

- ViewController correctly opens a GUI window.
- ViewController provides the options to load a file, perform various Image processing filters on this image, as well generate cross-stitch pattern. The user also has the option to save the resultant image to file.
- ConsoleController takes input from a batch file. A user can type all the required image effects in a file and pass it to the controller.
- If the specified image is available in the project folder, then it correctly loads the image and converts it into 3D array.
- It correctly implements the blurring image filtering on the original image.
- It correctly implements the sharpening image filtering on the original image.
- It correctly implements the greyscale image transformation on the original image.
- It correctly implements the sepia tone image transformation on the original image.
- It correctly implements the color density reduction on the original image.
- It correctly implements the mosaic image effect on the original image.
- It correctly implements the pixelation image effect on the original image.
- It correctly implements the cross stitch pattern generation on the original image.
- It correctly saves the processed image to the filename specified.

### How To Run 
How to run the jar file
```sh
$ java -jar Program.jar batch.txt 
```
Invoked in this manner the program should open the script file, execute it and then shut down.Ensure that batch contains correct commands and sample.jpeg is correctly present in folder.Also, there must be folder /out in project folder to save images into.
```sh
$ java -jar Program.jar -interactive
```
Invoked in this manner the program should open the graphical user interface.
Arguments needed to run jar file
- batch.txt - batch file containing user commands to be executed by controller
- interactive - Opens GUI window to display view.

## How to Use the Program
- Make sure that there is a sample image to load file into GUI.
- Click appropriate buttons in window and menu options to execute required functionality.
- Make sure that the batch file name specified in the Driver class is present in project folder.
- Make sure that the images used for loading in the batch file are present in the project folder.
- Run the Driver class which implements controller, and tells the model to perform various functionalities on the image.
- If you wish to perform image processing on a different image, change the name of the original image in batch file to the desired image. Make sure that the desired image for image processing is correctly present in the project folder.
- Once the batch file execution is done, it generates the desired output and writes the modified images with respective file name as specified in batch file.
- The output screen will display the message that the respective image processing is performed with the file name of the modified image.

### Description of Example Runs

Run 1
  1. In Eclipse, click on Run -> run configurations
  2. Set Program Arguments to "batch.txt" in Arguments tab
  3. Set Encoding to UTF-16 in Common tab
  4. Create a folder /out in Project folder to save image files into.
  5. Run the Driver class
  6. Output displays the performed operations on image and the filename of saved images.
  7. Exit application.

Run 2
  1. In Eclipse, click on Run -> run configurations
  2. Set Program Arguments to "intearctive" in Arguments tab
  3. Set Encoding to UTF-16 in Common tab
  4. Run the Driver class
  5. GUI window screen will be displayed.
  6. Select an image to load, loaded image will be shown in screen.
  7. Use buttons or menu options to implement filters on image.
  8. Image processing outputs are shown in screen and message console will display operation being performed.
  9. Enter seed/square value when prompted for filter option.
  10. Select color pixel to exchange in cross-stitch pattern displayed.
  11. You can save image to file with filename.
  12. Select Exit option from menu to exit application.


## Design/Model Changes
-VControllerI is the controller for the View interface and offers intearctive GUI to the user. VControllerI takes input via view, instructs model to process, model processes and return result to controller, controller then displays this output to GUI.
-Controller under the ControllerI interface is the controller of the console that takes input from the user. Here, the controller takes a batch file containing user commands as input.
-ImageProcessing is implemented as model under the Image interface and implements the functionality for image operations like sharpening, blurring, greyscaling, sepia toning, dithering, mosaic, pixelation and cross-stitch pattern generation.
-Additional classes have been added to implement mosaic, pixelation and pattern generation.
-Here, MVC design pattern is implemented with controller and model wherein the view takes user input or input is passed via batch file to console, and controller instructs model to execute functionality and returns result to controller. The console or GUI view then displays the output to user.

## Assumptions
- The image is an RGB image consisting of values for each pixel position.
- User is aware of the limited commands supported by the project and will enter commands in specific format.
 

## Limitations
- User commands in specific format and using only exact keywords are supported by the project.
- Currently, the kernels for image filtering like blur and sharpening are written into the respective methods. However, for further implementation, this will be implemented with a kernel method wherein the kernel can be taken from user.
- The matrix for linear transformation on image like greyscale and sepia tone are written into the respective methods. However, for further implementation, this will be implemented with an individual method wherein the matrix can be taken from user.

## Citations
- sample image used for the project /res/ - I own this image and authorizing its use in the project. 