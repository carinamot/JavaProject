package ex;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.ServerMessageController;
import Controller.UserController;
import ex.Service.CommunicationService;

public class ClientThread implements Runnable {

	private final Socket socket;
	private final ServerMessageController messageController;
	private final UserController userController;
	
	public ClientThread(Socket socket, UserController userController) {
		this.socket = socket;
		messageController = new ServerMessageController("Hello");
		this.userController = new UserController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(socket.getInputStream()),
				new DataOutputStream(socket.getOutputStream()))) {
			pipe.read();
			pipe.write(messageController.hello());
			
			String username = pipe.read();
			if(userController.login(username)) {
				
				pipe.write(messageController.loginResponse(username));
			}
			else {
				pipe.write(messageController.isAlreadyLoggedIn());
			}
			String username1 = pipe.read();
			if(userController.login(username)) {
				
				pipe.write(messageController.loginResponse(username1));
			}
			else {
				pipe.write(messageController.isAlreadyLoggedIn());
			}
			
			
			pipe.read();
			pipe.write(messageController.list());
			
			pipe.read();
			pipe.write(messageController.move());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
