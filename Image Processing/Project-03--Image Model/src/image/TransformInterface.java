package image;

/**
 * Color transformation modifies the color of a pixel based on its own color.
 * A color transformation results in the new color of this pixel to be (r',g',b')
 * such that each of them are dependent only on the values LaTeX: (r,g,b).
 */
public interface TransformInterface {

  /**
   * Generates a grey scale image which is composed only of shades of grey
   * (if the red, green and blue values are the same, it is a shade of grey).
   * @param sourceFile the original image
   * @param filename save the greyscale image with the file name
   */
  void greyscale(String sourceFile, String filename);

  /**
   * Generates a sepia toned image which has a characteristic reddish brown tone.
   * @param sourceFile the original image
   * @param filename save the sepia toned image with the file name
   */
  void sepiaTone(String sourceFile, String filename);
}
