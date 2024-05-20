package image;

/**
 * Filtering is a technique for modifying or enhancing an image.
 * You can filter an image to emphasize certain features or remove other features.
 * Here, we have functionality to blur and sharpen an image.
 */
public interface FilterInterface {

  /**
   * Generate a blur copy of the given image by applying an appropriate kernel on it.
   * @param sourceFile the original image
   * @param filename save the blurred image with the file name
   */
  void blur(String sourceFile, String filename);

  /**
   * Generate a sharpened copy of the given image by applying an appropriate kernel on it.
   * @param sourceFile the original image
   * @param filename save the sharpened image with the file name
   */
  void sharpening(String sourceFile, String filename);
}
