package image;

import java.awt.Color;

/**
 * Model of the program that implements functionalities offered by the program
 * when prompted by the controller.
 */
public interface Image {

	/**
	 * Loads the image to implement functionality on it.
	 *
	 * @param source the filename to load image
	 */
	void load(String source);

	/**
	 * Saves image to file.
	 *
	 * @param out the filename to save image
	 */
	void save(String out);

	/**
	 * Retrieves loaded image RGB pixel values.
	 *
	 * @return the RGB values for image as 3D matrix
	 */
	int[][][] getImage();

	/**
	 * Retrieve image processing result.
	 *
	 * @return the 3D matrix rgb values of image after processing
	 */
	int[][][] getResult();

	/**
	 * Generate a blur copy of the given image by applying an appropriate kernel on
	 * it.
	 */
	void blur();

	/**
	 * Generate a sharpened copy of the given image by applying an appropriate
	 * kernel on it.
	 */
	void sharpening();

	/**
	 * Generates a grey scale image which is composed only of shades of grey (if the
	 * red, green and blue values are the same, it is a shade of grey).
	 */
	void greyscale();

	/**
	 * Generates a sepia toned image which has a characteristic reddish brown tone.
	 */
	void sepiaTone();

	/**
	 * Generate a low color density copy of the given image by applying Floyd
	 * Steinberg dithering technique on it.
	 *
	 * @param maxColor maximum colors in dithered image
	 */
	void floydSteinbergDithering(int maxColor);

	/**
	 * Generates an image with mosaic effect.
	 *
	 * @param seeds the number of seed value for mosaic
	 */
	void mosaic(int seeds);

	/**
	 * Generates a pixelated image processing on the original image.
	 *
	 * @param square the number of square values for pixelation
	 */
	void pixelation(int square);

	/**
	 * Generates a Cross-Stitch pattern on the given image.
	 *
	 * @param square   the number of square values for cross-stitch
	 * @param saveName file name to write the pattern
	 */
	void pattern(int square, String saveName);

	void replaceColor(Color initialcolor, Color color);

}
