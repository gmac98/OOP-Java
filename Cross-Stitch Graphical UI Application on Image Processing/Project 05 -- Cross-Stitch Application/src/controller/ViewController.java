package controller;

import java.io.IOException;

import image.Image;
import image.ImageProcessing;
import image.ImageUtilities;

/**
 * View Controller of the program that takes in an image and commands from buttons and menu options,
 * and tells the model what functionality is required. After the image processing, it shows the
 * processed image to screen, command processed message to client and offers an option to save the
 * processed image to file.
 */
public class ViewController implements VControllerI {
  private int height;
  private int width;
  private Image processing;
  private Appendable out;

  /**
   * Constructor to initialize the image and commands to be processed by view controller.
   *
   * @param filename the image file to load
   * @param out output after processing
   */
  public ViewController(String filename, Appendable out) throws IOException {
    if (filename == null || out == null) {
      throw new IllegalArgumentException("Null arguments passed");
    }
    this.out = out;
    processing = new ImageProcessing();
    processing.load(filename);
    height = ImageUtilities.getHeight(filename);
    width = ImageUtilities.getWidth(filename);
  }

  public Image getProcessing() {
    return processing;
  }

  @Override
  public void performAction(String action, String[] params) {
    if (action == null || action.equals("") || params == null || params.length == 0) {
      throw new IllegalArgumentException("Invalid arguments");
    }
    switch (action) {
      case "blur":
        getProcessing().blur();
        out("Image blurred.\n");
        break;
      case "sharpening":
        getProcessing().sharpening();
        out("Image sharpened.\n");
        break;
      case "greyscale":
        getProcessing().greyscale();
        out("Image greyscaled.\n");
        break;
      case "sepia_tone":
        getProcessing().sepiaTone();
        out("Image sepia toned.\n");
        break;
      case "dither":
        getProcessing().floydSteinbergDithering(getNumber(params[0]));
        out("Image dithered.\n");
        break;
      case "mosaic":
        getProcessing().mosaic(getNumber(params[0]));
        out("Image mosaic generated.\n");
        break;
      case "pixelate":
        getProcessing().pixelation(getNumber(params[0]));
        out("Image pixeled.\n");
        break;
      case "pattern":
        getProcessing().pattern(getNumber(params[0]), params[1]);
        out("Image pattern generated.\n");
        break;
      default:
        out("Please select an operation");
        break;
    }
  }

  private int getNumber(String string) {
    if (string == null || string.length() == 0) {
      throw new IllegalArgumentException("Invalid value");
    }
    return Integer.parseInt(string);
  }

  private void out(String content) {
    try {
      out.append(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  @Override
  public void save(String output) {
    if (output == null || output.length() == 0) {
      throw new IllegalArgumentException("Invalid filename value");
    }
    getProcessing().save(output);
    out("Image saved to file");
  }
}
