package Controller;

import ex.Model.Board;

public class ViewController {

	CommandController commandController=new CommandController();
	
	public void displayBoard(String board) {
		String[] arr=commandController.decomposeCommand(board);
		int k=0;
		for(int i=0; i< Board.numRows; i++) {
			for(int j=0; j< Board.numCols; j++)
			{
				k++;
				System.out.print(arr[k]+" ");
			}
			System.out.println("\n");
		}
	}
	
	public void displayBoard(Board board) {
	
		for(int i=0; i< Board.numRows; i++) {
			for(int j=0; j< Board.numCols; j++)
			{				
				System.out.print(board.get(i, j)+" ");
			}
			System.out.println("\n");
		}
	}
	
	public void displayList(String usernames) {
		String [] arr= commandController.decomposeCommand(usernames);
		for(int i=1; i< arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
