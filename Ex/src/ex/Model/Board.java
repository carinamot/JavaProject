package ex.Model;

import java.util.*;

import ex.Model.*;
import ex.Model.BallsColor;

import java.io.Serializable;
import java.util.*;


public class Board implements Serializable 
{
	private BallsColor[][] balls;
	public static int numRows=7;
	public static int numCols=7;

	public Board() {
		super();
		//ball = ball;
		balls = new BallsColor [7][7];
		for ( int r = 0; r < numRows ; r++) {
			for (int c = 0; c < numCols; c++) {
//				BallsColor possibleChoice = new BallsColor();
//				while(true) {
//					if(isBallValid(r, c, possibleChoice)) { 
//						break;
//					}
//					possibleChoice = new BallsColor();
//				}
				balls[r][c] = getRandomColor();
			}
		}
	}

	public BallsColor getRandomColor() {
		Random rand= new Random();
		return BallsColor.values()[rand.nextInt(BallsColor.values().length)];
		
	}
	
//	private boolean isBallValid(int x, int y, BallsColor color) {
//		if(x == 0 && y != 0) {
//			return balls[0][y-1].compareTo(ball) != 0;
//		} else if(x != 0 && y == 0) {
//			return balls[x-1][0].compareTo(ball) != 0;
//		} else if (x == 6 && y != 0) {
//			return balls[6][y-1].compareTo(ball) != 0 && balls[5][y].compareTo(ball) != 0;
//		} else if (x != 0 && y == 6) {
//			return balls[x-1][6].compareTo(ball) != 0 && balls[x][5].compareTo(ball) != 0;
//		} else if(x > 0 && y != 0 && x < 6 && y < 6) {
//			return balls[x-1][y].compareTo(ball) != 0 && balls[x][y-1].compareTo(ball) != 0;
//		}
//		return true;
//	}
	
	public boolean isEmpty(int row, int column){
		return balls[row][column]==BallsColor.NONE;
	}

	public BallsColor get(int row, int column) {
		return balls[row][column];
	}
	
	public BallsColor set(int row, int column, BallsColor color){
		return balls[row][column]=color;
	}

	

//	public void Pair(int currentX, int currentY)
//	{
//		if(balls[currentX][currentY].compareTo(balls[currentX][currentY-1])==0){
//			balls[currentX][currentX].setColor(BallsColor.NONE);
//			balls[currentX][currentY-1].setColor(BallsColor.NONE);
//		}
//
//		if(balls[currentX][currentY].compareTo(balls[currentX][currentY+1])==0){
//			balls[currentX][currentX].setColor(BallsColor.NONE);
//			balls[currentX][currentY+1].setColor(BallsColor.NONE);
//		}
//
//		if(balls[currentX][currentY].compareTo(balls[currentX-1][currentY])==0){
//			balls[currentX][currentX].setColor(BallsColor.NONE);
//			balls[currentX-1][currentY].setColor(BallsColor.NONE);
//		}
//		if(balls[currentX][currentY].compareTo(balls[currentX+1][currentY])==0){
//			balls[currentX][currentX].setColor(BallsColor.NONE);
//			balls[currentX+1][currentY].setColor(BallsColor.NONE);
//		}
//	}


	public void printBoard() {
		for ( int row = 0; row < numRows ; row++) {
			for (int column = 0; column < numCols; column++) {
				System.out.println(balls[row][column]+"\t");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Board [size=" + Arrays.toString(balls) + ", ball=" + "]";
	}
}
