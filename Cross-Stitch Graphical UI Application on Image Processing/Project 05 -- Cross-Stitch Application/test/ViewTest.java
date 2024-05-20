import org.junit.Before;
import org.junit.Test;

import java.awt.EventQueue;

import view.View;

import static org.junit.Assert.assertEquals;

/** A JUnit test class for testing View Controller and GUI View interaction. */
public class ViewTest {
  private Appendable log;
  private MockView mv1;
  private Appendable expected_log;

  /** Testing all functionality between view controller and GUI view. */
  @Before
  public void setUp() {
    log = new StringBuilder();
    mv1 = new MockView(log);
    expected_log = new StringBuilder();
    mv1.loadImage();
    EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            try {
              View window = new View();
            } catch (Exception e) {
              e.printStackTrace();
            }
          }
        });
  }

  @Test
  public void LoadTest() throws Exception {
    expected_log.append("load image \n" + "buttons active \n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void blurTest() throws Exception {
    mv1.performAction("blur");
    expected_log.append("load image \n" + "buttons active \n" + "Image blurred.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void sharpenTest() throws Exception {
    mv1.performAction("sharpening");
    expected_log.append("load image \n" + "buttons active \n" + "Image sharpened.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void greyscaleTest() throws Exception {
    mv1.performAction("greyscale");
    expected_log.append("load image \n" + "buttons active \n" + "Image greyscaled.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void sepiaToneTest() throws Exception {
    mv1.performAction("sepia_tone");
    expected_log.append("load image \n" + "buttons active \n" + "Image sepia toned.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void ditherTest() throws Exception {
    mv1.performAction("dither");
    expected_log.append("load image \n" + "buttons active \n" + "Image dithered.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void mosaicTest() throws Exception {
    mv1.performAction("mosaic");
    expected_log.append("load image \n" + "buttons active \n" + "Image mosaic generated.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void pixelateTest() throws Exception {
    mv1.performAction("pixelate");
    expected_log.append("load image \n" + "buttons active \n" + "Image pixeled.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void patternTest() throws Exception {
    mv1.performAction("pattern");
    expected_log.append("load image \n" + "buttons active \n" + "Image pattern generated.\n");
    assertEquals(expected_log.toString(), log.toString());
  }

  @Test
  public void saveTest() throws Exception {
    mv1.performAction("blur");
    mv1.saveOutputImage();
    expected_log.append(
        "load image \n" + "buttons active \n" + "Image blurred.\n" + "Image saved to file");
    assertEquals(expected_log.toString(), log.toString());
  }
}
