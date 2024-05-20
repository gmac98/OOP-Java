package image;

/**
 * Reducing Color implements the technique for preserving the essence of the image by breaks down an
 * image that has many colors into an image that is made from just a few colors.
 */
public class ReducingColor extends ImageControl {

  private int[] findClosestPaletteColor(int[] c, int maxNumColor) {
    int[] closet = new int[c.length];
    int max = 0;
    for (int i = 0; i < c.length; i++) {
      if (max < c[i]) {
        max = c[i];
      }
    }
    for (int i = 0; i < c.length; i++) {
      closet[i] = Math.round(c[i] / maxNumColor);
    }
    return closet;
  }

  /**
   * Generates a low color density copy of the given image by applying an Floyd Steinberg dithering
   * technique on it.
   *
   * @param image the image to perform dither
   * @return the 3D matrix containing RGB values of the dithered image
   */
  public int[][][] floydSteinbergDithering(int[][][] image, int maxColorNum) {
    if (image == null || maxColorNum == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    try {
      int height = image.length;
      int width = image[0].length;
      int channel_len = image[0][0].length;
      int[][][] result = new int[height][width][channel_len];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          for (int k = 0; k < channel_len; k++) {
            result[i][j][k] = pixel(image, i, j, k);
          }
        }
      }
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int[] oldColor = result[i][j];
          int[] newColor = findClosestPaletteColor(oldColor, maxColorNum);

          int[] err = sub(oldColor, newColor);

          if (j + 1 < width) {
            result[i][j + 1] = add(result[i][j + 1], mul(err, 7. / 16));
          }

          if (j - 1 >= 0 && i + 1 < height) {
            result[i + 1][j - 1] = add(result[i + 1][j - 1], mul(err, 3. / 16));
          }

          if (i + 1 < height) {
            result[i + 1][j] = add(result[i + 1][j], mul(err, 5. / 16));
          }

          if (j + 1 < width && i + 1 < height) {
            result[i + 1][j + 1] = add(result[i + 1][j + 1], mul(err, 1. / 16));
          }

          result[i][j] = clamping(result[i][j]);
        }
      }
      return result;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }
}
