package _05_typing_tutor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TypingTutor implements KeyListener {
	
	char currentLetter;
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	public static void main(String[] args) {
		TypingTutor tutor = new TypingTutor();
		tutor.setup(); 

	}
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}
	
	void setup(){
         JFrame frame = new JFrame();
         frame.setVisible(true);
         frame.addKeyListener(this);
         panel.setPreferredSize(new Dimension(300, 50));
         currentLetter = generateRandomLetter();
         
         label.setText(currentLetter + "");
         label.setFont(label.getFont().deriveFont(28.0f));
         label.setHorizontalAlignment(JLabel.CENTER);
         
         panel.add(label);
         frame.add(panel);
         frame.pack();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyChar() == currentLetter) {
			panel.setBackground(Color.green);
		} else {
			panel.setBackground(Color.red);
		}
		currentLetter = generateRandomLetter();
		label.setText(currentLetter + "");
		

		
	}
}
