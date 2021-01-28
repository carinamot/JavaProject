package Controller;

import java.io.*;
import java.util.*;
import ex.Model.Command.*;
import ex.Model.Command.GameOver.GameOverCommand;
import ex.Service.*;

public class ServerMessageController {

	private final UserController userController;
	private final CommunicationService pipe;
	private final static String description="Hi";


	public ServerMessageController(CommunicationService pipe, UserController userController) {
		this.pipe=pipe;
		this.userController= userController;
		
	}

	public void hello() throws IOException {
		pipe.write(new HelloCommand(description, null).toString());
	}


	public void login() throws IOException {
		pipe.write(new LoginCommand().toString());
	}

	public void alreadyLoggedIn() throws IOException {
		pipe.write(new AlreadyLoggedInCommand().toString());
	}

	public void list(List<String> usernames) throws IOException {
		pipe.write(new ListCommand(usernames).toString());
	}

//	public void newgame() throws IOException {
//		pipe.write(new NewGameCommand().);
//	}

	public void move(Integer moveNumber) throws IOException{
		pipe.write(new MoveCommand(Collections.singletonList(moveNumber)).toString());
	}

	public void gameover() throws IOException {
		pipe.write(new GameOverCommand(null,null).toString());
	}
	
	
}
