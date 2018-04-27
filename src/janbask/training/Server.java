package janbask.training;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args){  
		try{
			System.out.println("[Server]->Starting Socket Server...");
			ServerSocket serverSocket=new ServerSocket(6666);
			System.out.println("[Server]->Socket Server started...\n[Server]->Waiting for connections...");
			Socket s=serverSocket.accept();//establishes connection
			System.out.println("[Server]->New connection request...\n[Server]->Accepted...\n[Server]->Waiting for data...");
			DataInputStream dataInputStream=new DataInputStream(s.getInputStream());
			String  data = (String)dataInputStream.readUTF();
			System.out.println("[Server]->Message Received: " + data);
			serverSocket.close();
			System.out.println("[Server]->Server stopped");
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
