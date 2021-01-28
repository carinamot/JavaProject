package Controller;

import java.util.*;
import ex.Model.*;

public class GameController {

	private Board board= new Board();

	public List<BallsColor> clearColumn(int colIndex) {
		boolean hasLeft=(colIndex!=0);
		boolean hasRight=(colIndex!=6);
		List<BallsColor> ballsErased=new ArrayList<>();

		for(int i=0; i<Board.numCols; i++) {
			boolean hasToClear=false;

			if(hasLeft && board.get(i, colIndex)==board.get(i-1, colIndex)) {
				hasToClear=true;
				ballsErased.add(board.get(i-1, colIndex));
				board.set(i-1, colIndex, BallsColor.NONE);
			}
			if(hasRight && board.get(i, colIndex)==board.get(i+1, colIndex)) {
				hasToClear=true;
				ballsErased.add(board.get(i+1, colIndex));
				board.set(i+1, colIndex, BallsColor.NONE);
			}
			if(hasToClear) {
				ballsErased.add(board.get(i, colIndex));
				board.set(i, colIndex, BallsColor.NONE);
			}

		}
		return ballsErased;
	}
	
	public List<BallsColor> clearRow(int rowIndex) {
		boolean hasUp=(rowIndex!=0);
		boolean hasDown=(rowIndex!=6);
		List<BallsColor> ballsErased=new ArrayList<>();

		
		for(int i=0;i<Board.numRows;i++) {
			boolean hasToClear=false;
			
			if(hasUp && board.get(rowIndex, i)==board.get(rowIndex, i-1)) {
				hasToClear=true;
				ballsErased.add(board.get(rowIndex, i-1));
				board.set(rowIndex, i-1, BallsColor.NONE);
			}
			
			if(hasDown && board.get(rowIndex, i)==board.get(rowIndex, i+1)) {
				hasToClear=true;
				ballsErased.add(board.get(rowIndex, i+1));
				board.set(rowIndex, i+1, BallsColor.NONE);
			}
			if(hasToClear) {
				ballsErased.add(board.get(rowIndex, i));
				board.set(rowIndex, i, BallsColor.NONE);
			}
		}
		
		return ballsErased;
	}
	
	public void moveColumnUp(int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 0; i <= Board.numCols-1; i++)
		{
			if (board.isEmpty(i,colIndex))
			{
				arr.add(board.get(i, colIndex));
			}
			board.set(i,colIndex,BallsColor.NONE);
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(i, colIndex, arr.get(i)); 
	}

	public void moveColumnDown(int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = Board.numCols-1; i >= 0; i--)
		{
			if (board.isEmpty(i,colIndex))
			{
				arr.add(board.get(i, colIndex));
			}
			board.set(i, colIndex,BallsColor.NONE); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(i,colIndex, arr.get(i));
	}


	public void moveRowLeft(int rowIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 0; i <=Board.numRows-1; i++)
		{
			if (board.isEmpty(rowIndex,i))
			{
				arr.add(board.get(rowIndex, i));
			}
			board.set(rowIndex, i,BallsColor.NONE); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(rowIndex,i,arr.get(i));
	}

	public void moveRowRight(int rowIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = Board.numRows-1 ; i >= 0; i--)
		{
			if (board.isEmpty(rowIndex,i))
			{
				arr.add(board.get(rowIndex, i));
			}
			board.set(rowIndex, i,BallsColor.NONE); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(rowIndex, i, arr.get(i));
	}


}
