package randomtestfive.chess3d.graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.Position3D;
import randomtestfive.chess3d.core.pieces.ChessPiece;

public class SubboardDisplay extends JPanel implements MouseListener, MouseMotionListener {
	private static final long serialVersionUID = 1L;
	public final boolean invert;
	public static final Color color1 = new Color(255,0,255);
	public static final Color color2 = new Color(0,255,255);
	private Board board;
	private int layer;
	private static Map<String, BufferedImage[]> sprites;
	private final Runnable callback;
	
	public SubboardDisplay(boolean invert, Board b, int layer, Runnable c) {
		super();
		//setSize(100, 100);
		this.invert = invert;
		board = b;
		this.layer = layer;
		sprites = new HashMap<>();
		try {
//			System.out.println(getClass().getResource("/randomtestfive/graphics/pawn.png"));
			sprites.put("Pawn", new BufferedImage[]{ImageIO.read(getClass().getResource("pawn-b.png")),
					ImageIO.read(getClass().getResource("pawn-w.png"))});
			sprites.put("Knight",new BufferedImage[]{ImageIO.read(getClass().getResource("knight-b.png")),
					ImageIO.read(getClass().getResource("knight-w.png"))});
			sprites.put("King",new BufferedImage[]{ImageIO.read(getClass().getResource("king-b.png")),
					ImageIO.read(getClass().getResource("king-w.png"))});
			sprites.put("Rook", new BufferedImage[]{ImageIO.read(getClass().getResource("rook-b.png")),
					ImageIO.read(getClass().getResource("rook-w.png"))});
			sprites.put("Bishop", new BufferedImage[]{ImageIO.read(getClass().getResource("bishop-b.png")),
					ImageIO.read(getClass().getResource("bishop-w.png"))});
			sprites.put("Unicorn", new BufferedImage[]{ImageIO.read(getClass().getResource("unicorn-b.png")),
					ImageIO.read(getClass().getResource("unicorn-w.png"))});
			sprites.put("Queen", new BufferedImage[]{ImageIO.read(getClass().getResource("queen-b.png")),
					ImageIO.read(getClass().getResource("queen-w.png"))});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addMouseListener(this);
		addMouseMotionListener(this);
		setPreferredSize(new Dimension(320, 320));
		
		callback = c;
	}

	@Override
	public void paint(Graphics g) {
		final Graphics2D g2d = (Graphics2D)g;
		final int hsize = (int) Math.ceil(getHeight()/5.0);
		final int wsize = (int) Math.ceil(getWidth()/5.0);
		//System.out.println(wsize+","+hsize);
		boolean invertTemp = invert;
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 5; x++) {
				g2d.setColor(invertTemp ? color1 : color2);
				g2d.fillRect(x*wsize, y*hsize, wsize, hsize);
				invertTemp=!invertTemp;
			}
		}
		g2d.setColor(Color.yellow);
		Globals.getSelection().ifPresent(s->s.getPossibleMoves(board.getPieces())
			.stream()
			.filter(p->p.getZ()==layer)
			.forEach(p->g2d.fillRect(wsize*p.getX(), hsize*(4-p.getY()), wsize, hsize)));
		
		Set<ChessPiece> pieces = board.onSubBoard(layer);
		for(ChessPiece p : pieces) {
			BufferedImage s = sprites.get(p.getPieceName())[p.getOwner().ordinal()];
			g2d.drawImage(s, p.getPosition().getX()*wsize, (4-p.getPosition().getY())*hsize,wsize,hsize,null);
		}
		g2d.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(!Globals.getReady()) {
			return;
		}
		final int gridx = e.getX()*5/getWidth();
		final int gridy = 4-(e.getY()*5/getHeight());
		if(Globals.getSelection().isPresent() && Globals.getTurn() % 2 == Globals.getPlayer().ordinal()) {
			final ChessPiece piece = Globals.getSelection().get();
			piece.getPossibleMoves(board.getPieces()).stream()
			.filter(p->p.getZ()==layer)
			.filter(p->p.getX()==gridx)
			.filter(p->p.getY()==gridy)
			.findFirst().ifPresent((p)->{
					Globals.commitMove(piece.getPosition(), p);
					Globals.nextTurn();
					piece.moveTo(p,board.getPieces());
					callback.run();
				});
			Globals.setSelection(null);
		} else {
			Globals.setSelection(board.onSubBoard(layer).stream()
					.filter(p->p.getOwner()==Globals.getPlayer())
					.filter(p->p.getPosition().getX()==gridx)
					.filter(p->p.getPosition().getY()==gridy)
					.findFirst().orElse(null));
		}
		getParent().repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent e) {
		setToolTipText(new Position3D(
				e.getX()*5/getWidth(),
				4-(e.getY()*5/getHeight()),
				layer).toString());
	}
	
	@Override
	public Point getToolTipLocation(MouseEvent e) {
		Point t = e.getPoint();
		t.x += 15;
		return t;
	}
}
