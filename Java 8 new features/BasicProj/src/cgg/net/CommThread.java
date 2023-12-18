package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class CommThread  extends Thread{
	
	Socket s;

	public CommThread(Socket s) {
		super();
		System.out.println("Thread Constrcutor");
		this.s = s;
		this.start();
	}
	@Override
	public void run() {
		System.out.println("Thread started...");
		try {
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintStream ps = new PrintStream(os);
			
			System.out.println("server is writing");
			ps.println("welcome");
			
			System.out.println("server is reading");
			String msg =br.readLine();
			System.out.println("client :"+msg);
			
			ps.flush();
			s.close();
			ps.close();
			br.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	

}
