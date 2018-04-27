package janbask.training;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class DatagramReceiver {
	public static void main(String[] args) throws Exception {  
		System.out.println("[Receiver]->starting on port 3000...");
	    DatagramSocket datagramSocket = new DatagramSocket(3000); 
	    System.out.println("[Receiver]->started on port 3000...");
	    byte[] buffer = new byte[1024];  
	    DatagramPacket datagramPacket = new DatagramPacket(buffer, 1024); 
	    System.out.println("[Receiver]->waiting for packet...");
	    datagramSocket.receive(datagramPacket);  
	    System.out.println("[Receiver]->packet received...\nSize: " + datagramPacket.getLength());
	    String broadcastedString = new String(datagramPacket.getData(), 0, datagramPacket.getLength());  
	    System.out.println("[Receiver]->packet data: " + broadcastedString);  
	    datagramSocket.close();  
	    System.out.println("[Receiver]->closed...");
	  }  
}
