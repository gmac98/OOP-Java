package image;

import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * Reducing Color implements the technique for preserving the essence
 * of the image by breaks down an image that has many colors into an
 * image that is made from just a few colors.
 */
public class ReducingColor extends ImageProcessing implements ReducingColorInterface {

  private int[] findClosestPaletteColor(int[] c) {
    int[] closet = new int[c.length];
    for (int i = 0; i < c.length; i++) {
      closet[i] = Math.round(c[i] / 3);
    }
    return closet;
  }

  private int[] sub(int[] oldColor, int[] newColor) {
    int[] result = new int[oldColor.length];
    for (int i = 0; i < oldColor.length; i++) {
      result[i] = oldColor[i] - newColor[i];
    }
    return result;
  }

  private int[] add(int[] oldColor, int[] newColor) {
    int[] result = new int[oldColor.length];
    for (int i = 0; i < oldColor.length; i++) {
      result[i] = oldColor[i] + newColor[i];
    }
    return result;
  }

  private int[] mul(int[] oldColor, double d) {
    int[] result = new int[oldColor.length];
    for (int i = 0; i < oldColor.length; i++) {
      result[i] = (int) (oldColor[i] * d);
    }
    return result;
  }

  @Override
  public void floydSteinbergDithering(String sourceFile, String filename) {
    try {
      int[][][] pixels = ImageUtilities.readImage(sourceFile);

      int height = pixels.length;
      int width = pixels[0].length;
      int channel_len = pixels[0][0].length;

      int[][][] result = new int[height][width][channel_len];

      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          for (int k = 0; k < channel_len; k++) {
            result[i][j][k] = getPixel(pixels, i, j, k);
          }
        }
      }
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          int[] oldColor = result[i][j];
          int[] newColor = findClosestPaletteColor(oldColor);

          int[] err = sub(oldColor, newColor);

          if (j + 1 < width) {
            int[] tt = add(result[i][j + 1], mul(err, 7. / 16));
            result[i][j + 1] = add(result[i][j + 1], mul(err, 7. / 16));
          }

          if (j - 1 >= 0 && i + 1 < height) {
            int[] tt = add(result[i + 1][j - 1], mul(err, 3. / 16));
            result[i + 1][j - 1] = add(result[i + 1][j - 1], mul(err, 3. / 16));
          }

          if (i + 1 < height) {
            int[] tt = add(result[i + 1][j], mul(err, 5. / 16));
            result[i + 1][j] = add(result[i + 1][j], mul(err, 5. / 16));
          }

          if (j + 1 < width && i + 1 < height) {
            int[] tt = add(result[i + 1][j + 1], mul(err, 1. / 16));
            result[i + 1][j + 1] = add(result[i + 1][j + 1], mul(err, 1. / 16));
          }

          result[i][j] = clamping(result[i][j]);
        }
      }
      ImageUtilities.writeImage(result, width, height, filename);
      System.out.println("Color density reduction is done ! Please check " + filename);

    } catch (IOException e) {
      throw new ImagingOpException(e.toString());
    }
  }
}
