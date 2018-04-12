package randomtestfive.chess3d.main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import randomtestfive.chess3d.graphics.Startup;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Startup();
	}
}
