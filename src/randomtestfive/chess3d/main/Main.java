package randomtestfive.chess3d.main;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.piece.*;
import randomtestfive.chess3d.graphics.MainDisplay;

public class Main {
	public static void main(String[] args) {
		
		Board b = new Board();
		Knight test = new Knight(1,2,2,Player.BLACK);
		b.getPieces().add(test);
		MainDisplay md = new MainDisplay(b);
//		//b.getPieces().add(new Pawn(4,3,3,Player.WHITE));
//		System.out.println(b);
//		System.out.println(test);
//		test.getPossibleMoves(b.getPieces()).forEach(System.out::println);
	}
}
