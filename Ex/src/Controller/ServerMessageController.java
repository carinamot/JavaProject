package Controller;

import java.util.List;

import ex.Model.Command.AlreadyLoggedInCommand;
import ex.Model.Command.ListCommand;
import ex.Service.*;

public class ServerMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	private final NewGameService newgameService;
	private final MoveService moveService;
	private final GameOverService gameoverService;

	public ServerMessageController(String description) {
		helloService = new HelloService("Welcome to my server!");
		loginService = new LoginService();
		newgameService = new NewGameService();
		moveService	= new MoveService();
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

	public String move() {
		return moveService.move();
	}

	public String gameover() {
		return gameoverService.gameover();
	}
	
	public String isAlreadyLoggedIn()
	{
		return new AlreadyLoggedInCommand().toString();
	}
}
