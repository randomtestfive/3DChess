package randomtestfive.chess3d.core.piece;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Knight extends ChessPiece {
	private final List<Position3D> captureOffsets;

	public Knight(int x, int y, int z, Player owner) {
		super(x, y, z, owner);
		captureOffsets = Arrays.asList(
				new Position3D(0,1,2),
				new Position3D(0,-1,2),
				new Position3D(0,1,-2),
				new Position3D(0,-1,-2),
				new Position3D(1,0,2),
				new Position3D(-1,0,2),
				new Position3D(1,0,-2),
				new Position3D(-1,0,-2),
				new Position3D(1,2,0),
				new Position3D(-1,2,0),
				new Position3D(1,-2,0),
				new Position3D(-1,-2,0),
				new Position3D(2,1,0),
				new Position3D(2,-1,0),
				new Position3D(-2,1,0),
				new Position3D(-2,-1,0),
				new Position3D(2,0,1),
				new Position3D(2,0,-1),
				new Position3D(-2,0,1),
				new Position3D(-2,0,-1),
				new Position3D(0,2,1),
				new Position3D(0,2,-1),
				new Position3D(0,-2,1),
				new Position3D(0,-2,-1)
				);
	}

	@Override
	public List<Position3D> getPossibleMoves(List<ChessPiece> pieces) {
		return captureOffsets.stream()
			.map(o->getPosition().getOffset(o))
			.filter(o->o.getX()>=0&&o.getX()<=4)
			.filter(o->o.getY()>=0&&o.getY()<=4)
			.filter(o->o.getZ()>=0&&o.getZ()<=4)
			.filter((o)->!pieces.stream()
					.filter(p->p.getOwner()==getOwner()&&p.getPosition().equals(o))
					.findAny().isPresent())
			.collect(Collectors.toList());
	}

	@Override
	public String getPieceName() {
		return "Knight";
	}

}
