package ex;

//import Server.*;

import java.net.*;

import Controller.BoardController;
import Controller.ClientMessageController;
import Controller.CommandController;
import Controller.ViewController;
import ex.Model.Command.CommandType;
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
				
				BoardController boardController= new BoardController();
				
				Thread reader = new Thread(new ClientThread(socket, pipe, boardController));
				
				message.hello();
				console.write(pipe.read());
				
				message.login();
				console.write(pipe.read());
				
				reader.start();
				
				ViewController viewController=new ViewController();
				
				while(true) {
					String command = console.readLine("Command: ");
					CommandController commandController=new CommandController();
					String [] arr=commandController.decomposeCommand(command);
					CommandType commandType= commandController.verifyCommand(arr[0]);
					if(commandType==CommandType.MOVE)
					{
						boardController.move(Integer.parseInt(arr[1]));
						viewController.displayBoard(boardController.getBoard());
					} else {
						pipe.write(command);
					}
					
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
