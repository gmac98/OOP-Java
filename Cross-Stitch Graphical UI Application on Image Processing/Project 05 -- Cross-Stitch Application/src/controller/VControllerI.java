package controller;

/**
 * View Controller interface for the program. The view controller takes user input from the view,
 * instructs the model to execute the required functionality, and then commands the view to display
 * the processed output to the view screen.
 */
public interface VControllerI {
  /**
   * Perform the designated action received from the View and command the model to process the
   * required functionality. View Controller will then instruct the view to display the
   * processed output to its screen.
   * @param action the action to be performed on the image
   * @param params parameters for processing, if any
   */
  void performAction(String action, String[] params);

  /**
   * Save the processed image to file.
   * @param output filename to save processed image.
   */
  void save(String output);
}
