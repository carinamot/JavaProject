package ex;

//import Server.*;

import java.net.*;

import Controller.ClientMessageController;
import ex.Model.Board;
import ex.Service.CommunicationService;

import java.io.*; 

public class Client 
{
	// constructor that takes the IP Address and the Port
	public Client(String address, int port) 
	{ 
		ClientMessageController message = new ClientMessageController("asd");
		
<<<<<<< HEAD
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
=======
		try (Socket socket = new Socket(address, port)) {
			try (CommunicationService pipe = new CommunicationService(
					new DataInputStream(socket.getInputStream()),
					new DataOutputStream(socket.getOutputStream()))) {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

				pipe.write(message.hello());
				
				String hello = pipe.read();
				System.out.println(hello);
				
				String username = input.readLine();
				pipe.write(message.loginRequest(username));
				
				String loginConfirmed = pipe.read();
				System.out.println(loginConfirmed);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
>>>>>>> 742458c (threads)
	} 

	public static void main(String args[]) 
	{ 
		Client client = new Client("127.0.0.1", 6666); 
	} 
} 
