package janbask.training;

import java.net.InetAddress;

public class InetAddressDemo {
	public static void main(String[] args) {
		try {
			//ToDo: test all available static methods
			System.out.println("Static Methods");
			System.out.println("Loopback Address: " + InetAddress.getLoopbackAddress());
			
			//ToDo: Test all available instance methods
			System.out.println("Instance Methods");
			InetAddress inetAddress = InetAddress.getByName("github.com");
			System.out.println("Host Name: " + inetAddress.getHostName());
			System.out.println("IP Address: " + inetAddress.getHostAddress());
			byte[] bytes = inetAddress.getAddress();
			System.out.print("Raw address (bytes): ");
			for (byte b : bytes) {
				System.out.print(getUnsignedByte(b) + ".");
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static int getUnsignedByte(byte b) {
		return b & 0xFF;
	}
}
