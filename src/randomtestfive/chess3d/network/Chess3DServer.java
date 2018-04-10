package randomtestfive.chess3d.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Chess3DServer {
	
	public Chess3DServer() {
		new Thread(new ServerThread()).start();;
	}
	
	public static class ServerThread implements Runnable {
		private ServerSocket serverSocket;
		
		public ServerThread() {
			try {
				serverSocket = new ServerSocket(20202);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			Socket ps1, ps2;
			PrintWriter pw1, pw2;
			BufferedReader pi1, pi2;
			try {
				ps1 = serverSocket.accept();
				pw1 = new PrintWriter(ps1.getOutputStream(), true);
				pi1 = new BufferedReader(new InputStreamReader(ps1.getInputStream()));
				pw1.println("p1");
				ps2 = serverSocket.accept();
				pw2 = new PrintWriter(ps2.getOutputStream(), true);
				pi2 = new BufferedReader(new InputStreamReader(ps2.getInputStream()));
				pw2.println("p0");
				int turn = 0;
				while(true) {
					if(turn%2==0) {
						if(pi1.ready()) {
							System.out.println("[SERVER]: "+pi1.readLine());
							turn++;
						}
					}
					Thread.yield();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		    
		}
		
	}
}
