package ex.Service;

import ex.Model.Command.LoginCommand;

public class LoginService {

	public String login(String username) {
		return new LoginCommand(username).toString();
	}
	
	public String login() {
		return new LoginCommand().toString();
	}

}
