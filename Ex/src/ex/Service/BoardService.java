package ex.Service;

import java.util.*;
import ex.Model.*;

public class BoardService {

	

	public List<BallsColor> clearColumn(Board board, int colIndex) {
		boolean hasLeft=(colIndex!=0);
		boolean hasRight=(colIndex!=6);
		List<BallsColor> ballsErased=new ArrayList<>();

		for(int i=0; i<Board.numRows; i++) {
			boolean hasToClear=false;

			if(hasLeft && board.get(i, colIndex)==board.get(i-1, colIndex)) {
				hasToClear=true;
				ballsErased.add(board.get(i-1, colIndex));
				board.set(i-1, colIndex, BallsColor.N);
			}
			if(hasRight && board.get(i, colIndex)==board.get(i+1, colIndex)) {
				hasToClear=true;
				ballsErased.add(board.get(i+1, colIndex));
				board.set(i+1, colIndex, BallsColor.N);
			}
			if(hasToClear) {
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

		
		for(int i=0;i<Board.numCols;i++) {
			boolean hasToClear=false;
			
			if(hasUp && board.get(rowIndex, i)==board.get(rowIndex, i-1)) {
				hasToClear=true;
				ballsErased.add(board.get(rowIndex, i-1));
				board.set(rowIndex, i-1, BallsColor.N);
			}
			
			if(hasDown && board.get(rowIndex, i)==board.get(rowIndex, i+1)) {
				hasToClear=true;
				ballsErased.add(board.get(rowIndex, i+1));
				board.set(rowIndex, i+1, BallsColor.N);
			}
			
			if(hasToClear) {
				ballsErased.add(board.get(rowIndex, i));
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
			board.set(i,colIndex, arr.get(i));
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
			board.set(rowIndex, i, arr.get(i));
	}


}
