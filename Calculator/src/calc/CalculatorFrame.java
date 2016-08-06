package calc;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class CalculatorFrame extends JFrame {
	
	private static int HEIGHT = 600;
	private static int WIDTH = HEIGHT * (2/3);

	private static final long serialVersionUID = 7276436695265859508L;
	
	private static JFrame calcFrame = new JFrame("Calculator");
	
	public static void main(){
		calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calcFrame.setSize(HEIGHT, WIDTH);
		calcFrame.setVisible(true);
		calcFrame.getContentPane().add(new JButton(), BorderLayout.CENTER);
		calcFrame.pack();
		JFrame.setDefaultLookAndFeelDecorated(true);
	}
	
}
