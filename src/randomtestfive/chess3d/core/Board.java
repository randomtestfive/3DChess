package randomtestfive.chess3d.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import randomtestfive.chess3d.core.piece.ChessPiece;

public class Board {
	private final List<ChessPiece> pieces;
	
	public Board() {
		pieces = new ArrayList<ChessPiece>();
	}
	
	public List<ChessPiece> getPieces() { return pieces; }
	
	public List<ChessPiece> onSubBoard(int i) {
		return pieces.stream()
				.filter((p)->p.getPosition().getZ()==i)
				.collect(Collectors.toList());
	}
	
	public String subBoardToString(int i) {
		StringBuilder out = new StringBuilder();
		List<ChessPiece> sub = onSubBoard(i);
		int[] pos = new int[]{0,4};
		while(pos[1]>=0) {
			while(pos[0]<5) {
				out.append(sub.stream()
						.filter((p)->p.getPosition().getX()==pos[1]&&p.getPosition().getY()==pos[0])
						.map((p)->p.getPieceName().substring(0, 1))
						.findFirst()
						.orElse("*"));
				pos[0]++;
			}
			pos[1]--;
			pos[0]=0;
			out.append("\n");
		}
		return out.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		for(int i = 4; i >= 0; i--) {
			out.append(i+"\n"+subBoardToString(i)+"\n");
		}
		return out.toString();
	}
}