package janbask.training;

import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;

public class URLConnectionDemo {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://raw.githubusercontent.com/pradeep-pioneer/JanbaskTraining-Java.Sockets/master/LICENSE");
			URLConnection urlconnection = url.openConnection();
			InputStream inputStream = urlconnection.getInputStream();
			int bytesRead;
			while ((bytesRead = inputStream.read()) != -1) {
				System.out.print((char) bytesRead);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
