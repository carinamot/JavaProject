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
	private ServerMessageController messageController;
	private final UserController userController;
	private final CommandController commandController;

	public ServerThread(Socket socket, UserController userController) {
		player = new Player(socket);
		this.userController = userController;
		commandController = new CommandController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(player.getSocket().getInputStream()),
				new DataOutputStream(player.getSocket().getOutputStream()))) {
			messageController= new ServerMessageController(pipe,userController);
			pipe.read();
			messageController.hello();

			while(true) {
				String command = pipe.read();
				String[] parts = commandController.decomposeCommand(command);
				CommandType commandType = commandController.verifyCommand(parts[0]);
				switch(commandType) {
				case LOGIN:
					messageController.loginResponse(parts[1]);
					break;
				case LIST:
					messageController.list();
					break;
				case QUEUE:

				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
