package ex.Service;

import java.util.*;

import ex.Model.*;

public class GameService {

	List<Game> games= new ArrayList<>();
	
	public void createGame(Player player1, Player player2) {
		
		Game game=new Game(player1,player2);
		games.add(game);
	}
	
	
}
