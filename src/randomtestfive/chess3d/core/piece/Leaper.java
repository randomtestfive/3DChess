package randomtestfive.chess3d.core.piece;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Leaper extends ChessPiece {
	private final Set<Position3D> captureOffsets;
	private final String name;

	public Leaper(int x, int y, int z, Player owner, String name, Position3D offset) {
		super(x, y, z, owner);
		this.name = name;
		int xo = offset.getX();
		int yo = offset.getY();
		int zo = offset.getZ();
		captureOffsets = new HashSet<>(Arrays.asList(
				new Position3D(xo,yo,zo),
				new Position3D(xo,-yo,zo),
				new Position3D(xo,yo,-zo),
				new Position3D(xo,-yo,-zo),
				new Position3D(-xo,-yo,-zo),
				new Position3D(yo,xo,zo),
				new Position3D(-yo,xo,zo),
				new Position3D(yo,xo,-zo),
				new Position3D(-yo,xo,-zo),
				new Position3D(-yo,-xo,-zo),
				new Position3D(yo,zo,xo),
				new Position3D(-yo,zo,xo),
				new Position3D(yo,-zo,xo),
				new Position3D(-yo,-zo,xo),
				new Position3D(-yo,-zo,-xo),
				new Position3D(zo,yo,xo),
				new Position3D(zo,-yo,xo),
				new Position3D(-zo,yo,xo),
				new Position3D(-zo,-yo,xo),
				new Position3D(-zo,-yo,-xo),
				new Position3D(zo,xo,yo),
				new Position3D(zo,xo,-yo),
				new Position3D(-zo,xo,yo),
				new Position3D(-zo,xo,-yo),
				new Position3D(-zo,-xo,-yo),
				new Position3D(xo,zo,yo),
				new Position3D(xo,zo,-yo),
				new Position3D(xo,-zo,yo),
				new Position3D(xo,-zo,-yo),
				new Position3D(-xo,-zo,-yo)
				));
	}

	@Override
	public Set<Position3D> getPossibleMoves(Set<ChessPiece> pieces) {
		return captureOffsets.stream()
			.map(o->getPosition().getOffset(o))
			.filter(o->o.getX()>=0&&o.getX()<=4)
			.filter(o->o.getY()>=0&&o.getY()<=4)
			.filter(o->o.getZ()>=0&&o.getZ()<=4)
			.filter((o)->!pieces.stream()
					.filter(p->p.getOwner()==getOwner()&&p.getPosition().equals(o))
					.findAny().isPresent())
			.collect(Collectors.toSet());
	}

	@Override
	public String getPieceName() {
		return name;
	}
}
