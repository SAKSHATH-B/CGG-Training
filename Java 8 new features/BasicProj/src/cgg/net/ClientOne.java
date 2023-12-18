package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class ClientOne {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost",888);
			
			//send data to server
			OutputStream os = s.getOutputStream();
			PrintStream ps = new PrintStream(os);
			
			//read data from server
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//read from keyboard to send to server
			BufferedReader kb = new BufferedReader(new InputStreamReader(System.in));
			
			String str,str1;
			
			while(!(str=kb.readLine()).equals("exit")) {
				ps.println(str);//send data to server
				str1=br.readLine();//read data from server
				System.out.println("From server :"+str1);
				
			}
			
			s.close();
			ps.close();
			br.close();
			kb.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
