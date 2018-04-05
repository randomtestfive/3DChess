package randomtestfive.chess3d.graphics;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;

import randomtestfive.chess3d.core.Board;

public class MainDisplay {
	public JFrame frame;
	
	public MainDisplay(Board b) {
		frame = new JFrame("thing");
		frame.setSize(1540, 300);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		frame.getContentPane().add(new SubboardDisplay(false, b, 4));
		frame.getContentPane().add(Box.createHorizontalStrut(10));
		frame.getContentPane().add(new SubboardDisplay(true, b, 3));
		frame.getContentPane().add(Box.createHorizontalStrut(10));
		frame.getContentPane().add(new SubboardDisplay(false, b, 2));
		frame.getContentPane().add(Box.createHorizontalStrut(10));
		frame.getContentPane().add(new SubboardDisplay(true, b, 1));
		frame.getContentPane().add(Box.createHorizontalStrut(10));
		frame.getContentPane().add(new SubboardDisplay(false, b, 0));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
