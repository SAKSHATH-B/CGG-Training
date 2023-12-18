package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerOne {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(888);
			Socket s = ss.accept();
			System.out.println("connection established");
			
			//server sends data to the client
			OutputStream os = s.getOutputStream();
			PrintStream ps = new PrintStream(os);
			
			//server reads data send by client
			InputStream is = s.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			//read from keyboard data to be send client
			BufferedReader brkb = 
			new BufferedReader(new InputStreamReader(System.in));
			
			while(true) {
				String str,str1;
				
				while((str=br.readLine())!=null)//read the data send by client
				{
					System.out.println("From Client :"+str);
					
					str1=brkb.readLine();//send data to client
					ps.println(str1);
				}
				
				ss.close();
				s.close();
				ps.close();
				br.close();
				brkb.close();
				System.exit(0);//terminate the server
			}
	
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
