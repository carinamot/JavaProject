package Controller;

import java.util.Collections;
import java.util.List;

import ex.Model.Command.AlreadyLoggedInCommand;
import ex.Model.Command.ListCommand;
import ex.Model.Command.MoveCommand;
import ex.Service.*;

public class ServerMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	private final NewGameService newgameService;
	private final GameOverService gameoverService;

	public ServerMessageController(String description) {
		helloService = new HelloService("Welcome to my server!");
		loginService = new LoginService();
		newgameService = new NewGameService();
		gameoverService= new GameOverService();
	}

	public String hello() {
		return helloService.sayHello();
	}


	public String loginResponse(String username) {
		return loginService.login();
	}

	public String list(List<String> usernames) {
		return new ListCommand(usernames).toString();
	}

	public String newgame() {
		return newgameService.newgame();
	}

	public String move(Integer moveNumber) {
		return new MoveCommand(Collections.singletonList(moveNumber)).toString();
	}

	public String gameover() {
		return gameoverService.gameover();
	}
	
	public String isAlreadyLoggedIn()
	{
		return new AlreadyLoggedInCommand().toString();
	}
}
