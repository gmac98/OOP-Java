package image;

/**
 * A simple color transformation is a linear color transformation. A linear color transformation is
 * simply a color transformation in which the final red, green and blue values of a pixel are linear
 * combinations of its initial red, green and blue values. Transform the image with the appropriate
 * matrix to achieve the desired transformed image from original image.
 */
public class Transformations extends ImageControl {

  /**
   * Generates a grey scale image which is composed only of shades of grey (if the red, green and
   * blue values are the same, it is a shade of grey).
   *
   * @param image the image to perform grey scaling
   * @return the 3D matrix containing RGB values of the grey scaled image
   */
  public int[][][] greyscale(int[][][] image) {
    if (image == null || image.length == 0) {
      throw new IllegalArgumentException("Invalid image values.");
    }
    int height = image.length;
    int width = image[0].length;
    int channel_len = image[0][0].length;
    int[][][] result = new int[height][width][channel_len];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < channel_len; k++) {
          result[i][j][k] =
              (int)
                  (pixel(image, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.2126
                      + pixel(image, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.7152
                      + pixel(image, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.0722);
          result[i][j][k] = clampRange(result[i][j][k]);
        }
      }
    }
    return result;
  }

  /**
   * Generates a sepia toned image which has a characteristic reddish brown tone.
   *
   * @param image the image to perform sepia toning
   * @return the 3D matrix containing RGB values of the sepia toned image
   */
  public int[][][] speciaTone(int[][][] image) {
    if (image == null || image.length == 0) {
      throw new IllegalArgumentException("Invalid image values.");
    }
    int height = image.length;
    int width = image[0].length;
    int channel_len = image[0][0].length;
    int[][][] result = new int[height][width][channel_len];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        result[i][j][ImageUtilities.Channel.RED.ordinal()] =
            (int)
                ((pixel(image, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.393
                    + pixel(image, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.769
                    + pixel(image, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.189));
        result[i][j][ImageUtilities.Channel.GREEN.ordinal()] =
            (int)
                ((pixel(image, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.349
                    + pixel(image, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.686
                    + pixel(image, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.168));
        result[i][j][ImageUtilities.Channel.BLUE.ordinal()] =
            (int)
                ((pixel(image, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.272
                    + pixel(image, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.534
                    + pixel(image, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.131));

        result[i][j] = clamping(result[i][j]);
      }
    }
    return result;
  }
}
