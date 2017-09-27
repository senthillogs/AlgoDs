package com.ad.backtracking;

public class NQueenProblem {
	
	static int[][] board = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
	public static void main(String[] args) {
		placeQueen(board, 0);
		display(board);
		
	}
	
	static void display(int board[][]) {
		for(int i=0;i<board.length;i++) {
			System.out.println();
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j] + " ");
			}
		}
		System.out.println();

	}
	static boolean isValid(int board[][], int row, int col) {
		
		
		//Check row behind
		
		for(int c = col-1; c >=0; c--) {
			if(board[row][c] == 1) {
				return false;
			}
		}
		
		//Check upper diagonal
		
		for(int r=row,c=col;r >=0 && c >=0; r--, c--) {
			if(board[r][c] == 1) {
				return false;
			}	
		}
		//Check lower diagonal
		for(int r=row,c=col;r < board.length && c >=0; r++, c--) {
			if(board[r][c] == 1) {
				return false;
			}	
		}
		
		return true;
		
	}
	
	static boolean placeQueen(int board[][], int col) {
		
		if(col == board.length) return true;
		
		for(int row=0;row < board.length; row++) {
			
			if(isValid(board, row, col)) {
				board[row][col] = 1;
				
				if(placeQueen(board, col+1)) {
					return true;
				} 
				
				board[row][col] = 0;
			}
		}
		
		return false;
		
	}

}	
