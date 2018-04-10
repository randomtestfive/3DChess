package randomtestfive.chess3d.graphics;

import java.util.Optional;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.pieces.ChessPiece;

public class Globals {
	private static Optional<ChessPiece> selection = Optional.empty();
	private static Player player;
	private static int turn = 0;
	
	public static void setSelection(ChessPiece s) {
		selection = Optional.ofNullable(s);
	}
	
	public static Optional<ChessPiece> getSelection() {
		return selection;
	}
	
	public static void setPlayer(Player p) {
		player = p;
	}
	
	public static Player getPlayer() {
		return player;
	}
	
	public static void nextTurn() {
		turn++;
	}
	
	public static int getTurn() {
		return turn;
	}
}
