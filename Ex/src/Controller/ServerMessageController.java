package Controller;

import ex.Service.*;

public class ServerMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	private final ListService listService;
	private final NewGameService newgameService;
	private final MoveService moveService;
	private final GameOverService gameoverService;

	public ServerMessageController(String description) {
		helloService = new HelloService("Welcome to my server!");
		loginService = new LoginService();
		listService	 = new ListService();
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
	
	public String list() {
		return listService.list();
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
}
