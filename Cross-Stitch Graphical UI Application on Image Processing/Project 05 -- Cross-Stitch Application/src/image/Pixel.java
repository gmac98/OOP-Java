package image;

/**
 * Represents the super pixel values in image that are used for image processing effects
 * on the original image.
 */
public class Pixel {

  private int r;
  private int g;
  private int b;
  private int x_pos;
  private int y_pos;

  /**
   * Initializes the RGB and x,y co-ordinate pixel values for super pixels in the image.
   * @param r value for red
   * @param g value for green
   * @param b value for blue
   * @param xPos x co-ordinate
   * @param yPos y co-ordinate
   */
  public Pixel(int r, int g, int b, int xPos, int yPos) {
    this.r = r;
    this.g = g;
    this.b = b;
    this.x_pos = xPos;
    this.y_pos = yPos;
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

  /**
   * Computes the euclidean distance between given pixel and super pixel for the cluster.
   * @param x x co-ordinate value
   * @param y y co-ordinate value
   * @return computed distance value
   */
  public double distance(int x, int y) {
    return Math.sqrt((x_pos - x) * (x_pos - x) + (y_pos - y) * (y_pos - y));
  }
}
