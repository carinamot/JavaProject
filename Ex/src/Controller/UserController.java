package Controller;

import java.util.List;

import ex.Service.UserService;

public class UserController {
	
	private final UserService userService;

	public UserController() {
		userService = new UserService();
	}
	
	public List<String> getUsers() {
		return userService.getUsers();
	}
	
	public boolean login(String username) {
		if (userService.isLoggedIn(username)) {
			return false;
		}
		userService.login(username);
		return true;
	}

}
