package ex.Service;

import java.util.*;

import ex.Model.*;

public class GameService {

	List<Game> games= new ArrayList<>();
	
	public void createGame(Player player1, Player player2) {
		
		Game game=new Game(player1,player2);
		games.add(game);
	}
	
	public Game findByPlayer(Player player) {
		for(int i=0; i<= games.size(); i++) {
			if(games.get(i).getPlayer1()==player || games.get(i).getPlayer2()==player) {
				return games.get(i);
			}
		}
		return null;
	}
}
