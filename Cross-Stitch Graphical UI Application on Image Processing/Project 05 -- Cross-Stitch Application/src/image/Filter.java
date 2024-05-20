package image;

/**
 * Filter the image with the appropriate kernel to achieve the desired filtered image from original
 * image.
 */
public class Filter extends ImageControl {

  /**
   * Generate a blur copy of the given image by applying an appropriate kernel on it.
   *
   * @param image the image to perform blur
   * @return the 3D matrix containing RGB values of the blurred image
   */
  public int[][][] blur(int[][][] image) {
    if (image == null || image.length == 0) {
      throw new IllegalArgumentException("Invalid image values");
    }
    int height = image.length;
    int width = image[0].length;
    int channel_len = image[0][0].length;
    int[][][] result = new int[height][width][channel_len];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < channel_len; k++) {
          result[i][j][k] =
                  (pixel(image, i - 1, j - 1, k) >> 4)
                          + (pixel(image, i - 1, j, k) >> 3)
                          + (pixel(image, i - 1, j + 1, k) >> 4)
                          + (pixel(image, i, j - 1, k) >> 3)
                          + (pixel(image, i, j, k) >> 2)
                          + (pixel(image, i, j + 1, k) >> 3)
                          + (pixel(image, i + 1, j - 1, k) >> 4)
                          + (pixel(image, i + 1, j, k) >> 3)
                          + (pixel(image, i + 1, j + 1, k) >> 4);
          result[i][j][k] = clampRange(result[i][j][k]);
        }
      }
    }
    return result;
  }

  /**
   * Generate a sharpened copy of the given image by applying an appropriate kernel on it.
   *
   * @param image the image to perform sharpen
   * @return the 3D matrix containing RGB values of the sharpened image
   */
  public int[][][] sharpening(int[][][] image) {
    if (image == null || image.length == 0) {
      throw new IllegalArgumentException("Invalid image values");
    }
    int height = image.length;
    int width = image[0].length;
    int channel_len = image[0][0].length;
    int[][][] result = new int[height][width][channel_len];

    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < channel_len; k++) {
          result[i][j][k] =
                  -(pixel(image, i - 2, j - 2, k) >> 3)
                          - (pixel(image, i - 2, j - 1, k) >> 3)
                          - (pixel(image, i - 2, j, k) >> 3)
                          - (pixel(image, i - 2, j + 1, k) >> 3)
                          - (pixel(image, i - 2, j + 2, k) >> 3)
                          - (pixel(image, i - 1, j - 2, k) >> 3)
                          + (pixel(image, i - 1, j - 1, k) >> 2)
                          + (pixel(image, i - 1, j, k) >> 2)
                          + (pixel(image, i - 1, j + 1, k) >> 2)
                          - (pixel(image, i - 1, j + 2, k) >> 3)
                          - (pixel(image, i, j - 2, k) >> 3)
                          + (pixel(image, i, j - 1, k) >> 2)
                          + (pixel(image, i, j, k))
                          + (pixel(image, i, j + 1, k) >> 2)
                          - (pixel(image, i, j + 2, k) >> 3)
                          - (pixel(image, i + 1, j - 2, k) >> 3)
                          + (pixel(image, i + 1, j - 1, k) >> 2)
                          + (pixel(image, i + 1, j, k) >> 2)
                          + (pixel(image, i + 1, j + 1, k) >> 2)
                          - (pixel(image, i + 1, j + 2, k) >> 3)
                          - (pixel(image, i + 2, j - 2, k) >> 3)
                          - (pixel(image, i + 2, j - 1, k) >> 3)
                          - (pixel(image, i + 2, j, k) >> 3)
                          - (pixel(image, i + 2, j + 1, k) >> 3)
                          - (pixel(image, i + 2, j + 2, k) >> 3);
          result[i][j][k] = clampRange(result[i][j][k]);
        }
      }
    }
    return result;
  }
}
