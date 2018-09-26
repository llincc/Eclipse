package set_matrix_zeroes;
/*题目描述
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(m n) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?*/
public class Solution {
//    public void setZeroes(int[][] matrix) {
//        int rowcal[] = new int[Math.max(matrix.length, matrix[0].length)];  //1表示行，2表示列，3表示行列
//        for(int i=0; i<matrix.length; i++){
//        	for(int j=0; j<matrix[0].length; j++){
//        		if(matrix[i][j] == 0){
//        			if(rowcal[i] == 2) rowcal[i] = 3;
//        			else if(rowcal[i] == 0) rowcal[i] = 1;
//        			
//        			if(rowcal[j] == 1) rowcal[j] = 3;
//        			else if(rowcal[j] == 0) rowcal[j] = 2;
//        			
//        		}
//        	}
//        }
//        for(int i=0; i<matrix.length; i++){
//        	for(int j=0; j<matrix[0].length; j++){
//        	    if(rowcal[i] == 1 || rowcal[i] == 3 || rowcal[j] == 2 || rowcal[j] == 3) matrix[i][j] = 0;
//        	}
//        }
//    }
    
    public void setZeroes(int[][] matrix) {
        boolean row_zero = false;
        boolean col_zero = false;
        for(int i=0; i<matrix.length; i++)
        	if(matrix[i][0] == 0) col_zero = true;
        for(int j=0; j<matrix[0].length; j++)
        	if(matrix[0][j] == 0) row_zero = true;
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][j] == 0){
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        		}
        	}
        }
        
        for(int i=0; i<matrix.length; i++){
        	for(int j=0; j<matrix[0].length; j++){
        		if(matrix[i][0] == 0 || matrix[0][j] == 0){
        			matrix[i][j] = 0;
        		}
        	}
        }
        if(col_zero){
            for(int i=0; i<matrix.length; i++)
            	matrix[i][0] = 0;
        }
        if(row_zero){
            for(int j=0; j<matrix[0].length; j++)
            	matrix[0][j] = 0;
        }

    }
}
