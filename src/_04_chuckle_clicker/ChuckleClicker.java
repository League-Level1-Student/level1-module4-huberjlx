package _04_chuckle_clicker;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("joke");
	JButton button2 = new JButton("punchline");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChuckleClicker clicker = new ChuckleClicker();
		clicker.makeButtons();
	}
	
	public void makeButtons() {
		//JOptionPane.showMessageDialog(null, "in makeButtons");
		frame.setVisible(true);
		
		panel.setPreferredSize(new Dimension(300, 50));

		button1.addActionListener(this);
		button2.addActionListener(this);

		panel.add(button1);
		panel.add(button2);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button1) {
			JOptionPane.showMessageDialog(null, "Why did Johnny get bored?");
		} else {
			JOptionPane.showMessageDialog(null, "He waited too long for the punchline.");
		}
	}

}
