package randomtestfive.chess3d.core.pieces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Rider extends ChessPiece {
	private final Set<Position3D> directions;
	private final String name;

	public Rider(int x, int y, int z, Player owner, String name, Position3D direction) {
		super(x, y, z, owner);
		int xd = direction.getX();
		int yd = direction.getY();
		int zd = direction.getZ();
		this.directions = new HashSet<>(Arrays.asList(
				new Position3D(xd,yd,zd),
				new Position3D(xd,-yd,zd),
				new Position3D(xd,yd,-zd),
				new Position3D(xd,-yd,-zd),
				new Position3D(-xd,-yd,-zd),
				new Position3D(yd,xd,zd),
				new Position3D(-yd,xd,zd),
				new Position3D(yd,xd,-zd),
				new Position3D(-yd,xd,-zd),
				new Position3D(-yd,-xd,-zd),
				new Position3D(yd,zd,xd),
				new Position3D(-yd,zd,xd),
				new Position3D(yd,-zd,xd),
				new Position3D(-yd,-zd,xd),
				new Position3D(-yd,-zd,-xd),
				new Position3D(zd,yd,xd),
				new Position3D(zd,-yd,xd),
				new Position3D(-zd,yd,xd),
				new Position3D(-zd,-yd,xd),
				new Position3D(-zd,-yd,-xd),
				new Position3D(zd,xd,yd),
				new Position3D(zd,xd,-yd),
				new Position3D(-zd,xd,yd),
				new Position3D(-zd,xd,-yd),
				new Position3D(-zd,-xd,-yd),
				new Position3D(xd,zd,yd),
				new Position3D(xd,zd,-yd),
				new Position3D(xd,-zd,yd),
				new Position3D(xd,-zd,-yd),
				new Position3D(-xd,-zd,-yd)
			));
		this.name = name;
	}

	@Override
	public Set<Position3D> getPossibleMoves(Set<ChessPiece> pieces) {
		Set<Position3D> possible = new HashSet<>();
		for(Position3D dir : directions) {
			Position3D[] tmp = {getPosition().getOffset(dir)};
			while(true) {
				if(tmp[0].getX() >= 0 && tmp[0].getX() <= 4
						&& tmp[0].getY() >= 0 && tmp[0].getY() <= 4
						&& tmp[0].getZ() >= 0 && tmp[0].getZ() <= 4) {
					if(!pieces.stream()
							.filter(p->p.getPosition().equals(tmp))
							.findFirst().isPresent()) {
						possible.add(tmp[0]);
					} else {
						break;
					}
				} else {
					break;
				}
				tmp[0] = tmp[0].getOffset(dir);
			}
		}
		return possible;
	}

	@Override
	public String getPieceName() {
		return name;
	}

}
