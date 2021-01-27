package ex;

import java.net.*;

import ex.Model.*;

import java.io.*; 

public class Server 
{ 
	//initialize socket and input stream 
	private Socket socket;
	private ServerSocket server;
	private DataInputStream in;
	private ObjectOutputStream out;

	
	// creates a server and connects it to the given port 
	public Server(int port) 
	{ 
		// starts server and waits for a connection 
		try
		{ 
			// we start our server
			server = new ServerSocket(port); 
			System.out.println("Server started"); 

			System.out.println("Waiting for a client ..."); 

			// we accept the client in the given port
			// and create a socket
			// we now have an established connection between our client and our server on the 
			// given socket
			socket = server.accept(); 
			System.out.println("Client accepted!\nThe username is:"); 	
			
			// takes input from the client socket 
			in = new DataInputStream( 
				new BufferedInputStream(socket.getInputStream())); 

			String line = "";
			out = new ObjectOutputStream(socket.getOutputStream()); 

			// reads message from client until "Stop" is sent 
			while (!line.equals("Stop")) 
			{ 
				try
				{ 
					line = in.readUTF(); 
					System.out.println(line); 
					//System.out.println("Here is the game board:"); 	
					Board board = new Board();
					//Game game=new Game(board, player);
//					board.printBoard();
//					out.writeUTF("|lalalala");
					out.writeObject(board);
					String line1=in.readUTF();
					System.out.println(line1);
				} 
				catch(IOException i) 
				{ 
					System.out.println(i); 
				} 
			} 
			System.out.println("Closing connection"); 

			// close connection 
			socket.close(); 
			in.close(); 
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
