package ex;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import Controller.ServerMessageController;
import ex.Service.CommunicationService;

public class ClientThread implements Runnable {

	private final Socket socket;
	private final ServerMessageController messageController;
	
	public ClientThread(Socket socket) {
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
			
			String username = pipe.read();
			pipe.write(messageController.loginResponse(username));
			
			pipe.read();
			pipe.write(messageController.list());
			
			pipe.read();
			pipe.write(messageController.move());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
