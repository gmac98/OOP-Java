package image;

import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Filter the image with the appropriate kernel to achieve the desired
 * filtered image from original image. Then save the modified image
 * with the file name.
 */
public class Filter extends ImageProcessing implements FilterInterface {

  @Override
  public void blur(String sourceFile, String filename) {
    try {
      int[][][] pixels = ImageUtilities.readImage(sourceFile);

      int height = pixels.length;
      int width = pixels[0].length;
      int channel_len = pixels[0][0].length;
      int[][][] result = new int[height][width][channel_len];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          for (int k = 0; k < channel_len; k++) {
            result[i][j][k] =
                (getPixel(pixels, i - 1, j - 1, k) >> 4)
                    + (getPixel(pixels, i - 1, j, k) >> 3)
                    + (getPixel(pixels, i - 1, j + 1, k) >> 4)
                    + (getPixel(pixels, i, j - 1, k) >> 3)
                    + (getPixel(pixels, i, j, k) >> 2)
                    + (getPixel(pixels, i, j + 1, k) >> 3)
                    + (getPixel(pixels, i + 1, j - 1, k) >> 4)
                    + (getPixel(pixels, i + 1, j, k) >> 3)
                    + (getPixel(pixels, i + 1, j + 1, k) >> 4);
            result[i][j][k] = clampRange(result[i][j][k]);
          }
        }
      }
      ImageUtilities.writeImage(result, width, height, filename);
      System.out.println("Blur filter is done ! Please check " + filename);
    } catch (IOException e) {
      throw new ImagingOpException(e.toString());
    }
  }

  @Override
  public void sharpening(String sourceFile, String filename) {
    try {
      int[][][] pixels = ImageUtilities.readImage(sourceFile);

      int height = pixels.length;
      int width = pixels[0].length;
      int channel_len = pixels[0][0].length;

      int[][][] result = new int[height][width][channel_len];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          for (int k = 0; k < channel_len; k++) {
            result[i][j][k] =
                -(getPixel(pixels, i - 2, j - 2, k) >> 3)
                    - (getPixel(pixels, i - 2, j - 1, k) >> 3)
                    - (getPixel(pixels, i - 2, j, k) >> 3)
                    - (getPixel(pixels, i - 2, j + 1, k) >> 3)
                    - (getPixel(pixels, i - 2, j + 2, k) >> 3)
                    - (getPixel(pixels, i - 1, j - 2, k) >> 3)
                    + (getPixel(pixels, i - 1, j - 1, k) >> 2)
                    + (getPixel(pixels, i - 1, j, k) >> 2)
                    + (getPixel(pixels, i - 1, j + 1, k) >> 2)
                    - (getPixel(pixels, i - 1, j + 2, k) >> 3)
                    - (getPixel(pixels, i, j - 2, k) >> 3)
                    + (getPixel(pixels, i, j - 1, k) >> 2)
                    + (getPixel(pixels, i, j, k))
                    + (getPixel(pixels, i, j + 1, k) >> 2)
                    - (getPixel(pixels, i, j + 2, k) >> 3)
                    - (getPixel(pixels, i + 1, j - 2, k) >> 3)
                    + (getPixel(pixels, i + 1, j - 1, k) >> 2)
                    + (getPixel(pixels, i + 1, j, k) >> 2)
                    + (getPixel(pixels, i + 1, j + 1, k) >> 2)
                    - (getPixel(pixels, i + 1, j + 2, k) >> 3)
                    - (getPixel(pixels, i + 2, j - 2, k) >> 3)
                    - (getPixel(pixels, i + 2, j - 1, k) >> 3)
                    - (getPixel(pixels, i + 2, j, k) >> 3)
                    - (getPixel(pixels, i + 2, j + 1, k) >> 3)
                    - (getPixel(pixels, i + 2, j + 2, k) >> 3);
            result[i][j][k] = clampRange(result[i][j][k]);
          }
        }
      }
      ImageUtilities.writeImage(result, width, height, filename);
      System.out.println("Sharpening filter is done ! Please check " + filename);
    } catch (IOException e) {
      throw new ImagingOpException(e.toString());
    }
  }
}
