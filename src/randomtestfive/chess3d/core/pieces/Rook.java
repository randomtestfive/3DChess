package randomtestfive.chess3d.core.pieces;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Rook extends Rider {
	public Rook(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "Rook", new Position3D(0,0,1));
	}
}
