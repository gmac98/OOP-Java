package image;

/**
 * Provides operations to be performed on image pixel values like calculation of redmean
 * distance value and operation like addition, subtraction, multiplication, clamping.
 */
public class ImageControl {

  /**
   * Retrieves the pixel value for each value in a image stored
   * as a 3D array containing RGB values for each pixel position.
   * @param pixels pixel position in an image
   * @param i the red value in pixel position
   * @param j the green value in pixel position
   * @param k the blue value in pixel position
   * @return RGB value of pixel position
   */
  public int pixel(int[][][] pixels, int i, int j, int k) {
    if (pixels == null || pixels.length == 0) {
      throw new IllegalArgumentException("Null arguments");
    }
    if (i < 0
            || i >= pixels.length
            || j < 0
            || j >= pixels[0].length
            || k < 0
            || k >= pixels[0][0].length) {
      return 0;
    }
    return pixels[i][j][k];
  }

  /**
   * Assigns each value in an image that is lesser than the minimum to the minimum,
   * and each value greater than the maximum to the maximum i.e. clamps R,G,B value
   * @param val each pixel value in the image
   * @return the clamped value for the pixel
   */
  public int clampRange(int val) {
    return Math.max(0, Math.min(255, val));
  }

  /**
   * Perform clamping on every value in an image to avoid overflow and underflow while
   * saving, and to display such images properly i.e. clamps each pixel.
   * @param val array of pixel values of image
   * @return image with clamped values
   */
  public int[] clamping(int[] val) {
    if (val == null || val.length == 0) {
      throw new IllegalArgumentException("Null value");
    }
    int[] result = new int[val.length];
    for (int i = 0; i < val.length; i++) {
      result[i] = clampRange(val[i]);
    }
    return result;
  }

  /**
   * Subtract operation between two image pixels.
   *
   * @param color1 first value
   * @param color2 second value
   * @return result of operation
   */
  public int[] sub(int[] color1, int[] color2) {
    if (color1 == null || color2 == null || color1.length == 0 || color2.length == 0) {
      throw new IllegalArgumentException("Null arguments");
    }
    int[] result = new int[color1.length];
    for (int i = 0; i < color1.length; i++) {
      result[i] = color1[i] - color2[i];
    }
    return result;
  }

  /**
   * Add operation between two image pixels.
   *
   * @param color1 first value
   * @param color2 second value
   * @return result of operation
   */
  public int[] add(int[] color1, int[] color2) {
    if (color1 == null || color2 == null || color1.length == 0 || color2.length == 0) {
      throw new IllegalArgumentException("Null arguments");
    }
    int[] result = new int[color1.length];
    for (int i = 0; i < color1.length; i++) {
      result[i] = color1[i] + color2[i];
    }
    return result;
  }

  /**
   * Performs multiplication of value to image pixel.
   *
   * @param color pixel value
   * @param d the multiplying value
   * @return multiplied pixel value
   */
  public int[] mul(int[] color, double d) {
    if (color == null || d == 0 || color.length == 0) {
      throw new IllegalArgumentException("Null/invalid arguments");
    }
    int[] result = new int[color.length];
    for (int i = 0; i < color.length; i++) {
      result[i] = (int) (color[i] * d);
    }
    return result;
  }

  /**
   * Calculates Redmean distance between 2 pixels.
   *
   * @param pixel1 the first pixel value
   * @param pixel2 the second pixel value
   * @return the computed redmean distance
   */
  public double getRedmeanDistance(int[] pixel1, int[] pixel2) {
    if (pixel1 == null || pixel2 == null || pixel1.length == 0 || pixel2.length == 0) {
      throw new IllegalArgumentException("Null arguments");
    }
    int r1 = pixel1[0];
    int r2 = pixel2[0];
    int g1 = pixel1[1];
    int g2 = pixel2[1];
    int b1 = pixel1[2];
    int b2 = pixel2[2];

    int deltaR = Math.abs(r1 - r2);
    int delatG = Math.abs(g1 - g2);
    int delatB = Math.abs(b1 - b2);

    int sig_r = (r1 + r2) / 2;
    return Math.sqrt(
        (2 + (double) sig_r / 256) * Math.pow(deltaR, 2)
            + 4 * Math.pow(delatG, 2)
            + (2 + (double) (255 - sig_r) / 256) * Math.pow(delatB, 2));
  }
}
