package image;

import java.awt.image.ImagingOpException;
import java.io.IOException;

/**
 * A simple color transformation is a linear color transformation. A linear color transformation is
 * simply a color transformation in which the final red, green and blue values of a pixel are linear
 * combinations of its initial red, green and blue values. Transform the image with the appropriate
 * matrix to achieve the desired transformed image from original image. Then save the modified image
 * * with the file name.
 */
public class Transformations extends ImageProcessing implements TransformInterface {

  @Override
  public void greyscale(String sourceFile, String filename) {
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
                (int)
                    (getPixel(pixels, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.2126
                        + getPixel(pixels, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.7152
                        + getPixel(pixels, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.0722);
            result[i][j][k] = clampRange(result[i][j][k]);
          }
        }
      }
      ImageUtilities.writeImage(result, width, height, filename);
      System.out.println("Greyscale is done ! Please check " + filename);
    } catch (IOException e) {
      throw new ImagingOpException(e.toString());
    }
  }

  @Override
  public void sepiaTone(String sourceFile, String filename) {
    try {
      int[][][] pixels = ImageUtilities.readImage(sourceFile);

      int height = pixels.length;
      int width = pixels[0].length;
      int channel_len = pixels[0][0].length;
      int[][][] result = new int[height][width][channel_len];
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          result[i][j][ImageUtilities.Channel.RED.ordinal()] =
              (int)
                  ((getPixel(pixels, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.393
                      + getPixel(pixels, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.769
                      + getPixel(pixels, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.189));
          result[i][j][ImageUtilities.Channel.GREEN.ordinal()] =
              (int)
                  ((getPixel(pixels, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.349
                      + getPixel(pixels, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.686
                      + getPixel(pixels, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.168));
          result[i][j][ImageUtilities.Channel.BLUE.ordinal()] =
              (int)
                  ((getPixel(pixels, i, j, ImageUtilities.Channel.RED.ordinal()) * 0.272
                      + getPixel(pixels, i, j, ImageUtilities.Channel.GREEN.ordinal()) * 0.534
                      + getPixel(pixels, i, j, ImageUtilities.Channel.BLUE.ordinal()) * 0.131));

          result[i][j] = clamping(result[i][j]);
        }
      }
      ImageUtilities.writeImage(result, width, height, filename);
      System.out.println("Sepia tone is done ! Please check " + filename);
    } catch (IOException e) {
      throw new ImagingOpException(e.toString());
    }
  }
}
