package image;

import java.awt.Color;
import java.io.IOException;
import java.util.Arrays;

/**
 * Mock model for testing functionality between controller and model.
 */
public class MockModel implements Image {

  private int[][][] image;
  private int[][][] result;
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
      image = ImageUtilities.readImage(filename);
      log.append("load\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public int[][][] getImage() {
    return image;
  }

  @Override
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
      log.append("save\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void blur() {
    try {
      Filter ct = new Filter();
      result = ct.blur(image);
      log.append("blur\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void sharpening() {
    try {
      Filter ct = new Filter();
      result = ct.sharpening(image);
      log.append("sharpening\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void greyscale() {
    try {
      Transformations ct = new Transformations();
      result = ct.greyscale(image);
      log.append("greyscale\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void sepiaTone() {
    try {
      Transformations ct = new Transformations();
      result = ct.speciaTone(image);
      log.append("sepia_tone\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void floydSteinbergDithering(int maxColor) {
    try {
      ReducingColor ct = new ReducingColor();
      result = ct.floydSteinbergDithering(image, maxColor);
      log.append("dithering\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void mosaic(int seeds) {
    try {
      Mosaic ct = new Mosaic();
      result = ct.mosaic(image, seeds);
      log.append("mosaic\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void pixelation(int square) {
    try {
      Pixelation ct = new Pixelation();
      result = ct.pixelation(image, square);
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
      Pattern pattern = new Pattern();
      pattern.pattern(image, square, saveName);
      log.append("pattern\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

	@Override
	public void replaceColor(Color initialcolor, Color color) {
		int[] intial_pixel = {initialcolor.getRed(),initialcolor.getGreen(),initialcolor.getBlue()};
		int[] replace_pixel = {color.getRed(),color.getGreen(),color.getBlue()};
		int height = result.length;
		int width = result[0].length;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if(Arrays.equals(result[i][j],intial_pixel)) {
					result[i][j] = replace_pixel;
				}
			}
		}
		
	}
}
