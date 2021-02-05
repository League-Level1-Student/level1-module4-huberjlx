package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();
	JButton button4 = new JButton();
	JTextField field = new JTextField(10);
	JTextField field2 = new JTextField(10);
	JLabel label = new JLabel();
	
	public void run() {

		panel.setPreferredSize(new Dimension(500, 500));
		frame.setVisible(true);
		panel.add(field);
		panel.add(field2);
		button.setText("add");
		button2.setText("sub");
		button3.setText("mul");
		button4.setText("div");
		
		button.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(label);
		frame.add(panel);
		frame.pack();
	}
	
	public void addition(int num1, int num2) {
		int total = num1 + num2;
		label.setText(total + "");
	}
	
	public void subtract(int num1, int num2) {
		int total = num1 - num2;
		label.setText(total + "");
	}
	
	public void multiply(int num1, int num2) {
		int total = num1 * num2;
		label.setText(total + "");
	}
	
	public void divide(float num1, int num2) {
		float total = num1 / num2;
		label.setText(total + "");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = field.getText();
		String text2 = field2.getText();
		int num = Integer.parseInt(text);
		int num2 = Integer.parseInt(text2);
		if (e.getSource().equals(button)) {
			addition(num, num2);
		}
		else if (e.getSource().equals(button2)) {
			subtract(num, num2);
		}
		else if (e.getSource().equals(button3)) {
			multiply(num, num2);
		} else {
			divide(num, num2);
		}
		
	}
}
