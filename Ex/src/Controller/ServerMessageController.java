package Controller;

import ex.Service.HelloService;
import ex.Service.LoginService;

public class ServerMessageController {
	
	private final HelloService helloService;
	private final LoginService loginService;
	
	public ServerMessageController(String description) {
		helloService = new HelloService("Welcome to my server!");
		loginService = new LoginService();
	}

	public String hello() {
		return helloService.sayHello();
	}
	
	public String loginResponse() {
		return loginService.login();
	}
}
