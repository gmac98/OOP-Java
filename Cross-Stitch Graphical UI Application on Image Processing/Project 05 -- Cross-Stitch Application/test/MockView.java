import controller.ViewController;
import view.ViewI;

import java.io.File;
import java.io.IOException;

/**
 * MockView class to test functionality between ViewController and View. This ensures that the input
 * is correctly passed to the controller and the processed output is correctly passed to view to
 * display to screen.
 */
public class MockView implements ViewI {

  private ViewController controller;
  private Appendable log;

  /**
   * Constructor for the mock view.
   * @param log stores log of processing
   */
  public MockView(Appendable log) {
    this.log = log;
  }

  @Override
  public void performAction(String action) {
    if (action.equals("dither")) {
      String[] params = new String[1];
      int num = 5;
      params[0] = num + "";
      controller.performAction(action, params);
    } else if (action.equals("mosaic")) {
      String[] params = new String[1];
      int num = 570;
      params[0] = num + "";
      controller.performAction(action, params);
    } else if (action.equals("pixelate")) {
      String[] params = new String[1];
      int num = 52;
      params[0] = num + "";
      controller.performAction(action, params);
    } else if (action.equals("blur")) {
      String[] params = null;
      controller.performAction(action, params);
    } else if (action.equals("sharpening")) {
      String[] params = null;
      controller.performAction(action, params);
    } else if (action.equals("greyscale")) {
      String[] params = null;
      controller.performAction(action, params);
    } else if (action.equals("sepia_tone")) {
      String[] params = null;
      controller.performAction(action, params);
    } else if (action.equals("pattern")) {
      String[] params = new String[2];
      int num = 41;
      params[0] = num + "";
      params[1] = "filename";
      controller.performAction(action, params);
    }
  }

  @Override
  public void loadImage() {
    File file = new File("sample2.jpeg");
    try {
      log.append("load image \n");
      controller = new ViewController("sample2.jpeg", log);
      toggleImageButtons();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void toggleImageButtons() {
    try {
      log.append("buttons active \n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void saveOutputImage() {
    controller.save("filename");
  }
}
