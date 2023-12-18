package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Sender {

	public static void main(String[] args) {
		try {
			
			InetAddress destHost = InetAddress.getLocalHost();
			int destPort=4040;
			DatagramSocket socket = new DatagramSocket();
			
			BufferedReader br = 
			new BufferedReader(new InputStreamReader(System.in));
			String s = br.readLine();
			
			while(true) {
				byte[] b = s.getBytes();
				DatagramPacket dp = 
				new DatagramPacket(b,b.length,destHost,destPort);
				socket.send(dp);
				s=br.readLine();
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
