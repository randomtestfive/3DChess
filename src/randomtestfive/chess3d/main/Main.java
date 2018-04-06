package randomtestfive.chess3d.main;

import java.util.List;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.piece.*;
import randomtestfive.chess3d.graphics.MainDisplay;

public class Main {
	public static void main(String[] args) {
		
		Board b = new Board();
		List<ChessPiece> p = b.getPieces();
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
		new MainDisplay(b);
//		//b.getPieces().add(new Pawn(4,3,3,Player.WHITE));
//		System.out.println(b);
//		System.out.println(test);
//		test.getPossibleMoves(b.getPieces()).forEach(System.out::println);
	}
}
