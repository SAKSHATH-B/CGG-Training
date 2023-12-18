package cgg.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(1111);
			while(true) {
			Socket s = ss.accept();
			System.out.println("connection established...");
			new CommThread(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
