package controller;

import image.Image;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * Controller of the program that takes in an image and commands, and tells the model
 * what functionality is required. After the image processing, in absence of view here
 * it shows command processed message to client and saves the image in folder.
 */
public class Controller implements ControllerI {

  private Image image;
  private Readable reader;
  private Appendable out;

  /**
   * Constructor to initialize the image and commands to be processed by console controller.
   * @param image the image for processing and transformation
   * @param reader the input stream
   * @param out the output stream
   */
  public Controller(Image image, Readable reader, Appendable out) {
    if (image == null || reader == null || out == null) {
      throw new IllegalArgumentException("Null arguments passed");
    }
    this.image = image;
    this.reader = reader;
    this.out = out;
  }

  @Override
  public void start() {
    try {
      BufferedReader file_reader = (BufferedReader) reader;
      String line;
      while ((line = file_reader.readLine()) != null) {
        String command = line.trim();
        if (command.isEmpty()) {
          continue;
        }
        if (command.startsWith("load")) {
          loadImage(command);
        } else if (command.startsWith("save")) {
          saveImage(command);
        } else {
          processImage(command);
        }
      }
      file_reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Loads the image for processing.
   *
   * @param command the given command
   */
  private void loadImage(String command) {
    String[] commands = command.split("\\s+");
    if (commands == null || commands.length < 2) {
      throw new IllegalArgumentException("Null or invalid command");
    }
    String image_file = commands[1].trim();
    // check image file is exist
    File file = new File(image_file);
    if (!file.exists()) {
      return;
    }
    image.load(image_file);
  }

  /**
   * Saves the image after processing.
   *
   * @param command the given command
   */
  private void saveImage(String command) {
    String[] commands = command.split("\\s+");
    if (commands == null || commands.length < 2) {
      throw new IllegalArgumentException("Null or invalid command");
    }
    String out_file = commands[1].trim();
    image.save(out_file);
    out("Success to save to " + out_file + "\n");
  }

  /**
   * Processes the image to generate required image transformation effects.
   *
   * @param command the given command
   */
  private void processImage(String command) {
    String[] commands = command.split("\\s+");
    if (commands == null) {
      throw new IllegalArgumentException("Null or invalid command");
    }
    String name = commands[0];
    switch (name) {
      case "blur":
        image.blur();
        out("Image blurred.\n");
        break;
      case "sharpening":
        image.sharpening();
        out("Image sharpened.\n");
        break;
      case "greyscale":
        image.greyscale();
        out("Image greyscaled.\n");
        break;
      case "sepia_tone":
        image.sepiaTone();
        out("Image sepia toned.\n");
        break;
      case "dither":
        image.floydSteinbergDithering(getNumber(commands[1]));
        out("Image dithered.\n");
        break;
      case "mosaic":
        image.mosaic(getNumber(commands[1]));
        out("Image mosaic generated.\n");
        break;
      case "pixelate":
        image.pixelation(getNumber(commands[1]));
        out("Image pixeled.\n");
        break;
      case "pattern":
        image.pattern(getNumber(commands[1]), commands[2]);
        out("Image pattern generated.\n");
        break;
      default:
        out("Invalid command.\n");
        break;
    }
  }

  private int getNumber(String str) {
    return Integer.parseInt(str);
  }

  private void out(String content) {
    try {
      out.append(content);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
