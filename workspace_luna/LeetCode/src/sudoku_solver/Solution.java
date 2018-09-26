package sudoku_solver;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Ã‚ƒø√Ë ˆ

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character'.'.

You may assume that there will be only one unique solution.*/
public class Solution {
    public void solveSudoku(char[][] board) {

        int n = board.length;
        int rowmap[][] = new int[n][n+1];
        int colmap[][] = new int[n][n+1];
        for(int i=0; i<board.length; i++){
        	for(int j=0; j<board[0].length; j++){
        		if(board[i][j]!='.'){
            		rowmap[i][(int)(board[i][j]-'0')] = 1;
            		colmap[j][(int)(board[i][j]-'0')] = 1;        			
        		}
        	}
        }
        search(rowmap, colmap, board, 0, 0);
    }
    public boolean search(int[][] rowmap, int[][]colmap, char[][] board, int i, int j){
//    	System.out.println(i+" "+j);
        if(i == board.length-1 && j==board.length) return true;
        if(j == board.length){
        	i ++;
        	j = 0;
        }
        if(board[i][j] != '.') return search(rowmap, colmap, board, i, j+1);
        for(int k=1; k<=rowmap.length; k++){
        	if(rowmap[i][k] == 0 && colmap[j][k] == 0 && checkgrid(board, (char)(k+'0'), i, j)){
        		
//        		System.out.println(k);
        		board[i][j] = (char) (k + '0');
        	    colmap[j][k] = 1;
        	    rowmap[i][k] = 1;
        	    if(search(rowmap, colmap, board, i, j+1)){
        	    	return true;
        	    }
        	    else{
            	    rowmap[i][k] = 0;
            	    colmap[j][k] = 0;
            	    board[i][j] = '.'; 	
        	    }
        	}
        }
        return false;
    }
    private boolean checkgrid(char board[][],char ch, int row, int col){
    	int xBegin = (row/3)*3, yBegin = (col/3)*3;
    	for(int i=xBegin; i<xBegin+3; i++ ){
    		for(int j=yBegin; j<yBegin+3; j++){
    			if(board[i][j] == ch) return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args) {
    	String a1 = "53467....";
    	String a2 = "6..195...";
    	String a3 = ".98....6.";
    	String a4 = "8...6...3";
    	String a5 = "4..8.3..1";
    	String a6 = "7...2...6";
    	String a7 = ".6....28.";
    	String a8 = "...419..5";
    	String a9 = "....8..79";
		char [][]board = {a1.toCharArray(),a2.toCharArray(),a3.toCharArray(),a4.toCharArray(),a5.toCharArray(),
				a6.toCharArray(),a7.toCharArray(),a8.toCharArray(),a9.toCharArray()};
		new Solution().solveSudoku(board);
		
		for(char row[]: board){
			System.out.println(new String(row));
		}
	}
}
