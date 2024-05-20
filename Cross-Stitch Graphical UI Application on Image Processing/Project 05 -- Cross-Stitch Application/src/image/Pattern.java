package image;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Generate cross-stitch patterns for an image, by pixelating the image and then mapping each
 * super-pixel in the image to a floss color by calculating the "closest" color of available floss.
 */
public class Pattern extends ImageControl {

  private List<int[]> floss_list;
  private List<String> symbol_list;
  private List<String> name_list;
  private int[][][] pattern_pixels;

  /** Constructor for Pattern to initialize DMC floss values. */
  public Pattern() {
    floss_list = new ArrayList<>();
    symbol_list = new ArrayList<>();
    name_list = new ArrayList<>();
    initFloss();
  }

  private void initFloss() {
    try {
      BufferedReader reader =
          new BufferedReader(
              new InputStreamReader(new FileInputStream("floss.csv"), StandardCharsets.UTF_8));
      reader.readLine();
      String line = null;
      while ((line = reader.readLine()) != null) {
        String[] splits = line.split(",");
        if (splits != null && splits.length == 6) {
          name_list.add(splits[1].trim());
          int[] colors = new int[3];
          colors[0] = getNum(splits[2].trim());
          colors[1] = getNum(splits[3].trim());
          colors[2] = getNum(splits[4].trim());
          floss_list.add(colors);
          symbol_list.add(splits[5].trim());
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Generates Cross-Stitch pattern as text file.
   *
   * @param image the image to perform pattern generation
   * @param square number of squares to generate pattern
   */
  public void pattern(int[][][] image, int square, String saveName) {
    if (image == null || saveName == null || square == 0 || image.length == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    try {
      Pixelation pixelation = new Pixelation();
      pattern_pixels = pixelation.pixelate(image, square);

      FileWriter myWriter = new FileWriter(saveName);

      myWriter.write(pattern_pixels[0].length + "x" + pattern_pixels.length);
      myWriter.write(System.lineSeparator());

      List<Integer> used_floss_list = new ArrayList<>();

      for (int i = 0; i < pattern_pixels.length; i++) {
        String line = "";
        for (int j = 0; j < pattern_pixels[0].length; j++) {
          int idx = getPatternSymbolIdx(pattern_pixels[i][j], used_floss_list);
          line += symbol_list.get(idx);
          pattern_pixels[i][j] = floss_list.get(idx);
        }
        myWriter.write(line + System.lineSeparator());
      }
      myWriter.write(System.lineSeparator());
      myWriter.write("LEGEND: " + used_floss_list.size() + System.lineSeparator());
      for (int i = 0; i < used_floss_list.size(); i++) {
        int index = used_floss_list.get(i);
        myWriter.write(
            symbol_list.get(index) + "  " + name_list.get(index) + System.lineSeparator());
        // System.out.println(floss_list.get(index)[0] + " " +floss_list.get(index)[1] +
        // " " +floss_list.get(index)[2] + " - " + name_list.get(index));
      }
      myWriter.close();
      System.out.println("Saved as " + saveName);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private int getPatternSymbolIdx(int[] superPixel, List<Integer> usedFlossList) {
    int index = 0;
    double maximum = Double.MAX_VALUE;

    for (int i = 0; i < floss_list.size(); i++) {
      int[] floss = floss_list.get(i);
      double dist = getRedmeanDistance(superPixel, floss);
      if (dist < maximum) {
        maximum = dist;
        index = i;
      }
    }
    if (!usedFlossList.contains(index)) {
      usedFlossList.add(index);
    }

    return index;
  }

  private int getNum(String str) {
    return Integer.parseInt(str);
  }

  /**
   * Generates Cross-Stitch pattern as text file.
   *
   * @param image the image to perform pattern generation
   * @param square number of squares to generate pattern
   * @param pixelate the pattern pixels to be contained in the image
   */
  public int[][][] stitchPattern(int[][][] image, int square, int[][][] pixelate) {
    if (image == null || pixelate == null || square == 0
            || image.length == 0 || pixelate.length == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    int height = image.length;
    int width = image[0].length;
    int channel_len = image[0][0].length;
    int[][][] result = new int[height][width][channel_len];

    int step = width / square;

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
  }

  public int[][][] getPatternPixels() {
    return pattern_pixels;
  }
}
