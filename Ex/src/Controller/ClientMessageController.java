package Controller;

import java.io.IOException;
import java.util.Collections;

import ex.Model.Command.*;
import ex.Service.*;


public class ClientMessageController {
	
	private final static String description = "Hi, I am Bob";
	private final CommunicationService pipe;
	private final ConsoleService console;
	
	public ClientMessageController(CommunicationService pipe) {
		this.pipe = pipe;
		console = new ConsoleService();
	}
	
	public void login() throws IOException {
		String username = console.readLine("Username: ");
		pipe.write(new LoginCommand(username).toString());
	}

	public void hello() throws IOException {
		pipe.write(new HelloCommand(description, null).toString());
	}
	
	public void list() throws IOException {
		pipe.write(new ListCommand().toString());
	}
	
	public void queue() throws IOException {
		pipe.write(new QueueCommand().toString());
	}
	
	public void move(Integer moveNumber) throws IOException {
		pipe.write(new MoveCommand(Collections.singletonList(moveNumber)).toString());
	}
	
}
