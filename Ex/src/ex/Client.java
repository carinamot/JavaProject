package ex;

//import Server.*;

import java.net.*;

import Controller.ClientMessageController;
import Controller.CommandController;
import ex.Model.Board;
import ex.Model.Command.Command;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;

import java.io.*; 

public class Client 
{
	// constructor that takes the IP Address and the Port
	public Client(String address, int port) 
	{ 
		CommandController commandController= new CommandController();
	
		ClientMessageController message = new ClientMessageController("asd");

		try (Socket socket = new Socket(address, port)) {
			try (CommunicationService pipe = new CommunicationService(
					new DataInputStream(socket.getInputStream()),
					new DataOutputStream(socket.getOutputStream()))) {
				BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

				pipe.write(message.hello());

				String hello = pipe.read();
				System.out.println(hello);
				
				while(true) {
					String command=input.readLine();
					String[] parts= commandController.decomposeCommand(command);
					CommandType commandType = commandController.verifyCommand(parts[0]);
					String response;
					switch(commandType) {
					case LOGIN:
						String username = parts[1];
						pipe.write(message.loginRequest(username));
						response=pipe.read();
						System.out.println(response);
						break;
						
					case LIST:
						pipe.write(message.list());
						response=pipe.read();
						System.out.println(response);
						break;
						
					case MOVE:
						pipe.write(message.move(parts[1]));
						response=pipe.read();
						System.out.println(response);
						break;
					
					case QUEUE:
						
										
					}
					
					
				}

//				String username = input.readLine();
//				pipe.write(message.loginRequest(username));
//
//				String loginConfirmed = pipe.read();
//				System.out.println(loginConfirmed);

//				pipe.write(message.loginRequest(username));
//
//				String loginConfirmed2 = pipe.read();
//				System.out.println(loginConfirmed2);
//
//
//				pipe.write(message.list());
//
//				String list= pipe.read();
//				System.out.println(list);
//
//				pipe.write(message.move());
//
//				String move=pipe.read();
//				System.out.println(move);

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
