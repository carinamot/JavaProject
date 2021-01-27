package Controller;

import ex.Service.HelloService;
import ex.Service.LoginService;

public class ClientMessageController {

	private final HelloService helloService;
	private final LoginService loginService;
	
	public ClientMessageController(String description) {
		helloService = new HelloService("I am a player!");
		loginService = new LoginService();
	}

	public String hello() {
		return helloService.sayHello();
	}
	
	public String loginRequest(String username) {
		return loginService.login(username);
	}
}
