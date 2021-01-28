package ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.CommandController;
import Controller.ServerMessageController;
import Controller.UserController;
import ex.Model.Player;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;

public class ServerThread implements Runnable {

	private final Player player;
	private final ServerMessageController messageController;
	private final UserController userController;
	private final CommandController commandController;
	
	public ServerThread(Socket socket, UserController userController) {
		player = new Player(socket);
		messageController = new ServerMessageController("Hello");
		this.userController = userController;
		commandController = new CommandController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(player.getSocket().getInputStream()),
				new DataOutputStream(player.getSocket().getOutputStream()))) {
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
						player.setName(username);
						pipe.write(messageController.loginResponse(username));
					}
					else {
						pipe.write(messageController.isAlreadyLoggedIn());
					}
					break;
				case LIST:
					pipe.write(messageController.list(userController.getUsers()));
					break;
				case QUEUE:
					
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
