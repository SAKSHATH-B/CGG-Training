package cgg.net;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(777);
			Socket s = ss.accept();
			System.out.println("Connection extablished..");
			
			OutputStream os = s.getOutputStream();
			PrintStream ps = new PrintStream(os);
			
			ps.println("Hello Client");
			ps.println("Bye");
			
			ss.close();
			s.close();
			ps.close();
		
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
