package janbask.training;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadWriteServer {
	public static void main(String args[]) throws Exception {
		System.out.println("[Server]->Starting Socket Server...");
		ServerSocket serverSocket = new ServerSocket(3333);
		System.out.println("[Server]->Socket Server started...\n[Server]->Waiting for connections...");
		Socket socketConnected = serverSocket.accept();
		System.out.println("[Server]->New connection request...\n[Server]->Accepted...\n[Server]->Type a message(type 'stop' to exit server): ");
		DataInputStream dataInput = new DataInputStream(socketConnected.getInputStream());
		DataOutputStream dataOutput = new DataOutputStream(socketConnected.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String stringInput = "", strOutput = "";
		while (!stringInput.equals("stop")) {
			stringInput = dataInput.readUTF();
			System.out.println("[Server]->client says: " + stringInput);
			strOutput = bufferedReader.readLine();
			dataOutput.writeUTF(strOutput);
			dataOutput.flush();
		}
		System.out.println("[Server]->Close command received...\nClosing: ");
		dataInput.close();
		socketConnected.close();
		serverSocket.close();
		System.out.println("[Server]->Closed...");
	}
}
