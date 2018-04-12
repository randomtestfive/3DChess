package randomtestfive.chess3d.graphics;

import java.util.Optional;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.pieces.ChessPiece;
import randomtestfive.chess3d.network.Chess3DClient;

public class Globals {
	private static Optional<ChessPiece> selection = Optional.empty();
	private static Player player;
	private static int turn = 1;
	private static Chess3DClient client;
	private static boolean ready = false;
	
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
	
	public static void setClient(Chess3DClient c) {
		client = c;
	}
	
	public static Chess3DClient getClient() {
		return client;
	}
	
	public static void ready() {
		ready = true;
	}
	
	public static void done() {
		ready = false;
	}
	
	public static boolean getReady() {
		return ready;
	}
}
