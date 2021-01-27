package ex.Service;

import java.util.*;

import ex.Model.Command.*;


public class UserService {

	Set<String> logins = new HashSet<>();
	List<String> users = new ArrayList<>();
	
	public List<String> getUsers() {
		return users;
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public boolean isLoggedIn(String username) {
		return logins.contains(username);
	}
	
	public void login(String username) {
		logins.add(username);
		users.add(username);
	}

	public boolean minTwoPlayers() {
		return users.size()>=2; 
	}

	public String deque() {
		return users.remove(0);
	}
}
