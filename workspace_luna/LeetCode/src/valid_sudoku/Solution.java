package valid_sudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public boolean isValidSudoku(char[][] board) {

       for(int i=0; i<9; i++){
    	   Set<Character> row = new HashSet<Character>();
    	   Set<Character> col = new HashSet<Character>();
    	   Set<Character> cube = new HashSet<Character>();
    	   for(int j=0; j<9; j++){
    		   if(board[i][j] != '.' && !row.add(board[i][j])) return false;  //第i行
    		   if(board[j][i] != '.' && !col.add(board[j][i])) return false;  //第i列
    		   int cuberow = 3 * (i/3) + j/3;      //第i个九宫格的第j个数的坐标
    		   int cubecol = 3 * (i%3) + j%3;
    		   if(board[cuberow][cubecol] != '.' && !cube.add(board[cuberow][cubecol])) return false;
    	   }
       }
       return true;
    }
}
