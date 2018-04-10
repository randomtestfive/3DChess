package randomtestfive.chess3d.core;

import java.util.HashSet;
import java.util.Set;

import randomtestfive.chess3d.core.pieces.Bishop;
import randomtestfive.chess3d.core.pieces.ChessPiece;
import randomtestfive.chess3d.core.pieces.King;
import randomtestfive.chess3d.core.pieces.Knight;
import randomtestfive.chess3d.core.pieces.Pawn;
import randomtestfive.chess3d.core.pieces.Queen;
import randomtestfive.chess3d.core.pieces.Rook;
import randomtestfive.chess3d.core.pieces.Unicorn;

public class StartPieces {
	public static Set<ChessPiece> getStartPieces() {
		Set<ChessPiece> p = new HashSet<>();
		p.add(new Pawn(0, 1, 0, Player.WHITE));
		p.add(new Pawn(1, 1, 0, Player.WHITE));
		p.add(new Pawn(2, 1, 0, Player.WHITE));
		p.add(new Pawn(3, 1, 0, Player.WHITE));
		p.add(new Pawn(4, 1, 0, Player.WHITE));
		p.add(new Pawn(0, 1, 1, Player.WHITE));
		p.add(new Pawn(1, 1, 1, Player.WHITE));
		p.add(new Pawn(2, 1, 1, Player.WHITE));
		p.add(new Pawn(3, 1, 1, Player.WHITE));
		p.add(new Pawn(4, 1, 1, Player.WHITE));
		p.add(new Pawn(0, 3, 4, Player.BLACK));
		p.add(new Pawn(1, 3, 4, Player.BLACK));
		p.add(new Pawn(2, 3, 4, Player.BLACK));
		p.add(new Pawn(3, 3, 4, Player.BLACK));
		p.add(new Pawn(4, 3, 4, Player.BLACK));
		p.add(new Pawn(0, 3, 3, Player.BLACK));
		p.add(new Pawn(1, 3, 3, Player.BLACK));
		p.add(new Pawn(2, 3, 3, Player.BLACK));
		p.add(new Pawn(3, 3, 3, Player.BLACK));
		p.add(new Pawn(4, 3, 3, Player.BLACK));
		p.add(new Knight(1, 0, 0, Player.WHITE));
		p.add(new Knight(3, 0, 0, Player.WHITE));
		p.add(new Knight(1, 4, 4, Player.BLACK));
		p.add(new Knight(3, 4, 4, Player.BLACK));
		p.add(new King(2, 0, 0, Player.WHITE));
		p.add(new King(2, 4, 4, Player.BLACK));
		p.add(new Rook(0, 0, 0, Player.WHITE));
		p.add(new Rook(4, 0, 0, Player.WHITE));
		p.add(new Rook(0, 4, 4, Player.BLACK));
		p.add(new Rook(4, 4, 4, Player.BLACK));
		p.add(new Bishop(0, 0, 1, Player.WHITE));
		p.add(new Bishop(3, 0, 1, Player.WHITE));
		p.add(new Bishop(1, 4, 3, Player.BLACK));
		p.add(new Bishop(4, 4, 3, Player.BLACK));
		p.add(new Unicorn(1, 0, 1, Player.WHITE));
		p.add(new Unicorn(4, 0, 1, Player.WHITE));
		p.add(new Unicorn(0, 4, 3, Player.BLACK));
		p.add(new Unicorn(3, 4, 3, Player.BLACK));
		p.add(new Queen(2, 0, 1, Player.WHITE));
		p.add(new Queen(2, 4, 3, Player.BLACK));
		return p;
	}
}
