package Controller;

import java.util.List;
import java.util.Objects;

import ex.Model.Player;
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
	
	public void queue(Player player) {
		final String username = player.getName();
		if (Objects.nonNull(username)) {
			if (userService.inQueue(username)) {
				userService.dequeue(username);
			} else {
				userService.enqueue(username);
			}
		}
		
	}

}
