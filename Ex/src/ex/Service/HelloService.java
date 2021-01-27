package ex.Service;

import ex.Model.Command.HelloCommand;

public class HelloService {
	
	private final String description;

	public HelloService(String description) {
		this.description = description;
	}
	
	public String sayHello() {
		return new HelloCommand(description, null).toString();
	}

}
