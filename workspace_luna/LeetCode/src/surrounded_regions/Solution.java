package surrounded_regions;

import java.util.Stack;

/*
 * ÌâÄ¿ÃèÊö

Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.

A region is captured by flipping all'O's into'X's in that surrounded region .

For example,
 */
public class Solution {

	private void DFS(int i, int j, char[][] board){   
		if(board[i][j] != 'O') return;
		board[i][j] = '*';
		if(i-1>0 ) {
			DFS(i-1, j, board);
		}
		if(i+1<board.length ) {
			DFS(i+1, j, board);
		}
		if(j-1>=0 ) {
			DFS(i, j-1, board);
		}
		if(j+1<board[0].length ) {
			DFS(i, j+1, board);
		}
	}

    public void solve(char[][] board) {
    	if(board == null || board.length<=2 || board[0].length<=2) return;
    	for(int j=0; j<board[0].length; j++){
    		if(board[0][j] != 'X') DFS(0, j, board);
    		if(board[board.length-1][j] != 'X') DFS(board.length-1, j, board);
    	}
    	for(int i=0; i<board.length; i++){
    		if(board[i][0] != 'X') DFS(i, 0, board);
    		if(board[i][board[0].length-1] != 'X') DFS(i, board[0].length-1, board);
    	}
    	for(int i=0; i<board.length; i++){
    		for(int j=0; j<board[0].length; j++){
    			switch (board[i][j]) {
					case '*':
						board[i][j] = 'O';
						break;
					case 'O':
						board[i][j] = 'X';
						break;
					default:
						break;
				}
    		}
    	}
    }
    public static void main(String[] args) {
        char[][] board = {{'X','X','X','X','X','X'},{'X','X','X','O','X','X'},{'O','X','X','O','X','X'},{'X','O','O','O','X','X'},{'X','X','O','X','X','X'},{'X','O','X','X','X','X'},
        		        };
        Solution solution = new Solution();
        
        for(char chs[]: board){
        	for(char ch: chs){
        		System.out.print(ch+" ");
        	}
        	System.out.println();
        }
        solution.solve(board);
        
        System.out.println();
        for(char chs[]: board){
        	for(char ch: chs){
        		System.out.print(ch+" ");
        	}
        	System.out.println();
        }
	}
}
