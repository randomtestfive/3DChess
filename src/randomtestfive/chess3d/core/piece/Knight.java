package randomtestfive.chess3d.core.piece;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Knight extends Leaper {
	public Knight(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "Knight", new Position3D(0,1,2));
	}
}
