package image;

/**
 * Image represents a model that can be used to manipulate images to produce some interesting
 * effects. It takes in an image and writes actual image files in a variety of standard image
 * formats using 3D arrays. It performs image filtering, image transformations and color density
 * reduction.
 */
public interface Image {

  /**
   * Assigns each value in an image that is lesser than the minimum to the minimum,
   * and each value greater than the maximum to the maximum.
   * @param val each pixel value in the image
   * @return the clamped value for the pixel
   */
  int clampRange(int val);

  /**
   * Perform clamping on every value in an image to avoid overflow and
   * underflow while saving, and to display such images properly.
   * @param val array of pixel values of image
   * @return image with clamped values
   */
  int[] clamping(int[] val);

  /**
   * Retrieves the pixel value for each value in a image stored
   * as a 3D array containing RGB values for each pixel position.
   * @param pixels pixel position in an image
   * @param i the red value in pixel position
   * @param j the green value in pixel position
   * @param k the blue value in pixel position
   * @return RGB value of pixel position
   */
  int getPixel(int[][][] pixels, int i, int j, int k);
}
