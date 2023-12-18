package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyClient {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",1111);
			
			OutputStream os = s.getOutputStream();
			InputStream is = s.getInputStream();
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintStream ps = new PrintStream(os);
			
			System.out.println("server :"+br.readLine());
			
			BufferedReader kb = 
			new BufferedReader(new InputStreamReader(System.in));
			String content = kb.readLine();
			ps.println(content);
			ps.flush();
			
			s.close();
			ps.close();
			br.close();
			kb.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
