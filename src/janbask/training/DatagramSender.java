package janbask.training;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DatagramSender {
	public static void main(String[] args) throws Exception {
		System.out.println("[Sender]->starting...");
		DatagramSocket datagramSocket = new DatagramSocket();
		System.out.println("[Sender]->started...");
		String broadcastString = "Welcome students, it's a great way to fire and forget";
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		System.out.println("[Sender]->broadcasting on port 3000 for localhost(127.0.0.1)...");
		DatagramPacket datagramPacket = new DatagramPacket(broadcastString.getBytes(), broadcastString.length(), ip, 3000);
		datagramSocket.send(datagramPacket);
		System.out.println("[Sender]->sent on port 3000...\nSize: " + datagramPacket.getLength());
		datagramSocket.close();
		System.out.println("[Sender]->closed...");
	}
}
