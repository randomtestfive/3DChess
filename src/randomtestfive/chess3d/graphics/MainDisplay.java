package randomtestfive.chess3d.graphics;


import java.awt.Graphics;
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

public class MainDisplay extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel boards;
	private Board b;
	
	public MainDisplay(Board b) {
		super("3D Chess (NOT READY)");
		this.b = b;
		boards = new JPanel();
		boards.setLayout(new BoxLayout(boards, BoxLayout.X_AXIS));
		boards.add(new SubboardDisplay(false, b, 4, this::repaint));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(true, b, 3, this::repaint));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(false, b, 2, this::repaint));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(true, b, 1, this::repaint));
		boards.add(Box.createHorizontalStrut(10));
		boards.add(new SubboardDisplay(false, b, 0, this::repaint));
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		JLabel turn = new JLabel("Turn: 1 - WHITE") {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void paint(Graphics g) {
				setText("Turn: "+Globals.getTurn()+" - "+Player.values()[Globals.getTurn()%2]);
				super.paint(g);
			}
		};
		turn.setHorizontalAlignment(JLabel.LEFT);
		turn.setAlignmentX(-1);
		boards.setAlignmentX(-1);
		add(turn);
		add(boards);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		new Thread(()->{
			while(!Globals.getReady()) {
				Thread.yield();
			}
			setTitle("3D Chess - "+Globals.getPlayer());
		}).start();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		if(b!=null) {
			Set<ChessPiece> kings = b.getPieces().stream()
					.filter(p->p instanceof King)
					.collect(Collectors.toSet());
			if(kings.size()<2) {
				Globals.done();
				JOptionPane.showMessageDialog(this, kings.stream().findFirst().get().getOwner()+" WINS");
				System.exit(0);
			}
		}
	}
}
