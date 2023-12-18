package cgg.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;

public class Address {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter a website name");
		try {
			String site = br.readLine();
			InetAddress ip = InetAddress.getByName(site);
			System.out.println("IP address of "+site+" is "+ip);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
