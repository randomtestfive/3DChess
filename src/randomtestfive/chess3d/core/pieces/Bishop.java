package randomtestfive.chess3d.core.pieces;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Bishop extends Rider {
	public Bishop(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "Bishop", new Position3D(0,1,1));
	}
}
