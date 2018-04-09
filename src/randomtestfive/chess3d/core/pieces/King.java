package randomtestfive.chess3d.core.pieces;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class King extends Hybrid {
	public King(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "King",
				new Leaper(x, y, z, owner, "kingleap1", new Position3D(0,0,1)),
				new Leaper(x, y, z, owner, "kingleap2", new Position3D(0,1,1)),
				new Leaper(x, y, z, owner, "kingleap3", new Position3D(1,1,1)));
	}
}
