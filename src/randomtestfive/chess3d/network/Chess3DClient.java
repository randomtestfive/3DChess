package randomtestfive.chess3d.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import randomtestfive.chess3d.core.Player;
import randomtestfive.chess3d.core.Position3D;
import randomtestfive.chess3d.graphics.Globals;

public class Chess3DClient {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	
	public Chess3DClient(String ip) {
		try {
			socket = new Socket(ip, 20202);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			Globals.setPlayer(Player.values()[Integer.parseInt(in.readLine().substring(1))]);
			System.out.println(Globals.getPlayer());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void commitMove(Position3D s, Position3D e) {
		out.println(s.toString()+"->"+e.toString());
	}
}
