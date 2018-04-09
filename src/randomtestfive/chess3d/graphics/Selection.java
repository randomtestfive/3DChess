package randomtestfive.chess3d.graphics;

import java.util.Optional;

import randomtestfive.chess3d.core.pieces.ChessPiece;

public class Selection {
	private static Optional<ChessPiece> selection = Optional.empty();
	
	public static void setSelection(ChessPiece s) {
		selection = Optional.ofNullable(s);
	}
	
	public static Optional<ChessPiece> getSelection() {
		return selection;
	}
}
