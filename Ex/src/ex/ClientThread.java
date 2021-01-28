package ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import Controller.*;
import ex.Model.Player;
import ex.Model.Command.CommandType;
import ex.Service.CommunicationService;
import ex.Service.ConsoleService;

public class ClientThread implements Runnable {

	private final Player player;
	private final ClientMessageController messageController;
	private final ConsoleService console;
	private final CommandController commandController;
	private final ViewController viewController;
	
	public ClientThread(Socket socket, CommunicationService pipe) {
		player = new Player(socket);
		messageController = new ClientMessageController(pipe);
		console = new ConsoleService();
		commandController= new CommandController();
		viewController = new ViewController();
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(player.getSocket().getInputStream()),
				new DataOutputStream(player.getSocket().getOutputStream()))) {
			while(true) {
				String command = pipe.read();
				onCommandGot(command);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void onCommandGot(String command) throws IOException {
		console.write(command);
		String[] parts = commandController.decomposeCommand(command);
		CommandType commandType = commandController.verifyCommand(parts[0]);
		
		switch (commandType) {
			case LIST:
				viewController.displayList(command);
				break;
			case NEWGAME:
				viewController.displayBoard(command);
				break;
			
		}

	}

}
