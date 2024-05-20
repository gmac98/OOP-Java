package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.SystemColor;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.nio.sctp.MessageInfo;

import controller.Controller;
import controller.UIController;
import image.Image;
import image.ImageProcessing;
import image.ImageUtilities;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View {

	protected JFrame frmImageProcessingAnd;
	private boolean isImageLoaded;
	private JMenuItem saveMenuItem;
	private JMenuItem loadImageMenuItem;
	private JMenu processImageMenu;
	private JMenuItem blurImageMenuItem;
	private JMenuItem sharpenImageMenuItem;
	private JMenuItem greyscaleMenuItem;
	private JMenuItem sepiaMenuItem;
	private JMenuItem ditherMenuItem;
	private JMenuItem mosaicImageMenuItem;
	private JMenuItem pixelateImageMenuItem;
	private JMenuItem imagePatternMenuItem;
	private JMenuItem resetMenuItem;
	private JSplitPane splitPane;
	private JPanel panel_2;
	private JPanel panel;
	private JPanel headerPanel;
	private JPanel inputImagePanel;
	private JPanel footerPanel;
	private JPanel outputImagePanel;
	private JPanel controlImagePanel;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JLabel inputImage;
	private JLabel outputImage;
	private UIController controller;
	private JButton btn_greyscale;
	private JButton btn_blur;
	private JButton btn_sharpen;
	private JButton btn_sepia;
	private JButton btn_dither;
	private JButton btn_mosaic;
	private JButton btn_pixelate;
	private JButton btn_pattern;
	private JButton btn_loadImage;
	private JButton btn_save;
	private JLabel lblNewLabel_1;
	private JTextArea txt_console;
	private ConsoleOutput out;

	/**
	 * Create the application.
	 */
	public View() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImageProcessingAnd = new JFrame();
		frmImageProcessingAnd.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmImageProcessingAnd.setTitle("Image processing and Cross-stitch ");
		frmImageProcessingAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImageProcessingAnd.setVisible(true);

		JMenuBar menuBar = new JMenuBar();
		frmImageProcessingAnd.setJMenuBar(menuBar);

		JMenu fileMenu = new JMenu("Application");
		menuBar.add(fileMenu);

		saveMenuItem = new JMenuItem("Save Output Image As...");
		saveMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOutputImage();
			}
		});
		fileMenu.add(saveMenuItem);

		JMenuItem exitMenuItem = new JMenuItem("Exit");
		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImageProcessingAnd.dispose();
			}
		});
		fileMenu.add(exitMenuItem);

		JMenu imageMenu = new JMenu("Image");
		menuBar.add(imageMenu);

		loadImageMenuItem = new JMenuItem("Load New Image");
		loadImageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				loadImage();
			}
		});
		imageMenu.add(loadImageMenuItem);

		processImageMenu = new JMenu("Process Image");
		imageMenu.add(processImageMenu);

		blurImageMenuItem = new JMenuItem("Blur Image");
		blurImageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("blur");
			}
		});
		processImageMenu.add(blurImageMenuItem);

		sharpenImageMenuItem = new JMenuItem("Sharpen Image");
		sharpenImageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("sharpening");
			}
		});
		processImageMenu.add(sharpenImageMenuItem);

		greyscaleMenuItem = new JMenuItem("Convert To Greyscale");
		greyscaleMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("greyscale");
			}
		});
		processImageMenu.add(greyscaleMenuItem);

		sepiaMenuItem = new JMenuItem("Sepia tone");
		sepiaMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("sepia_tone");
			}
		});
		processImageMenu.add(sepiaMenuItem);

		ditherMenuItem = new JMenuItem("Floyd Steinberg Dithering");
		ditherMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("dither");
			}
		});
		processImageMenu.add(ditherMenuItem);

		mosaicImageMenuItem = new JMenuItem("Mosaic");
		mosaicImageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("mosaic");
			}
		});
		processImageMenu.add(mosaicImageMenuItem);

		pixelateImageMenuItem = new JMenuItem("Pixelate Image");
		pixelateImageMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("pixelate");
			}
		});
		processImageMenu.add(pixelateImageMenuItem);

		imagePatternMenuItem = new JMenuItem("Generate Image Pattern");
		imagePatternMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("pattern");
			}
		});
		processImageMenu.add(imagePatternMenuItem);

		resetMenuItem = new JMenuItem("Reset Images");
		resetMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputImage.setIcon(null);
				outputImage.setIcon(null);
				isImageLoaded = false;
				toggleImageButtons();
			}
		});
		imageMenu.add(resetMenuItem);

		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frmImageProcessingAnd.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		headerPanel = new JPanel();
		headerPanel.setBackground(Color.WHITE);
		headerPanel.setPreferredSize(new Dimension(800, 100));
		panel.add(headerPanel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Image processing and Cross-stitch ");
		lblNewLabel.setPreferredSize(new Dimension(700, 80));
		lblNewLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 30));
		headerPanel.add(lblNewLabel, "42, 4");

		inputImagePanel = new JPanel();
		inputImagePanel.setPreferredSize(new Dimension(570, 450));
		panel.add(inputImagePanel, BorderLayout.WEST);
		inputImagePanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		inputImagePanel.add(scrollPane, BorderLayout.CENTER);

		inputImage = new JLabel("");
		inputImage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setViewportView(inputImage);

		footerPanel = new JPanel();
		footerPanel.setBackground(Color.WHITE);
		footerPanel.setPreferredSize(new Dimension(800, 200));
		panel.add(footerPanel, BorderLayout.SOUTH);
		footerPanel.setLayout(new BorderLayout(0, 0));

		lblNewLabel_1 = new JLabel("Console");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		footerPanel.add(lblNewLabel_1, BorderLayout.NORTH);

		txt_console = new JTextArea();
		footerPanel.add(txt_console, BorderLayout.CENTER);

		outputImagePanel = new JPanel();
		outputImagePanel.setPreferredSize(new Dimension(570, 450));
		panel.add(outputImagePanel, BorderLayout.CENTER);
		outputImagePanel.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		outputImagePanel.add(scrollPane_1, BorderLayout.CENTER);

		outputImage = new JLabel("");
		outputImage.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setViewportView(outputImage);

		controlImagePanel = new JPanel();
		controlImagePanel.setBackground(Color.WHITE);
		controlImagePanel.setPreferredSize(new Dimension(370, 450));
		panel.add(controlImagePanel, BorderLayout.EAST);
		GridBagLayout gbl_controlImagePanel = new GridBagLayout();
		gbl_controlImagePanel.columnWidths = new int[] { 100, 100, 100 };
		gbl_controlImagePanel.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40, 40 };
		gbl_controlImagePanel.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_controlImagePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		controlImagePanel.setLayout(gbl_controlImagePanel);

		btn_loadImage = new JButton("Load Image");
		btn_loadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadImage();
			}
		});
		btn_loadImage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_loadImage = new GridBagConstraints();
		gbc_btn_loadImage.fill = GridBagConstraints.BOTH;
		gbc_btn_loadImage.insets = new Insets(5, 0, 5, 5);
		gbc_btn_loadImage.gridx = 1;
		gbc_btn_loadImage.gridy = 2;
		controlImagePanel.add(btn_loadImage, gbc_btn_loadImage);

		btn_blur = new JButton("Blur Image");
		btn_blur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("blur");
			}
		});
		btn_blur.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_blur = new GridBagConstraints();
		gbc_btn_blur.fill = GridBagConstraints.BOTH;
		gbc_btn_blur.insets = new Insets(5, 0, 5, 5);
		gbc_btn_blur.gridx = 1;
		gbc_btn_blur.gridy = 3;
		controlImagePanel.add(btn_blur, gbc_btn_blur);

		btn_sharpen = new JButton("Sharpen Image");
		btn_sharpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("sharpening");
			}
		});
		btn_sharpen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_sharpen = new GridBagConstraints();
		gbc_btn_sharpen.fill = GridBagConstraints.BOTH;
		gbc_btn_sharpen.insets = new Insets(5, 0, 5, 5);
		gbc_btn_sharpen.gridx = 1;
		gbc_btn_sharpen.gridy = 4;
		controlImagePanel.add(btn_sharpen, gbc_btn_sharpen);

		btn_greyscale = new JButton("Convert To GreyScale");
		btn_greyscale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("greyscale");
			}
		});
		btn_greyscale.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_greyscale = new GridBagConstraints();
		gbc_btn_greyscale.fill = GridBagConstraints.BOTH;
		gbc_btn_greyscale.insets = new Insets(5, 0, 5, 5);
		gbc_btn_greyscale.gridx = 1;
		gbc_btn_greyscale.gridy = 5;
		controlImagePanel.add(btn_greyscale, gbc_btn_greyscale);

		btn_sepia = new JButton("Sepia Image");
		btn_sepia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("sepia_tone");
			}
		});
		btn_sepia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_sepia = new GridBagConstraints();
		gbc_btn_sepia.fill = GridBagConstraints.BOTH;
		gbc_btn_sepia.insets = new Insets(5, 0, 5, 5);
		gbc_btn_sepia.gridx = 1;
		gbc_btn_sepia.gridy = 6;
		controlImagePanel.add(btn_sepia, gbc_btn_sepia);

		btn_dither = new JButton("Dithering");
		btn_dither.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("dither");
			}
		});
		btn_dither.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_dither = new GridBagConstraints();
		gbc_btn_dither.fill = GridBagConstraints.BOTH;
		gbc_btn_dither.insets = new Insets(5, 0, 5, 5);
		gbc_btn_dither.gridx = 1;
		gbc_btn_dither.gridy = 7;
		controlImagePanel.add(btn_dither, gbc_btn_dither);

		btn_mosaic = new JButton("Mosaic Image");
		btn_mosaic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("mosaic");
			}
		});
		btn_mosaic.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_mosaic = new GridBagConstraints();
		gbc_btn_mosaic.fill = GridBagConstraints.BOTH;
		gbc_btn_mosaic.insets = new Insets(5, 0, 5, 5);
		gbc_btn_mosaic.gridx = 1;
		gbc_btn_mosaic.gridy = 8;
		controlImagePanel.add(btn_mosaic, gbc_btn_mosaic);

		btn_pixelate = new JButton("Pixelate Image");
		btn_pixelate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("pixelate");
			}
		});
		btn_pixelate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_pixelate = new GridBagConstraints();
		gbc_btn_pixelate.fill = GridBagConstraints.BOTH;
		gbc_btn_pixelate.insets = new Insets(5, 0, 5, 5);
		gbc_btn_pixelate.gridx = 1;
		gbc_btn_pixelate.gridy = 9;
		controlImagePanel.add(btn_pixelate, gbc_btn_pixelate);

		btn_pattern = new JButton("Generate Pattern");
		btn_pattern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				perfromAction("pattern");
			}
		});
		btn_pattern.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_pattern = new GridBagConstraints();
		gbc_btn_pattern.fill = GridBagConstraints.BOTH;
		gbc_btn_pattern.insets = new Insets(5, 0, 5, 5);
		gbc_btn_pattern.gridx = 1;
		gbc_btn_pattern.gridy = 10;
		controlImagePanel.add(btn_pattern, gbc_btn_pattern);

		btn_save = new JButton("Save Output Image");
		btn_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveOutputImage();
			}
		});
		btn_save.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btn_save = new GridBagConstraints();
		gbc_btn_save.fill = GridBagConstraints.BOTH;
		gbc_btn_save.insets = new Insets(10, 0, 10, 5);
		gbc_btn_save.gridx = 1;
		gbc_btn_save.gridy = 11;
		controlImagePanel.add(btn_save, gbc_btn_save);

		isImageLoaded = false;
		out = new ConsoleOutput(txt_console);
		toggleImageButtons();
	}

	protected void saveOutputImage() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save output image.");
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image File", ".jpg");
		fileChooser.setFileFilter(filter);

		int userSelection = fileChooser.showSaveDialog(frmImageProcessingAnd);

		if (userSelection == JFileChooser.APPROVE_OPTION) {
			File fileToSave = fileChooser.getSelectedFile();
			String path = fileToSave.getPath();
			if (!path.endsWith(".jpg"))
				path = path + ".jpg";
			controller.save(path);
		}

	}

	protected void perfromAction(String action) {
		try {
			String[] params = null;
			if (action == "dither") {
				int num = Integer.parseInt(JOptionPane.showInputDialog(frmImageProcessingAnd,
						"Enter value for dithering max color? e.g 5"));
				params = new String[1];
				params[0] = num + "";
			} else if (action == "mosaic") {
				int num = Integer.parseInt(JOptionPane.showInputDialog(frmImageProcessingAnd,
						"Enter seeds value for Mosaic Image? e.g 570"));
				params = new String[1];
				params[0] = num + "";
			} else if (action == "pixelate") {
				int num = Integer.parseInt(
						JOptionPane.showInputDialog(frmImageProcessingAnd, "Enter square size for Pixelation? e.g 52"));
				params = new String[1];
				params[0] = num + "";
			} else if (action == "pixelate") {
				int num = Integer.parseInt(
						JOptionPane.showInputDialog(frmImageProcessingAnd, "Enter square size for Pixelation? e.g 52"));
				params = new String[1];
				params[0] = num + "";
			} else if (action == "pattern") {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Specify a file to save patterns");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File", "txt");
				fileChooser.setFileFilter(filter);

				int userSelection = fileChooser.showSaveDialog(frmImageProcessingAnd);

				if (userSelection == JFileChooser.APPROVE_OPTION) {
					File fileToSave = fileChooser.getSelectedFile();
					try {
						int num = Integer.parseInt(
								JOptionPane.showInputDialog(frmImageProcessingAnd, "Enter value for Pattern? e.g 41"));
						params = new String[2];
						params[0] = num + "";
						params[1] = fileToSave.getPath();
						System.out.println(params[0] + "   " + params[1]);

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			out.append("Performing Action: " + action + "...\n");
			controller.perfromAction(action, params);
			BufferedImage image = ImageUtilities.getBufferedImage(controller.getProcessing().getResult(),
					controller.getWidth(), controller.getHeight());
			outputImage.setIcon(new ImageIcon(image));

			if (action == "pattern") {
				out.append("Click on result image to replace pixcel colors.");

				outputImage.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							int packedInt = image.getRGB(e.getX(), e.getY());
							Color initialcolor = new Color(packedInt, true);
							System.out.println(initialcolor.getRed()+" - "+initialcolor.getGreen()+" - "+initialcolor.getBlue());
							Color color= JColorChooser.showDialog(null,"Select a alternate color",initialcolor);    
							controller.getProcessing().replaceColor(initialcolor,color);
							BufferedImage image = ImageUtilities.getBufferedImage(controller.getProcessing().getResult(),
									controller.getWidth(), controller.getHeight());
							outputImage.setIcon(new ImageIcon(image));
						}
						catch(Exception ex) {
							
						}
					}
				});
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(frmImageProcessingAnd, "Wrong or Empty Input", "Error Processing Request", 0,
					null);
		}
	}

	protected void loadImage() {

		JFileChooser fc = new JFileChooser();
		int result = fc.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			try {
				controller = new UIController(file.getPath(), out);
				BufferedImage image = ImageUtilities.getBufferedImage(controller.getProcessing().getImage(),
						controller.getWidth(), controller.getHeight());
				inputImage.setIcon(new ImageIcon(image));
				outputImage.setIcon(new ImageIcon(image));
				isImageLoaded = true;
				toggleImageButtons();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void toggleImageButtons() {
		saveMenuItem.setEnabled(isImageLoaded);
		processImageMenu.setEnabled(isImageLoaded);
		blurImageMenuItem.setEnabled(isImageLoaded);
		sharpenImageMenuItem.setEnabled(isImageLoaded);
		greyscaleMenuItem.setEnabled(isImageLoaded);
		sepiaMenuItem.setEnabled(isImageLoaded);
		ditherMenuItem.setEnabled(isImageLoaded);
		mosaicImageMenuItem.setEnabled(isImageLoaded);
		pixelateImageMenuItem.setEnabled(isImageLoaded);
		imagePatternMenuItem.setEnabled(isImageLoaded);
		resetMenuItem.setEnabled(isImageLoaded);
		btn_greyscale.setEnabled(isImageLoaded);
		btn_blur.setEnabled(isImageLoaded);
		btn_sharpen.setEnabled(isImageLoaded);
		btn_sepia.setEnabled(isImageLoaded);
		btn_dither.setEnabled(isImageLoaded);
		btn_mosaic.setEnabled(isImageLoaded);
		btn_pixelate.setEnabled(isImageLoaded);
		btn_pattern.setEnabled(isImageLoaded);
		btn_save.setEnabled(isImageLoaded);

	}
}

class ConsoleOutput implements Appendable {
	private JTextArea textArea;

	public ConsoleOutput(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public Appendable append(CharSequence csq) throws IOException {
		textArea.append(String.valueOf(csq));
		textArea.setCaretPosition(textArea.getDocument().getLength());
		return null;
	}

	@Override
	public Appendable append(CharSequence csq, int start, int end) throws IOException {
		textArea.append(String.valueOf(csq));
		textArea.setCaretPosition(textArea.getDocument().getLength());
		return null;
	}

	@Override
	public Appendable append(char c) throws IOException {
		textArea.append(String.valueOf(c));
		textArea.setCaretPosition(textArea.getDocument().getLength());
		return null;
	}

}
