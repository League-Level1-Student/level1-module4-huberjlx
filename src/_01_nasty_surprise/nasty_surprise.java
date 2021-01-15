package _01_nasty_surprise;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class nasty_surprise {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton button1 = new JButton("Trick");
		JButton button2 = new JButton("Treat");
		
		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		
		button1.
		
		frame.setVisible(true);
		frame.setSize(600, 600);
		frame.setLayout(null);
		panel.setSize(500, 500);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
	
	

}
