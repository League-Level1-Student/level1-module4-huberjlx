package _01_nasty_surprise;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class nasty_surprise implements ActionListener {

	JButton button1 = new JButton("Trick");
	JButton button2 = new JButton("Treat");
	
	public static void main(String[] args) {
		nasty_surprise surprise = new nasty_surprise();
		surprise.setup();
		
	}
	
	public void setup() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		button1.addActionListener(this);
		button2.addActionListener(this);
		
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		
		frame.setVisible(true);
		panel.setPreferredSize(new Dimension(500, 500));
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button2) {
			showPictureFromTheInternet("http://1.bp.blogspot.com/-rhLv8cGX8vU/T6LHkB1BbaI/AAAAAAAAAKQ/ydMI4KbXQWM/s1600/cute-puppy-puppies-13789224-1024-768.jpg");
		} else {
			showPictureFromTheInternet("https://i.ytimg.com/vi/4-fE1DMgIWI/maxresdefault.jpg");
		}
	}
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}

}
