package multithreading;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TextFlasher extends Thread {

	JFrame frame = new JFrame();
	JButton btn = new JButton();
	JPanel center = new JPanel();

	public TextFlasher() {
		btn.setText("Hello!");
		btn.setBackground(Color.WHITE);

		frame.add(btn);

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			alterColor();
			// if (btn.getText().equals("Hello!")) {
			// btn.setText("");
			// } else {
			// btn.setText("Hello!");
			// }
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected void alterColor() {
		if (btn.getBackground().equals(Color.WHITE)) {
			btn.setBackground(Color.GRAY);
		} else {
			btn.setBackground(Color.WHITE);
		}
	}

	public static void main(String[] args) {
		TextFlasher textFlasher = new TextFlasher();
		textFlasher.start();
	}
}
