package ex;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.ClientMessageController;
import ex.Model.Player;
import ex.Service.CommunicationService;
import ex.Service.ConsoleService;

public class ClientThread implements Runnable {

	private final Player player;
	private final ClientMessageController messageController;
	private final ConsoleService console;
	
	public ClientThread(Socket socket, CommunicationService pipe) {
		player = new Player(socket);
		messageController = new ClientMessageController(pipe);
		console = new ConsoleService();
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
	}

}
