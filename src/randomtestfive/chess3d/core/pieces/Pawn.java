package randomtestfive.chess3d.core.pieces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Pawn extends ChessPiece {
	private final int offset;
	private final Set<Position3D> captureOffsets;

	public Pawn(int x, int y, int z, Player owner) {
		super(x, y, z, owner);
		offset = getOwner() == Player.BLACK ? -1 : 1;
		captureOffsets = new HashSet<>(Arrays.asList(
				new Position3D(-1,offset,0),
				new Position3D(1,offset,0),
				new Position3D(-1,0,offset),
				new Position3D(1,0,offset),
				new Position3D(0,offset,offset)));
	}
	
	@Override
	public void moveTo(Position3D pos, Set<ChessPiece> p) {
		super.moveTo(pos, p);
		boolean replace = false;
		switch(getOwner()) {
		case BLACK:
			if(getPosition().getY()==0 && getPosition().getZ()==0) {
				replace = true;
			}
			break;
		case WHITE:
			if(getPosition().getY()==4 && getPosition().getZ()==4) {
				replace = true;
			}
		}
		if(replace) {
			p.remove(this);
			p.add(new Queen(pos.getX(), pos.getY(), pos.getZ(), getOwner()));
		}
	}

	@Override
	public Set<Position3D> getPossibleMoves(Set<ChessPiece> pieces) {
		Set<Position3D> possible = new HashSet<>();
		Set<Position3D> piecepos = pieces.stream()
				.map((p)->p.getPosition())
				.collect(Collectors.toSet());
		if(getPosition().getY()+offset >= 0 && getPosition().getY()+offset <= 4
				&& !piecepos.contains(getPosition().getOffset(0, offset, 0))) {
			possible.add(getPosition().getOffset(0, offset, 0));
		}
		if(getPosition().getZ()+offset >= 0 && getPosition().getZ()+offset <= 4
				&& !piecepos.contains(getPosition().getOffset(0, 0, offset))) {
			possible.add(getPosition().getOffset(0, 0, offset));
		}
		possible.addAll(
			pieces.stream()
				.filter((p)->p.getOwner()!=getOwner())
				.filter((p)-> {
					return captureOffsets.stream()
							.filter((o)->getPosition().getOffset(o).equals(p.getPosition()))
							.findAny().isPresent();
				})
				.map((p)->p.getPosition())
				.collect(Collectors.toList()));
		return possible;
	}

	@Override
	public String getPieceName() {
		return "Pawn";
	}

}
