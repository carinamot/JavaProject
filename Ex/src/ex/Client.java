package ex;

//import Server.*;

import java.net.*;

import Controller.ClientMessageController;
import ex.Model.Board;

import java.io.*; 

public class Client 
{ 
	// We initialize our socket( tunnel )
	// and our input reader and output stream
	// we will take the input from the user
	// and send it to the socket using output stream
	private Socket socket;
	private BufferedReader input;
	private DataOutputStream out;
	private DataInputStream in;

	// constructor that takes the IP Address and the Port
	public Client(String address, int port) 
	{ 
		ClientMessageController message = new ClientMessageController("asd");
		
		// we try to establish a connection 
		try
		{ 
			// creates a socket with the given information
			socket = new Socket(address, port); 

			// we 'ready' the input reader 
			input = new BufferedReader(new InputStreamReader(System.in));

			// and the output that is connected to the Socket
			out = new DataOutputStream(socket.getOutputStream()); 
			in = new DataInputStream(socket.getInputStream()); 
			
			out.writeUTF(message.hello());
			out.flush();
			
			String hello = in.readUTF();
			System.out.println(hello);
			
			String username = input.readLine();
			out.writeUTF(message.loginRequest(username));
			out.flush();
			
			String loginConfirmed = in.readUTF();
			System.out.println(loginConfirmed);
			
			out.writeUTF(message.list());
			out.flush();
			
			String list =in.readUTF();
			System.out.println(list);
			
			
			out.writeUTF(message.move());
			out.flush();
			
			String move=in.readUTF();
			System.out.println(move);
			
			

		} 
		catch(UnknownHostException u) 
		{ 
			System.out.println(u); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i.getMessage()); 
		} 

		// close the connection 
		try
		{ 
			input.close(); 
			out.close(); 
			socket.close(); 
		} 
		catch(IOException i) 
		{ 
			System.out.println(i); 
		} 
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 6666); 
	} 
} 
