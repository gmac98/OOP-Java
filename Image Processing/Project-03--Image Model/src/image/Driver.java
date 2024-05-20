package image;

/**
 * Driver class runs the model of the Image project to generate various
 * filtering, transformations and color density reduction on image.
 */
public class Driver {

  /**
   * Main method calls the various methods in the sub classes to read
   * original image and save transformed images to file.
   * @param args the input arguments for main method
   */
  public static void main(String[] args) {
    Filter filter = new Filter();
    filter.blur("sample1.jpeg", "blur.jpg");
    filter.blur("blur.jpg", "blur.jpg");
    filter.sharpening("sample1.jpeg", "sharpening.jpg");

    Transformations transformation = new Transformations();
    transformation.greyscale("sample1.jpeg", "greyscale.jpg");
    transformation.sepiaTone("sample1.jpeg", "sepia_tone.jpg");

    ReducingColor reducing_color = new ReducingColor();
    reducing_color.floydSteinbergDithering("sample1.jpeg", "floydSteinbergDithering.jpg");
  }
}
