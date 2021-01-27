package ex.Service;

import java.util.*;

public class UserService {

	Queue<String> users= new PriorityQueue<>();

	public boolean minTwoPlayers() {

		return users.size()>=2; 

	}

	public String deque() {

		return users.poll();
	}
}
