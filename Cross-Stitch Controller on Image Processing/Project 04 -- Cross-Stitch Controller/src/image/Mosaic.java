package image;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/** Mosaic image to produce desired image processing effects on the original image. */
public class Mosaic extends ImageControl {

  /**
   * Generates image mosaic by chunking the image into irregular seeds across the rows and columns.
   *
   * @param image the image to perform mosaic effect
   * @param seeds number of seeds to mosaic image
   * @return the 3D matrix containing RGB values of the mosaic effect image
   */
  public int[][][] mosaic(int[][][] image, int seeds) {
    if (image == null || seeds == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    try {
      int height = image.length;
      int width = image[0].length;
      int channel_len = image[0][0].length;
      int[][][] result = new int[height][width][channel_len];

      int total_pixels = height * width;
      int min_pixel_num = total_pixels / seeds;
      if (min_pixel_num < 2) {
        return image;
      }
      List<Integer> seed_pos = new ArrayList<>();
      // select random seed
      List<Integer> range =
          IntStream.range(0, total_pixels).boxed().collect(Collectors.toCollection(ArrayList::new));
      for (int i = 0; i < 5; i++) {
        Collections.shuffle(range);
      }
      for (int i = 0; i < seeds; i++) {
        seed_pos.add(range.get(i));
      }
      Collections.sort(seed_pos);
      List<Pixel> seed_list = new ArrayList<>();
      for (int i : seed_pos) {
        int y_pos = i / width;
        int x_pos = i % width;
        int[] pixel = image[y_pos][x_pos];
        seed_list.add(
            new Pixel(
                pixel[ImageUtilities.Channel.RED.ordinal()],
                pixel[ImageUtilities.Channel.GREEN.ordinal()],
                pixel[ImageUtilities.Channel.BLUE.ordinal()],
                x_pos,
                y_pos));
      }
      for (int i = 0; i < height; i++) {
        for (int j = 0; j < width; j++) {
          // get cluster and replace color
          int cluster_index = getClosetPixel(seed_list, j, i);
          result[i][j][ImageUtilities.Channel.RED.ordinal()] = seed_list.get(cluster_index).getR();
          result[i][j][ImageUtilities.Channel.GREEN.ordinal()] =
              seed_list.get(cluster_index).getG();
          result[i][j][ImageUtilities.Channel.BLUE.ordinal()] = seed_list.get(cluster_index).getB();
        }
      }
      return result;
    } catch (NullPointerException e) {
      e.printStackTrace();
      return null;
    }
  }

  private int getClosetPixel(List<Pixel> seedList, int x, int y) {
    double minimum = Double.MAX_VALUE;
    int index = 0;
    for (int i = 0; i < seedList.size(); i++) {
      double dist = seedList.get(i).distance(x, y);
      if (dist == 0) {
        return i;
      }
      if (dist < minimum) {
        minimum = dist;
        index = i;
      }
    }
    return index;
  }
}
