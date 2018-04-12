package randomtestfive.chess3d.graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.StartPieces;
import randomtestfive.chess3d.network.Chess3DClient;
import randomtestfive.chess3d.network.Chess3DServer;

public class Startup implements ActionListener {
	private JFrame frame;
	JButton server;
	JTextField text;
	
	public Startup() {
		frame = new JFrame("3D Chess");
		server = new JButton("Start Server");
		server.addActionListener(this);
		JButton client = new JButton("Start Client");
		client.addActionListener(this);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		try {
			frame.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResource("title.png")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		frame.add(server);
		frame.add(client);
		text = new JTextField(5);
		text.setText("127.0.0.1");
		frame.add(text);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(server)) {
			new Chess3DServer();
		}
		Board b = new Board();
		b.getPieces().addAll(StartPieces.getStartPieces());
		
		
		new Chess3DClient(text.getText(), b, new MainDisplay(b).boards::repaint);
		frame.dispose();
	}
}
