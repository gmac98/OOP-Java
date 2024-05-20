package image;

/**
 * Pixelate image to produce desired image processing effects on the original image.
 */
public class Pixelation extends ImageControl {

  /**
   * Generates image pixelation by chunking the image into regular squares
   * across the rows and columns.
   *
   * @param image the image to perform pixelation
   * @param square number of squares to pixel image
   * @return the 3D matrix containing RGB values of the pixeled image
   */
  public int[][][] pixelation(int[][][] image, int square) {
    if (image == null || square == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    try {
      int height = image.length;
      int width = image[0].length;
      int channel_len = image[0][0].length;
      int[][][] result = new int[height][width][channel_len];

      int step = width / square;

      if (step < 2) {
        return result;
      }

      int[][][] pixelate = pixelate(image, square);

      for (int i = 0; i < pixelate.length; i++) {
        for (int j = 0; j < pixelate[0].length; j++) {
          int[] center_pixel = pixelate[i][j];
          for (int k = 0; k < step; k++) {
            int heigh_index = k + i * step;
            if (heigh_index > height - 1) {
              break;
            }
            for (int m = 0; m < step; m++) {
              int width_index = m + j * step;
              if (width_index > width - 1) {
                break;
              }
              result[heigh_index][width_index] = center_pixel;
            }
          }
        }
      }
      return result;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * Generates super pixels that are evenly sized squares across the width of the image.
   *
   * @param image the image to generate super pixels
   * @param square number of squares to pixel image
   * @return the 3D matrix containing super pixeled image
   */
  public int[][][] pixelate(int[][][] image, int square) {
    if (image == null || square == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    try {
      int height = image.length;
      int width = image[0].length;
      int channel_len = image[0][0].length;

      int step = width / square;

      int square_height = height / step;
      int square_width = width / step;

      if (height % step > 0) {
        square_height++;
      }
      if (width % step > 0) {
        square_width++;
      }

      int[][][] pixelate_result = new int[square_height][square_width][channel_len];

      int height_index = 0;
      int width_index = 0;

      for (int i = 0; i < height; i = i + step) {
        int start_y = i;
        int end_y = i + step - 1;
        if (end_y >= height) {
          end_y = height - 1;
        }
        width_index = 0;
        for (int j = 0; j < width; j = j + step) {
          int start_x = j;
          int end_x = j + step - 1;
          if (end_x >= width) {
            end_x = width - 1;
          }
          int[] center_pixel = findCenterPixel(image, start_x, start_y, end_x, end_y);
          pixelate_result[height_index][width_index] = center_pixel;

          width_index++;
        }
        height_index++;
      }
      return pixelate_result;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }

  private int[] findCenterPixel(int[][][] pixels, int startX, int startY, int endX, int endY) {
    int center_x = startX + (endX - startX) / 2;
    int center_y = startY + (endY - startY) / 2;
    return pixels[center_y][center_x];
  }
}
