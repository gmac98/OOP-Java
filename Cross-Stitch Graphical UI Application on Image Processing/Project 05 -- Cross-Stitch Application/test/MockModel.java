import java.awt.Color;
import java.io.IOException;

import image.Image;

/** Mock model for testing functionality between controller and model. */
public class MockModel implements Image {
  private Appendable log;

  /**
   * Constructor to initialize the MockModel for testing.
   *
   * @param log stores log of processing
   */
  public MockModel(Appendable log) {
    this.log = log;
  }

  @Override
  public void load(String filename) {
    if (filename == null) {
      throw new IllegalArgumentException("Null filename");
    }
    try {
      log.append("load\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int[][][] getImage() {
    return new int[0][][];
  }

  @Override
  public int[][][] getResult() {
    return new int[0][][];
  }

  @Override
  public void save(String output) {
    if (output == null) {
      throw new IllegalArgumentException("Null filename");
    }
    try {
      log.append("save\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void blur() {
    try {
      log.append("blur\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void sharpening() {
    try {
      log.append("sharpening\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void greyscale() {
    try {
      log.append("greyscale\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void sepiaTone() {
    try {
      log.append("sepia_tone\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void floydSteinbergDithering(int maxColor) {
    try {
      log.append("dithering\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void mosaic(int seeds) {
    try {
      log.append("mosaic\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void pixelation(int square) {
    try {
      log.append("pixelation\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void pattern(int square, String saveName) {
    if (saveName == null) {
      throw new IllegalArgumentException("Null filename");
    }
    try {
      log.append("pattern\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void replaceColor(Color initialcolor, Color color) {
    if (initialcolor == null || color == null) {
      throw new IllegalArgumentException("Null arguments");
    }
    try {
      log.append("replaceColor\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
