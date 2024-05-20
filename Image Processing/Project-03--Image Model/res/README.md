# Project-03--Image Model

## Overview

  - Image model creates a model that can be used to manipulate images to produce some interesting effects. Images can be manipulated by increasing brightness, lower intensity, sharpening, blurring, converting to greyscale etc.
  - The model has implemented functionality for image filtering like blurring and sharpening, image transformation like greyscale and sepia tone, and reducing color density of an image. 
  - The model uses ImageUtilities class to read the original image and write the modified image to file. It converts every image into a 3D array of RGB values for each pixel position.
  - It implements various image processing kernels, matrices and techniques on the 3D array of pixels of the image to produce the desired effect on the image and then writes this modified image to file.


## Features

- If the specified image is available in the project folder, then it correctly reads the image sample1.jpeg and converts it into 3D array.
- It correctly implements the blurring image filtering on the original image and writes the modified image to file as blur.jpg.
- It correctly implements the sharpening image filtering on the original image and writes the modified image to file as sharpening.jpg.
- It correctly implements the greyscale image transformation on the original image and writes the modified image to file as greyscale.jpg.
- It correctly implements the sepia tone image transformation on the original image and writes the modified image to file as sepia_tone.jpg.
- It correctly implements the color density reduction on the original image and writes the modified image to file as floydSteinbergDithering.jpg.

### How To Run 
How to run the jar file

```sh
$ java Driver.java // To run the driver program
```

## How to Use the Program
Run the Driver class which implements image filtering (blurring, sharpening), image transformation (greyscale, sepia tone) and color density reduction on original image (sample1.jpeg). If you wish to perform image processing on a different image, change the name of the original image in Driver class to the desired image. Make sure that the desired image for image processing is correctly present in the project folder. Once the image is correctly read, it generates the desired output and writes the modified images to respective files. The output screen will display the message that the respective image processing is performed with the file name of the modified image.

### Description of Example Runs

Run 1
  1. Run the Driver.class
  2. Output displaying - "Blur filter is done ! Please check blur.jpg"
  3. Output displaying - "Blur filter is done ! Please check blur.jpg"
  4. Output displaying - "Sharpening filter is done ! Please check sharpening.jpg"
  5. Output displaying - "Greyscale is done ! Please check greyscale.jpg"
  6. Output displaying - "Sepia tone is done ! Please check sepia_tone.jpg"
  7. Output displaying - "Color density reduction is done ! Please check floydSteinbergDithering.jpg"
  8. Exit application.

## Design/Model Changes
ImageProcessing is implemented as an abstract class under the Image interface and implements the functionality for clamping and retrieving every pixel position in an image represented as a 3D array of RGB values. Blur and Sharpen are implemented as methods under Filter(ImageFilter) interface. Likewise, greyscale and sepiaTone are also implemented as methods under TransformInterface(Image Transformation) interface.

## Assumptions
- The image is an RGB image consisting of values for each pixel position.
- The driver code specifically reads the original image for processing from the project folder with the filename sample1.jpeg. This is checked with try-catch block if image with respective filename is not present before rendering any computation on image.
 

## Limitations
- Currently, the kernels for image filtering like blur and sharpening are written into the respective methods. However, for further implementation, this will be implemented with a kernel method wherein the kernel can be taken from user.
- The matrix for linear transformation on image like greyscale and sepia tone are written into the respective methods. However, for further implementation, this will be implemented with an individual method wherein the matrix can be taken from user.

## Citations
- First image used for the project /res/image1/sample1.jpeg - I own this image and authorizing its use in the project. 
- Second image used for the project /res/image2/sample1.jpeg - I own this image and authorizing its use in the project. 