package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class whack_a_mole implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	private int molesWhacked = 0;
	private int molesMissed = 0;
	Date timeAtStart = new Date();
	
	public void run() {
		timeAtStart = new Date();
		createGUI();

	}
	public void createGUI() {
		frame.dispose();
		frame = new JFrame();
		panel = new JPanel();
		frame.setVisible(true);
		frame.add(panel);
		frame.setPreferredSize(new Dimension(500, 500));
		Random rand = new Random();
		int r = rand.nextInt(25);
		drawButtons(r);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
	public void drawButtons(int r) {
		for (int i = 0; i < 25; i++) {
			JButton button = new JButton();
			button.setPreferredSize(new Dimension(100, 50));
			button.addActionListener(this);
			if (i == r) {
				button.setText("mole!");
			}
			panel.add(button);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if (!button.getText().equals("mole!")) {
			speak("You missed the mole");
			molesMissed += 1;
		} else {
			molesWhacked += 1;
			if (molesWhacked >= 10) {
				endGame(timeAtStart, molesWhacked);
				JOptionPane.showMessageDialog(null, "You have missed " + molesMissed + " moles.");
				molesWhacked = 0;
				timeAtStart = new Date();
				molesMissed = 0;
			}
		}
		createGUI();
	}
    static void speak(String words) {
        if( System.getProperty( "os.name" ).contains( "Windows" ) ) {
            String cmd = "PowerShell -Command \"Add-Type -AssemblyName System.Speech; (New-Object System.Speech.Synthesis.SpeechSynthesizer).Speak('"
                    + words + "');\"";
            try {
                Runtime.getRuntime().exec( cmd ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        } else {
            try {
                Runtime.getRuntime().exec( "say " + words ).waitFor();
            } catch( Exception e ) {
                e.printStackTrace();
            }
        }
    }
    private void endGame(Date timeAtStart, int molesWhacked) { 
        Date timeAtEnd = new Date();
        JOptionPane.showMessageDialog(null, "Your whack rate is "
                + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
                      + " moles per second.");
    }
}
