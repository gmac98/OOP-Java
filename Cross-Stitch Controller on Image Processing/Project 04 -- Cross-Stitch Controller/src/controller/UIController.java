package controller;

import java.io.IOException;

import image.Image;
import image.ImageProcessing;
import image.ImageUtilities;

public class UIController {
	String inputFile;
	int height;
	int width;
	Image processing;
	private Appendable out;

	public UIController(String filename, Appendable out) {
		this.out = out;
		processing = new ImageProcessing();
		try {
			processing.load(filename);
			height = ImageUtilities.getHeight(filename);
			width = ImageUtilities.getWidth(filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public Image getProcessing() {
		return processing;
	}

	public void perfromAction(String action, String[] params) {
		switch (action) {
		case "blur":
			getProcessing().blur();
			out("Image blurred.\n");
			break;
		case "sharpening":
			getProcessing().sharpening();
			out("Image sharpened.\n");
			break;
		case "greyscale":
			getProcessing().greyscale();
			out("Image greyscaled.\n");
			break;
		case "sepia_tone":
			getProcessing().sepiaTone();
			out("Image sepia toned.\n");
			break;
		case "dither":
			getProcessing().floydSteinbergDithering(getNumber(params[0]));
			out("Image dithered.\n");
			break;
		case "mosaic":
			getProcessing().mosaic(getNumber(params[0]));
			out("Image mosaic generated.\n");
			break;
		case "pixelate":
			getProcessing().pixelation(getNumber(params[0]));
			out("Image pixeled.\n");
			break;
		case "pattern":
			getProcessing().pattern(getNumber(params[0]), params[1]);
			out("Image pattern generated.\n");
			break;
		}

	}

	private int getNumber(String string) {
		return Integer.parseInt(string);
	}

	private void out(String content) {
		try {
			out.append(content);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void save(String output) {
		getProcessing().save(output);
	}

}
