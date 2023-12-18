package cgg.net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class Receiver {

	public static void main(String[] args) {
		byte [] b=new byte[1024];
		DatagramPacket dp = new DatagramPacket(b,b.length);
		try {
			DatagramSocket ds = new DatagramSocket(4040);
			while(true) {
				ds.receive(dp);
				byte[] data = dp.getData();
				int n = dp.getLength();
				System.out.println(new String(data,0,n));
				b=new byte[1024];
				dp=new DatagramPacket(b,b.length);
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
