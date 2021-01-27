package ex.Service;

import java.util.*;

public class UserService {

	Set<String> logins = new HashSet<>();
	Queue<String> users = new PriorityQueue<>();
	
	public boolean isLoggedIn(String username) {
		return logins.contains(username);
	}
	
	public void login(String username) {
		logins.add(username);
		users.offer(username);
	}

	public boolean minTwoPlayers() {
		return users.size()>=2; 
	}

	public String deque() {
		return users.poll();
	}
}
