package randomtestfive.chess3d.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.piece.ChessPiece;

public class SubboardDisplay extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	public final boolean invert;
	public static final Color color1 = new Color(255,0,255);
	public static final Color color2 = new Color(0,255,255);
	private Board board;
	private int layer;
	private static Map<String, BufferedImage[]> sprites;
	
	public SubboardDisplay(boolean invert, Board b, int layer) {
		super();
		//setSize(100, 100);
		this.invert = invert;
		board = b;
		this.layer = layer;
		sprites = new HashMap<>();
		try {
//			System.out.println(getClass().getResource("/randomtestfive/graphics/pawn.png"));
			sprites.put("Pawn", new BufferedImage[]{ImageIO.read(getClass().getResource("pawn.png")),
					ImageIO.read(getClass().getResource("pawn.png"))});
			sprites.put("Knight", sprites.get("Pawn"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		addMouseListener(this);
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
		Selection.getSelection().ifPresent(s->s.getPossibleMoves(board.getPieces())
			.stream()
			.filter(p->p.getZ()==layer)
			.forEach(p->g2d.fillRect(wsize*p.getX(), hsize*p.getY(), wsize, hsize)));
		
		List<ChessPiece> pieces = board.onSubBoard(layer);
		for(ChessPiece p : pieces) {
			BufferedImage s = sprites.get(p.getPieceName())[0];
			g2d.drawImage(s, p.getPosition().getX()*wsize, p.getPosition().getY()*hsize,wsize,hsize,null);
		}
		g2d.dispose();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		final int gridx = e.getX()*5/getWidth();
		final int gridy = e.getY()*5/getHeight();
		Selection.setSelection(board.onSubBoard(layer).stream()
				.filter(p->p.getPosition().getX()==gridx)
				.filter(p->p.getPosition().getY()==gridy)
				.findFirst().orElse(null));
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
}