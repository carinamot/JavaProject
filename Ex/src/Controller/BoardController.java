package Controller;

import ex.Model.Board;
import ex.Service.BoardService;

public class BoardController {
	
	private Board board;
	private BoardService boardService;
	
	public BoardController() {
		boardService= new BoardService();
	}
	
	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	

	public void move(int index) {
		if(index>= 0 && index<=6) {
			boardService.moveRowLeft(board, index);
		}
		if(index>=7 && index<=13){
			boardService.moveRowRight(board, index-7);
		}
		if(index>=14 && index<=20) {
			boardService.moveColumnUp(board, index-14);
		}
		if(index>=21 && index<=27) {
			boardService.moveColumnDown(board, index-21);
		}
	}
}
