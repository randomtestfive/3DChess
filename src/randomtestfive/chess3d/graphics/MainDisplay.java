package randomtestfive.chess3d.graphics;


import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.pieces.ChessPiece;
import randomtestfive.chess3d.core.pieces.King;

public class MainDisplay {
	public JFrame frame;
	JPanel boards;
	
	public MainDisplay(Board b) {
		frame = new JFrame("3D Chess (NOT READY)");
		boards = new JPanel();
		boards.setLayout(new BoxLayout(boards, BoxLayout.X_AXIS));
		boards.add(new SubboardDisplay(false, b, 4));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(true, b, 3));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(false, b, 2));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(true, b, 1));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(false, b, 0));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		JLabel turn = new JLabel("Turn: 1 - WHITE");
		turn.setHorizontalAlignment(JLabel.LEFT);
		turn.setAlignmentX(-1);
		boards.setAlignmentX(-1);
		frame.add(turn);
		frame.add(boards);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		new Thread(()->{
			while(!Globals.getReady()) {
				Thread.yield();
			}
			frame.setTitle("3D Chess - "+Globals.getPlayer());
			while(true) {
				turn.setText("Turn: "+Globals.getTurn()+" - "+Player.values()[Globals.getTurn()%2]);
				Set<ChessPiece> kings = b.getPieces().stream()
						.filter(p->p instanceof King)
						.collect(Collectors.toSet());
				if(kings.size()<2) {
					Globals.done();
					JOptionPane.showMessageDialog(frame, kings.stream().findFirst().get().getOwner()+" WINS");
					System.exit(0);
				}
				Thread.yield();
			}
		}).start();
	}
}
