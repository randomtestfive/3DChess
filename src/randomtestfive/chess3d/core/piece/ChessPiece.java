package randomtestfive.chess3d.core.piece;

import java.util.HashSet;
import java.util.Set;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public abstract class ChessPiece {
	private Position3D pos;
	private final Player owner;
	
	public ChessPiece(int x, int y, int z, Player owner) {
		moveTo(x, y, z, new HashSet<>());
		this.owner = owner; 
	}
	
	public void moveTo(int x, int y, int z, Set<ChessPiece> pieces) {
		moveTo(new Position3D(x, y, z), pieces);
	}
	
	public void moveTo(Position3D p, Set<ChessPiece> pieces) {
		pos = p;
		pieces.stream()
			.filter(piece->piece!=this)
			.filter(piece->piece.getPosition().equals(pos))
			.findFirst().ifPresent(piece->pieces.remove(piece));
	}
	
	public Position3D getPosition() { return pos; }
	public Player getOwner() { return owner; }
	
	@Override
	public String toString() {
		return owner + " " + getPieceName() + " " + pos.toString();
	}
	
	public abstract Set<Position3D> getPossibleMoves(Set<ChessPiece> pieces);
	public abstract String getPieceName();
}
