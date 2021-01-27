package Controller;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import ex.Service.CommunicationService;

public class CommunicationController implements Runnable {

	private final Socket socket;
	private final ServerMessageController messageController;
	
	public CommunicationController(Socket socket) {
		this.socket = socket;
		messageController = new ServerMessageController("Hello");
	}

	@Override
	public void run() {
		try (CommunicationService pipe = new CommunicationService(
				new DataInputStream(socket.getInputStream()),
				new DataOutputStream(socket.getOutputStream()))) {
			pipe.read();
			pipe.write(messageController.hello());
			
			pipe.read();
			pipe.write(messageController.loginResponse());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
