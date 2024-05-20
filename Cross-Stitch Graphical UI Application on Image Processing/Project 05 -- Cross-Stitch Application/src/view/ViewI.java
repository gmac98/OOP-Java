package view;

/**
 * View interface that provides GUI view to the user to load an image, perform various image filters
 * on the image, generate cross-stitch pattern, and save the image.
 */
public interface ViewI {

  /**
   * Performs user requested action in the view like load image, blur image, etc.
   * @param action user requested action
   */
  void performAction(String action);

  /**
   * Load the image requested by the user.
   */
  void loadImage();

  /**
   * Adds button to GUI for user to perform various filters and image processing on images.
   */
  void toggleImageButtons();

  /**
   * Save the processed image with filename given by user.
   */
  void saveOutputImage();
}
