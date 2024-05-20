package image;

/**
 * Reducing color density means to reduce the number of colors in the image.
 * If we have a limited number of colors at disposal then we reduce the
 * color density to store the image effectively.
 */
public interface ReducingColorInterface {

  /**
   * Generate a low color density copy of the given image by
   * applying an Floyd Steinberg dithering technique on it.
   * @param sourceFile the original image
   * @param filename save the low color density image with the file name
   */
  void floydSteinbergDithering(String sourceFile, String filename);
}
