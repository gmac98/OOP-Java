package controller;

import java.io.IOException;

/**
 * The controller interface for the program. The functions here have been
 * designed to give control to the controller, and the primary operation for the
 * controller is perform commands passed to it, like load an image, process the
 * image, and save the image.
 */
public interface ControllerI {

  /**
   * Method that starts the run of the image processing.
   *
   * @throws IOException if an I/O error occurs
   */
  void start() throws IOException;
}
