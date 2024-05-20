package controller;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import image.MockModel;

import static org.junit.Assert.assertEquals;

/** A JUnit test class for the Controller. */
public class ControlTester {

  /** Testing all functionality between controller and model. */
  @Test
  public void Test() throws Exception {

    File batch = new File("batch.txt");
    // readable for batch file parser
    Readable reader =
        new BufferedReader(
            new InputStreamReader(new FileInputStream(batch), StandardCharsets.UTF_8));

    Appendable log = new StringBuilder();
    Appendable out = System.out;
    // transfer log to mock model
    MockModel model = new MockModel(log);

    // start controller
    Controller control = new Controller(model, reader, out);
    control.start();

    // expected log
    Appendable expected_log = new StringBuilder();
    expected_log.append("load\n");
    expected_log.append("blur\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("sharpening\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("greyscale\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("sepia_tone\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("dithering\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("mosaic\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("pixelation\n");
    expected_log.append("save\n");

    expected_log.append("load\n");
    expected_log.append("pattern\n");

    /// check that expected log is same as controller log
    assertEquals(log.toString(), expected_log.toString());
  }
}
