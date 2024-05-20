package image;

/**
 * Abstract class implementing the Image interface which provides the common functionality of
 * retrieving RGB value for each pixel position in an image, and clamping the values in the
 * modified(filtered or modified) image so as to avoid overflow or underflow while saving.
 */
public abstract class ImageProcessing implements Image {

  @Override
  public int clampRange(int val) {
    return Math.max(0, Math.min(255, val));
  }

  @Override
  public int[] clamping(int[] val) {
    int[] result = new int[val.length];
    for (int i = 0; i < val.length; i++) {
      result[i] = clampRange(val[i]);
    }
    return result;
  }

  @Override
  public int getPixel(int[][][] pixels, int i, int j, int k) {
    if (i < 0
        || i >= pixels.length
        || j < 0
        || j >= pixels[0].length
        || k < 0
        || k >= pixels[0][0].length) {
      return 0;
    }
    return pixels[i][j][k];
  }
}
