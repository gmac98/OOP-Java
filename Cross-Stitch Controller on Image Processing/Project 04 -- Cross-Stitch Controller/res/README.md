# Project 04 -- Cross-Stitch Controller

## Overview
- Controller takes input from the user and tells the model what to do. Here, the controller takes a batch file of commands and tells the model to perform those functionalities, model performs the required operations and passes output to controller. Controller saves and displays output to the user.
- Model creates a model that can be used to manipulate images to produce some interesting effects. Images can be manipulated by sharpening, blurring, greyscaling, sepia toning, dithering, mosaic, pixelation and cross-stitch pattern generation.
- The model uses ImageUtilities class to read the original image and performs functionality on it. It converts every image into a 3D array of RGB values for each pixel position.
- It implements various image processing kernels, matrices and techniques on the 3D array of pixels of the image to produce the desired effect on the image and then writes this modified image to file.


## Features

- Controller takes input from a batch file. A user can type all the required image effects in a file and pass it to the controller.
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
Run jar file from project folder.
```sh
$ java -jar Image.jar batch.txt 
```
Arguments needed to run jar file
- batch.txt - batch file containing user commands to be executed by controller

## How to Use the Program
- Make sure that the batch file name specified in the Driver class is present in project folder.
- Make sure that the images used for loading in the batch file are present in the project folder.
- Run the Driver class which implements controller, and tells the model to perform various functionalities on the image.
- If you wish to perform image processing on a different image, change the name of the original image in batch file to the desired image. Make sure that the desired image for image processing is correctly present in the project folder.
- Once the batch file execution is done, it generates the desired output and writes the modified images with respective file name as specified in batch file.
- The output screen will display the message that the respective image processing is performed with the file name of the modified image.

### Description of Example Runs

Run 1
  1. In Eclipse, click on Run -> run configurations
  2. Set Program Arguments to batch.txt in Arguments tab
  3. Set Encoding to UTF-16 in Common tab
  4. Run the Driver class
  5. Output displays the performed operations on image and the filename of saved images.
  8. Exit application.

## Design/Model Changes
Controller under the ControllerI interface is the controller of the projects that takes input from the user. Here, the controller takes a batch file containing user commands as input.
ImageProcessing is implemented as model under the Image interface and implements the functionality for image operations like sharpening, blurring, greyscaling, sepia toning, dithering, mosaic, pixelation and cross-stitch pattern generation.
Additional classes have been added to implement mosaic, pixelation and pattern generation.
Here, MVC design pattern is implemented with controller and model wherein the Driver calls the controller and the controller executes user commands.

## Assumptions
- The image is an RGB image consisting of values for each pixel position.
- User is aware of the limited commands supported by the project and will enter commands in specific format.
 

## Limitations
- User commands in specific format and using only exact keywords are supported by the project.
- Currently, the kernels for image filtering like blur and sharpening are written into the respective methods. However, for further implementation, this will be implemented with a kernel method wherein the kernel can be taken from user.
- The matrix for linear transformation on image like greyscale and sepia tone are written into the respective methods. However, for further implementation, this will be implemented with an individual method wherein the matrix can be taken from user.

## Citations
- First image used for the project /res/image1/sample1.jpeg - I own this image and authorizing its use in the project. 
- Second image used for the project /res/image2/sample1.jpeg - I own this image and authorizing its use in the project. 