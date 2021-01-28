package ex;

//import Server.*;

import java.net.*;

import Controller.ClientMessageController;
import ex.Service.CommunicationService;
import ex.Service.ConsoleService;

import java.io.*; 

public class Client 
{
	// constructor that takes the IP Address and the Port
	public Client(String address, int port) 
	{ 
		try (Socket socket = new Socket(address, port)) {
			try (CommunicationService pipe = new CommunicationService(
					new DataInputStream(socket.getInputStream()),
					new DataOutputStream(socket.getOutputStream()))) {
				ClientMessageController message = new ClientMessageController(pipe);
				ConsoleService console = new ConsoleService();
				
				Thread reader = new Thread(new ClientThread(socket, pipe));
				
				message.hello();
				console.write(pipe.read());
				
				message.login();
				console.write(pipe.read());
				
				reader.start();
				
				while(true) {
					String command = console.readLine("Command: ");
					pipe.write(command);
				}
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 6666); 
	} 
} 
