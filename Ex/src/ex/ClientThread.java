package ex;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.CommandController;
import Controller.ServerMessageController;
import Controller.UserController;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;

public class ClientThread implements Runnable {

	private final Socket socket;
	private final ServerMessageController messageController;
	private final UserController userController;
	private final CommandController commandController;
	
	public ClientThread(Socket socket, UserController userController) {
		this.socket = socket;
		messageController = new ServerMessageController("Hello");
		this.userController = userController;
		commandController = new CommandController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(socket.getInputStream()),
				new DataOutputStream(socket.getOutputStream()))) {
			pipe.read();
			pipe.write(messageController.hello());
			
			while(true) {
				String command = pipe.read();
				String[] parts = commandController.decomposeCommand(command);
				CommandType commandType = commandController.verifyCommand(parts[0]);
				
				switch(commandType) {
				case LOGIN:
					String username = parts[1];
					if(userController.login(username)) {
						pipe.write(messageController.loginResponse(username));
					}
					else {
						pipe.write(messageController.isAlreadyLoggedIn());
					}
					break;
				default:
					pipe.write(messageController.move());
				}
				pipe.read();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
