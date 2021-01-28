package ex.Service;

import java.util.*;
import java.util.stream.Collectors;

import ex.Model.Game;
import ex.Model.Player;
import ex.Model.Command.*;


public class UserService {

	Set<String> logins = new HashSet<>();
	List<Player> users = new ArrayList<>();
	List<Game> games	= new ArrayList<>();
	
	public List<String> getUsers() {
		return logins.stream().collect(Collectors.toList());
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
	
	public void enqueue(Player player) {
		
		Player player1;
		Player player2;
		users.add(player);
		
		if(minTwoPlayers())
		{
			player1=this.pop();
			player2=this.pop();
			games.add(new Game(player1,player2));
		}
	}
	
	public void dequeue(Player player) {
		users.remove(player);
	}

	public boolean minTwoPlayers() {
		return users.size()>=2; 
	}

	public Player pop() {
		return users.remove(0);
	}
}
