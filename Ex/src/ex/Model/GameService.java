package ex.Model;

public class GameService {

	private Board board;
	private Player player;
	
	public GameService(Player player) {
		super();
		this.board = new Board();
		this.player = player;
		board.printBoard();
	}

	
	@Override
	public String toString() {
		return "Game [board=" + board + ", player=" + player + "]";
	}
	
	public Board getBoard() { 
		return board;
	}
	
	public void handleMove(int currentX, int currentY, String direction) {
		board.handleMove(currentX, currentY, direction);
	}
}
