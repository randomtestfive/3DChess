package randomtestfive.chess3d.core.pieces;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;

public class Unicorn extends Rider {

	public Unicorn(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "Unicorn", new Position3D(1,1,1));
	}
}
