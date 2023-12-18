package cgg.net;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.cgg.gov.in:80/index.html");
			System.out.println("Protocol : "+url.getProtocol());
			System.out.println("Host     : "+url.getHost());
			System.out.println("File     : "+url.getFile());
			System.out.println("Port     : "+url.getPort());
			System.out.println("Path     : "+url.getPath());
			System.out.println("External Form    : "+url.toExternalForm());
			
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

	}

}
