package ex;

import java.net.*;

import Controller.ServerMessageController;
import ex.Model.*;

import java.io.*; 

public class Server 
{ 
	//initialize socket and input stream 
	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;
	private DataOutputStream out;

	
	// creates a server and connects it to the given port 
	public Server(int port) 
	{ 
		
		ServerMessageController message = new ServerMessageController("sad");
		// starts server and waits for a connection 
		try
		{ 
			// we start our server
			server = new ServerSocket(port);

			// we accept the client in the given port
			// and create a socket
			// we now have an established connection between our client and our server on the 
			// given socket
			socket = server.accept();
			
			// takes input from the client socket 
			in = new DataInputStream(socket.getInputStream()); 

			out = new DataOutputStream(socket.getOutputStream()); 
			
			String hello = in.readUTF();
			System.out.println(hello);
			
			out.writeUTF(message.hello());
			out.flush();
			
			String login = in.readUTF();
			System.out.println(login);
			
			out.writeUTF(message.loginResponse(login));
			out.flush();
			
			
			String list = in.readUTF();
			System.out.println(list);

			out.writeUTF(message.list());
			
			String move=in.readUTF();
			System.out.println(move);
			
			out.writeUTF(message.move());
			
			// reads message from client until "Stop" is sent 
			while (true) 
			{ 
			}

			// close connection 
//			socket.close(); 
//			in.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Server server = new Server(6666); 
	} 
} 
