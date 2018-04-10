package randomtestfive.chess3d.core.pieces;

import randomtestfive.chess3d.core.Player;

public class Queen extends Hybrid {
	public Queen(int x, int y, int z, Player owner) {
		super(x, y, z, owner, "Queen",
			new Rook(x, y, z, owner),
			new Bishop(x, y, z, owner),
			new Unicorn(x, y, z, owner));
	}
}
