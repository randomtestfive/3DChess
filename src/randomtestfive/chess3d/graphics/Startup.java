package randomtestfive.chess3d.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.StartPieces;
import randomtestfive.chess3d.network.Chess3DClient;
import randomtestfive.chess3d.network.Chess3DServer;

public class Startup implements ActionListener {
	private JFrame frame;
	
	public Startup() {
		frame = new JFrame("3D Chess");
		JButton server = new JButton("Start Server");
		server.addActionListener(this);
		frame.add(server);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Chess3DServer chessServer = new Chess3DServer();
		Chess3DClient chessClient = new Chess3DClient("127.0.0.1");
		Board b = new Board();
		b.getPieces().addAll(StartPieces.getStartPieces());
		new MainDisplay(b);
		frame.dispose();
	}
}
