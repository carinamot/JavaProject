package ex.Service;

import java.util.*;
import ex.Model.*;

public class PlayerService {

	List<Player> players= new ArrayList<>();
	
	public void addPlayers(String playerName) {
		
		Player player=new Player(playerName);
		players.add(player);
	}
	
	public List<String> getPlayers(){
		
		List<String> arr= new ArrayList<>();
		for(int i=0; i<=players.size(); i++){
			arr.add(players.get(i).getName());
		}
		return arr;
	}
	
}