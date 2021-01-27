package Controller;

import ex.Service.*;


public class ClientMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	private final ListService listService;
	private final QueueService queueService;
	private final MoveService moveService;
	
	public ClientMessageController(String description) {
		helloService = new HelloService("I am a player!");
		loginService = new LoginService();
		listService	 = new ListService();
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
		return listService.list();
	}
	
	public String queue() {
		return queueService.queue();
	}
	
	public String move() {
		return moveService.move();
	}
	
}
