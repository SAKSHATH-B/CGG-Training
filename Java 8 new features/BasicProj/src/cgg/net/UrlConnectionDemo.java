package cgg.net;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

public class UrlConnectionDemo {

	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.google.com/index.html");
			URLConnection conn = url.openConnection();
			System.out.println("Date : "+new Date(conn.getDate()));
			System.out.println("Content type :"+conn.getContentType());
			System.out.println("Last Modified Date :"+new Date(conn.getLastModified()));
			System.out.println("Size of page  : "+conn.getContentLength()+" bytes");
			InputStream is = conn.getInputStream();
			int ch;
			while((ch = is.read())!=-1) {
				System.out.write(ch);
			}
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
