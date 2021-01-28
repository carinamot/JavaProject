package ex.Service;

import java.util.*;
import ex.Model.*;

public class BoardService {

	

	public List<BallsColor> clearColumn(Board board, int colIndex) {
		boolean hasLeft=(colIndex!=0);
		boolean hasRight=(colIndex!=6);
		List<BallsColor> ballsErased=new ArrayList<>();
		
		boolean[] hasToClear = new boolean[Board.numRows];

		for(int i=0; i<Board.numRows; i++) {
			if(hasLeft && board.get(i, colIndex)==board.get(i, colIndex-1) && board.get(i, colIndex) != BallsColor.N) {
				hasToClear[i]=true;
				ballsErased.add(board.get(i, colIndex-1));
				board.set(i, colIndex-1, BallsColor.N);
			}
			if(hasRight && board.get(i, colIndex)==board.get(i, colIndex+1) && board.get(i, colIndex) != BallsColor.N) {
				hasToClear[i]=true;
				ballsErased.add(board.get(i, colIndex+1));
				board.set(i, colIndex+1, BallsColor.N);
			}
		}
		for (int i = 1; i < Board.numRows; i++) {
			if (board.get(i-1, colIndex) == board.get(i, colIndex) && board.get(i, colIndex) != BallsColor.N) {
				hasToClear[i-1] = true;
				hasToClear[i] = true;
			}
		}
		for (int i = 0; i < Board.numRows; i++) {
			if (hasToClear[i]) {
				ballsErased.add(board.get(i, colIndex));
				board.set(i, colIndex, BallsColor.N);
			}
		}
		return ballsErased;
	}
	
	public List<BallsColor> clearRow(Board board, int rowIndex) {
		boolean hasUp=(rowIndex!=0);
		boolean hasDown=(rowIndex!=6);
		List<BallsColor> ballsErased=new ArrayList<>();

		boolean[] hasToClear = new boolean[Board.numRows];
		
		for(int i=0;i<Board.numCols;i++) {
			if(hasUp && board.get(rowIndex, i)==board.get(rowIndex-1, i) && board.get(rowIndex, i) != BallsColor.N) {
				hasToClear[i]=true;
				ballsErased.add(board.get(rowIndex-1, i));
				board.set(rowIndex-1, i, BallsColor.N);
			}
			
			if(hasDown && board.get(rowIndex, i)==board.get(rowIndex+1, i) && board.get(rowIndex, i) != BallsColor.N) {
				hasToClear[i]=true;
				ballsErased.add(board.get(rowIndex+1, i));
				board.set(rowIndex+1, i, BallsColor.N);
			}
		}
		for (int i = 1; i < Board.numCols; i++) {
			if (board.get(rowIndex, i - 1) == board.get(rowIndex, i) && board.get(rowIndex, i) != BallsColor.N) {
				hasToClear[i-1] = true;
				hasToClear[i] = true;
			}
		}
		for (int i = 0; i < Board.numCols; i++) {
			if (hasToClear[i]) {
				board.set(rowIndex, i, BallsColor.N);
			}
		}
		return ballsErased;
	}
	
	public void moveColumnUp(Board board, int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 0; i <= Board.numRows-1; i++)
		{
			if (!board.isEmpty(i,colIndex))
			{
				arr.add(board.get(i, colIndex));
			}
			board.set(i,colIndex,BallsColor.N);
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(i, colIndex, arr.get(i)); 
	}

	public void moveColumnDown(Board board, int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = Board.numRows-1; i >= 0; i--)
		{
			if (!board.isEmpty(i,colIndex))
			{
				arr.add(board.get(i, colIndex));
			}
			board.set(i, colIndex,BallsColor.N); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(Board.numRows-i-1,colIndex, arr.get(i));
	}


	public void moveRowLeft(Board board, int rowIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 0; i <=Board.numCols-1; i++)
		{
			if (!board.isEmpty(rowIndex,i))
			{
				arr.add(board.get(rowIndex, i));
			}
			board.set(rowIndex, i,BallsColor.N); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(rowIndex,i,arr.get(i));
	}

	public void moveRowRight(Board board, int rowIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = Board.numCols-1 ; i >= 0; i--)
		{
			if (!board.isEmpty(rowIndex,i))
			{
				arr.add(board.get(rowIndex, i));
			}
			board.set(rowIndex, i,BallsColor.N); 
		}
		for (int i = 0; i < arr.size(); i++)
			board.set(rowIndex, Board.numCols-i-1, arr.get(i));
	}


}
