package janbask.training;

import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args) {  
		try{
			System.out.println("[Client]->Starting Socket client...\n[Client]->Trying to connect to server...");
			Socket clientSocket=new Socket("localhost",6666);
			System.out.println("[Client]->Connected to Server...\n[Client]->Sending message");
			DataOutputStream dataOutputStream=new DataOutputStream(clientSocket.getOutputStream());  
			dataOutputStream.writeUTF("Hello Server");
			dataOutputStream.flush();  
			System.out.println("[Client]->Message Sent...\n[Client]->Closing connection...");
			dataOutputStream.close();  
			clientSocket.close();
			System.out.println("[Client]->Stopped Socket client...");
		}
		catch(Exception e)
			{System.out.println(e);
		}  
	}
}
