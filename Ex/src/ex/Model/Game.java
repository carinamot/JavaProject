package ex.Model;

import ex.Model.Board;
import ex.Model.Player;

public class Game {

	private Board board;
	private Player player1;
	private Player player2;
	int playerTurn=0;
	
	public Game(Player player1, Player player2) {
		super();
		this.board = new Board();
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public Player nextPlayer() {
		if(playerTurn==0) {
			playerTurn=1;
			return player2;
		}
		playerTurn=0;
		return player1;
	}
	
	
	
}
