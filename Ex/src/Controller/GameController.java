package Controller;

import java.util.*;
import ex.Model.*;

public class GameController {


	private Board board= new Board();

	public void moveColumnUp(int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 0; i < 7; i++)
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

	public void checkColumn(int colIndex) {
		boolean hasLeft=(colIndex!=0);
		boolean hasRight=(colIndex!=6);

		for(int i=0; i<7; i++) {
			boolean hasToClear=false;

			if(hasLeft && board.get(i, colIndex)==board.get(i-1, colIndex)) {
				hasToClear=true;
				board.set(i-1, colIndex, BallsColor.NONE);
			}
			if(hasRight && board.get(i, colIndex)==board.get(i+1, colIndex)) {
				hasToClear=true;
				board.set(i+1, colIndex, BallsColor.NONE);
			}
			if(hasToClear) {
				board.set(i, colIndex, BallsColor.NONE);
			}

		}
	}
	
	public void checkRow(int rowIndex) {
		boolean hasUp=(rowIndex!=0);
		boolean hasDown=(rowIndex!=6);
		
		for(int i=0;i<7;i++) {
			boolean hasToClear=false;
			
			if(hasUp && board.get(rowIndex, i)==board.get(rowIndex, i-1)) {
				hasToClear=true;
				board.set(rowIndex, i-1, BallsColor.NONE);
			}
			
			if(hasDown && board.get(rowIndex, i)==board.get(rowIndex, i+1)) {
				hasToClear=true;
				board.set(rowIndex, i+1, BallsColor.NONE);
			}
			if(hasToClear) {
				board.set(rowIndex, i, BallsColor.NONE);
			}
		}
	}

	public void moveColumnDown(int colIndex) {
		List<BallsColor> arr = new ArrayList<>();

		for (int i = 6; i >= 0; i--)
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

		for (int i = 0; i < 7; i++)
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

		for (int i = 6; i >= 0; i--)
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
