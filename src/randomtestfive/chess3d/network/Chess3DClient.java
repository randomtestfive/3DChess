package randomtestfive.chess3d.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.function.Consumer;

import randomtestfive.chess3d.core.Board;
import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;
import randomtestfive.chess3d.graphics.Globals;

public class Chess3DClient {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	
	public Chess3DClient(String ip, Board b, Runnable c) {
		try {
			socket = new Socket(ip, 20202);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Globals.setPlayer(Player.values()[Integer.parseInt(in.readLine().substring(1))]);
			Globals.setClient(this);
			new Thread(new ClientThread(out, in, b, c)).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static class ClientThread implements Runnable {
		private PrintWriter out;
		private BufferedReader in;
		private Board board;
		private Runnable callback;

		public ClientThread(PrintWriter o, BufferedReader i, Board b, Runnable c) {
			out = o;
			in = i;
			board = b;
			callback = c;
		}

		@Override
		public void run() {
			try {
				in.readLine();
				Globals.ready();
				while(true) {
					if(in.ready()) {
						String m = in.readLine();
						Position3D s = new Position3D(m.substring(0, 3));
						Position3D e = new Position3D(m.substring(5, 8));
						board.getPieces().stream()
							.filter(p->p.getPosition().equals(s))
							.findFirst().ifPresent(p->p.moveTo(e, board.getPieces()));
						Globals.nextTurn();
						callback.run();
					}
					Thread.yield();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public void commitMove(Position3D s, Position3D e) {
		out.println(s.toString()+"->"+e.toString());
	}
}
