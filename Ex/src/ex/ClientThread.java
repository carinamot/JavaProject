package ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.ClientMessageController;
import Controller.CommandController;
import ex.Model.Player;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;

public class ClientThread implements Runnable {

	private final Player player;
	private final CommandController commandController;
	private final ClientMessageController messageController;
	
	public ClientThread(Socket socket, CommunicationService pipe) {
		player = new Player(socket);
		commandController = new CommandController();
		messageController = new ClientMessageController(pipe);
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(player.getSocket().getInputStream()),
				new DataOutputStream(player.getSocket().getOutputStream()))) {
			while(true) {
				String command = pipe.read();
				onCommandGot(command, pipe);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void onCommandGot(String command, CommunicationService pipe) throws IOException {
		System.out.println(command);
		String[] parts = commandController.decomposeCommand(command);
		CommandType commandType = commandController.verifyCommand(parts[0]);
		if (commandType == CommandType.HELLO) {
			messageController.login();
		}
	}

}
