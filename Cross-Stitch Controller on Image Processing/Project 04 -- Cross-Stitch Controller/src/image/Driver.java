package image;

import controller.Controller;
import ui.View;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * Driver class to run the controller.
 */
public class Driver {

	/**
	 * Starting point of the program that takes command line arguments for
	 * processing commands.
	 * 
	 * @param args the given arguments
	 * @throws IOException to check correct arguments are passed
	 */
	public static void main(String[] args) throws IOException {
		// java -jar Program.jar -script path-of-script-file
		// java -jar Program.jar -interactive
		System.out.println(args[0]);
		if (args[0].equalsIgnoreCase("interactive")) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						View window = new View();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} else {
			if (args.length == 0) {
				throw new IOException("Null arguments");
			}
			File batch = new File(args[0]);
			if (!batch.exists()) {
				throw new IOException("Input file does not exist");
			}
			Readable reader = new BufferedReader(
					new InputStreamReader(new FileInputStream(batch), StandardCharsets.UTF_8));
			Appendable out = System.out;

			Image image = new ImageProcessing();
			Controller controller = new Controller(image, reader, out);
			controller.start();
		}
	}
}
