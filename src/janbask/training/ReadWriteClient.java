package janbask.training;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadWriteClient {
	public static void main(String args[]) throws Exception {
		System.out.println("[Client]->Starting Socket client...\n[Client]->Trying to connect to server...");
		Socket socketConnected = new Socket("localhost", 3333);
		System.out.println("[Client]->Connected to Server...\n[Client]->Type a message(type 'stop' to exit client): ");
		DataInputStream dataInput = new DataInputStream(socketConnected.getInputStream());
		DataOutputStream dataOutput = new DataOutputStream(socketConnected.getOutputStream());
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String stringInput = "", strOutput = "";
		while (!stringInput.equals("stop")) {
			stringInput = bufferedReader.readLine();
			dataOutput.writeUTF(stringInput);
			dataOutput.flush();
			strOutput = dataInput.readUTF();
			System.out.println("[Client]->Server says: " + strOutput);
		}

		dataOutput.close();
		socketConnected.close();
	}
}
