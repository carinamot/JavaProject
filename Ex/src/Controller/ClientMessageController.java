package Controller;

import ex.Model.Command.ListCommand;
import ex.Service.*;


public class ClientMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	private final QueueService queueService;
	private final MoveService moveService;
	
	public ClientMessageController(String description) {
		helloService = new HelloService("I am a player!");
		loginService = new LoginService();
		queueService = new QueueService();
		moveService	 = new MoveService();
	}

	public String hello() {
		return helloService.sayHello();
	}
	
	public String loginRequest(String username) {
		return loginService.login(username);
	}
	
	public String list() {
		return new ListCommand().toString();
	}
	
	public String queue() {
		return queueService.queue();
	}
	
	public String move() {
		return moveService.move();
	}
	
}
