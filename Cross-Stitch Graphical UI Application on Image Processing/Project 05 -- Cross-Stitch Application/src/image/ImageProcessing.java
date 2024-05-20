package image;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

/**
 * Model class that implements all functionalities supported by the model like blur, sharpen,
 * greyscale, sepia tone, dither, mosaic, pixelation and cross-stitch pattern generation.
 */
public class ImageProcessing implements Image {

  private int[][][] image;
  private int[][][] result;

  /** Constructor that initializes the model class. */
  public ImageProcessing() {
    // initializes the model class to be passed as parameter to constructor
  }

  @Override
  public void load(String filename) {
    if (filename == null) {
      throw new IllegalArgumentException("Null filename");
    }
    try {
      image = ImageUtilities.readImage(filename);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int[][][] getImage() {
    return image;
  }

  public int[][][] getResult() {
    return result;
  }

  @Override
  public void save(String output) {
    if (output == null) {
      throw new IllegalArgumentException("Null filename");
    }
    try {
      ImageUtilities.writeImage(result, result[0].length, result.length, output);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void blur() {
    Filter ct = new Filter();
    result = ct.blur(image);
  }

  @Override
  public void sharpening() {
    Filter ct = new Filter();
    result = ct.sharpening(image);
  }

  @Override
  public void greyscale() {
    Transformations ct = new Transformations();
    result = ct.greyscale(image);
  }

  @Override
  public void sepiaTone() {
    Transformations ct = new Transformations();
    result = ct.speciaTone(image);
  }

  @Override
  public void floydSteinbergDithering(int maxColor) {
    if (maxColor == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    ReducingColor ct = new ReducingColor();
    result = ct.floydSteinbergDithering(image, maxColor);
  }

  @Override
  public void mosaic(int seeds) {
    if (seeds == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    Mosaic ct = new Mosaic();
    result = ct.mosaic(image, seeds);
  }

  @Override
  public void pixelation(int square) {
    if (square == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    Pixelation ct = new Pixelation();
    result = ct.pixelation(image, square);
  }

  @Override
  public void pattern(int square, String saveName) {
    int[][][] pattern_pixels;
    if (square == 0 || saveName == null) {
      throw new IllegalArgumentException("Invalid value");
    }
    Pattern pattern = new Pattern();
    pattern.pattern(image, square, saveName);
    pattern_pixels = pattern.getPatternPixels();
    result = pattern.stitchPattern(image, square, pattern_pixels);
  }

  @Override
  public void replaceColor(Color initialcolor, Color color) {
    int[] intial_pixel = {initialcolor.getRed(), initialcolor.getGreen(), initialcolor.getBlue()};
    int[] replace_pixel = {color.getRed(), color.getGreen(), color.getBlue()};
    int height = result.length;
    int width = result[0].length;
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        if (Arrays.equals(result[i][j], intial_pixel)) {
          result[i][j] = replace_pixel;
        }
      }
    }
  }
}
