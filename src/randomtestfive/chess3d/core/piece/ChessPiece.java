package randomtestfive.chess3d.core.piece;

import java.util.List;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public abstract class ChessPiece {
	private Position3D pos;
	private final Player owner;
	
	public ChessPiece(int x, int y, int z, Player owner) {
		moveTo(x, y, z);
		this.owner = owner; 
	}
	
	public void moveTo(int x, int y, int z) {
		pos = new Position3D(x, y, z);
	}
	
	public void moveTo(Position3D p) {
		pos = p;
	}
	
	public Position3D getPosition() { return pos; }
	public Player getOwner() { return owner; }
	
	@Override
	public String toString() {
		return owner + " " + getPieceName() + " " + pos.toString();
	}
	
	public abstract List<Position3D> getPossibleMoves(List<ChessPiece> pieces);
	public abstract String getPieceName();
}
