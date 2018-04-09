package randomtestfive.chess3d.core.piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Hybrid extends ChessPiece {
	private final Set<ChessPiece> subPieces;
	private final String name;
	
	public Hybrid(int x, int y, int z, Player owner, String name, ChessPiece... pieces) {
		super(x, y, z, owner);
		this.name = name;
		subPieces = new HashSet<>(Arrays.asList(pieces));
		subPieces.stream().forEach(p->p.moveTo(new Position3D(x, y, z), new HashSet<>()));
	}
	
	@Override
	public void moveTo(Position3D pos, Set<ChessPiece> pieces) {
		super.moveTo(pos, pieces);
		if(subPieces!= null) {
			subPieces.stream().forEach(p->p.moveTo(pos, new HashSet<>()));
		}
	}

	@Override
	public Set<Position3D> getPossibleMoves(Set<ChessPiece> pieces) {
		final Set<Position3D> possible = new HashSet<>();
		subPieces.stream().forEach(p->possible.addAll(p.getPossibleMoves(pieces)));
		return possible;
	}

	@Override
	public String getPieceName() {
		return name;
	}

}
