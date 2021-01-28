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


	public void loginResponse(String username) throws IOException {
//		String username = parts[1];
		if(userController.login(username)) {
//			player.setName(username);
			pipe.write(new LoginCommand(username).toString());
		}
		else {
			pipe.write(new AlreadyLoggedInCommand().toString());
		}
		pipe.write(new LoginCommand().toString());
	}

	public void list() throws IOException {
		pipe.write(new ListCommand(userController.getUsers()).toString());
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
	
	public String isAlreadyLoggedIn()
	{
		return new AlreadyLoggedInCommand().toString();
	}
}
