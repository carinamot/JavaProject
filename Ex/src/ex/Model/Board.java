package ex.Model;

import java.util.Arrays;

import ex.Model.Ball;
import ex.Model.BallsColor;

import java.io.Serializable;
import java.util.*;


public class Board implements Serializable 
{
	private Ball[][] balls;

	public Board() {
		super();
		//ball = ball;
		balls = new Ball [7][7];
		for ( int r = 0; r < 7 ; r++) {
			for (int c = 0; c < 7; c++) {
				Ball possibleChoice = new Ball();
				while(true) {
					if(isBallValid(r, c, possibleChoice)) { 
						break;
					}
					possibleChoice = new Ball();
				}
				balls[r][c] = possibleChoice;
			}
		}
	}

	private boolean isBallValid(int x, int y, Ball ball) {
		if(x == 0 && y != 0) {
			return balls[0][y-1].compareTo(ball) != 0;
		} else if(x != 0 && y == 0) {
			return balls[x-1][0].compareTo(ball) != 0;
		} else if (x == 6 && y != 0) {
			return balls[6][y-1].compareTo(ball) != 0 && balls[5][y].compareTo(ball) != 0;
		} else if (x != 0 && y == 6) {
			return balls[x-1][6].compareTo(ball) != 0 && balls[x][5].compareTo(ball) != 0;
		} else if(x > 0 && y != 0 && x < 6 && y < 6) {
			return balls[x-1][y].compareTo(ball) != 0 && balls[x][y-1].compareTo(ball) != 0;
		}
		return true;
	}
	
	public boolean isEmpty(int row, int column){
		return balls[row][column].getColor()==BallsColor.NONE;
	}
	
	public Ball get(int row, int column){
		return balls[row][column];
	}
	
	public void set(int row, int column, Ball ball){
		balls[row][column]=ball;
	}

	public void handleMove(int currentX, int currentY, String direction) {

		if(direction=="left" && currentY!=0){
			Ball a=balls[currentX][currentY];
			balls[currentX][currentY]=balls[currentX][currentY-1];
			balls[currentX][currentY-1]=a;
		}
		if(direction=="right" && currentY!=6){
			Ball a=balls[currentX][currentY];
			balls[currentX][currentY]=balls[currentX][currentY+1];
			balls[currentX][currentY+1]=a;
		}
		if(direction=="up" && currentX!=0){
			Ball a=balls[currentX][currentY];
			balls[currentX][currentY]=balls[currentX-1][currentY];
			balls[currentX-1][currentY]=a;
		}
		if(direction=="down" && currentX!=6){
			Ball a=balls[currentX][currentY];
			balls[currentX][currentY]=balls[currentX+1][currentY];
			balls[currentX+1][currentY]=a;
		}	


	}

	public void Pair(int currentX, int currentY)
	{
		if(balls[currentX][currentY].compareTo(balls[currentX][currentY-1])==0){
			balls[currentX][currentX].setColor(BallsColor.NONE);
			balls[currentX][currentY-1].setColor(BallsColor.NONE);
		}

		if(balls[currentX][currentY].compareTo(balls[currentX][currentY+1])==0){
			balls[currentX][currentX].setColor(BallsColor.NONE);
			balls[currentX][currentY+1].setColor(BallsColor.NONE);
		}

		if(balls[currentX][currentY].compareTo(balls[currentX-1][currentY])==0){
			balls[currentX][currentX].setColor(BallsColor.NONE);
			balls[currentX-1][currentY].setColor(BallsColor.NONE);
		}
		if(balls[currentX][currentY].compareTo(balls[currentX+1][currentY])==0){
			balls[currentX][currentX].setColor(BallsColor.NONE);
			balls[currentX+1][currentY].setColor(BallsColor.NONE);
		}
	}


	public void printBoard() {
		for ( int r = 0; r < 7 ; r++) {
			for (int c = 0; c < 7; c++) {
				System.out.print(balls[r][c]+"\t");
			}
			System.out.println();
		}
	}

	@Override
	public String toString() {
		return "Board [size=" + Arrays.toString(balls) + ", ball=" + "]";
	}
}
