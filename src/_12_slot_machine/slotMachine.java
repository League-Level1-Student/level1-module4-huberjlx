package _12_slot_machine;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class slotMachine implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	Random rand = new Random();
	
	public void run() {
		button.addActionListener(this);
		chooseRandomImage();
	}
	public String chooseFilename() {
		String filename = "";
		int r = rand.nextInt(3);
		if (r == 0) {
			filename = "cherry.jpg";
		}
		else if (r == 1) {
			filename = "orange.jpg";
		} else {
			filename = "lime.jpg";
		}
		return filename;
		
	}
	
	public void chooseRandomImage() {
		frame.dispose();
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(400, 400));
		try {
			String image1 = chooseFilename();
			JLabel label = createLabelImage(image1);
			panel.add(label);
			
			String image2 = chooseFilename();
			label = createLabelImage(image2);
			panel.add(label);
			
			String image3 = chooseFilename();
			label = createLabelImage(image3);
			panel.add(label);
			
			if (image1 == image2 && image2 == image3) {
				JOptionPane.showMessageDialog(null, "YOU WON!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		button.setText("Spin!");
		
		
		panel.add(button);
		frame.add(panel);
		frame.pack();
	}
	/*private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
} */
	
	private JLabel createLabelImage(String filename) throws IOException{
		BufferedImage image = null;
		image = ImageIO.read(new File("src/_12_slot_machine/" + filename));
		Image scaledImage = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		JLabel imageLabel = new JLabel(icon);
		return imageLabel;
}


	@Override
	public void actionPerformed(ActionEvent e) {
		chooseRandomImage();
	}
}
