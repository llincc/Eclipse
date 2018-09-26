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
    		   if(board[i][j] != '.' && !row.add(board[i][j])) return false;  //��i��
    		   if(board[j][i] != '.' && !col.add(board[j][i])) return false;  //��i��
    		   int cuberow = 3 * (i/3) + j/3;      //��i���Ź���ĵ�j����������
    		   int cubecol = 3 * (i%3) + j%3;
    		   if(board[cuberow][cubecol] != '.' && !cube.add(board[cuberow][cubecol])) return false;
    	   }
       }
       return true;
    }
}
