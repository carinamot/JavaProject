package ex.Service;

import java.util.*;
import java.util.stream.Collectors;

import ex.Model.Command.*;


public class UserService {

	Set<String> logins = new HashSet<>();
	List<String> users = new ArrayList<>();
	
	public List<String> getUsers() {
		return logins.stream().collect(Collectors.toList());
	}

	public void setUsers(List<String> users) {
		this.users = users;
	}

	public boolean isLoggedIn(String username) {
		return logins.contains(username);
	}
	
	public boolean inQueue(String username) {
		return users.contains(username);
	}
	
	public void login(String username) {
		logins.add(username);
	}
	
	public void enqueue(String username) {
		users.add(username);
	}
	
	public void dequeue(String username) {
		users.remove(username);
	}

	public boolean minTwoPlayers() {
		return users.size()>=2; 
	}

	public String pop() {
		return users.remove(0);
	}
}
