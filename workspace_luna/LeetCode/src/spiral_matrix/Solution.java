package spiral_matrix;

import java.util.ArrayList;

/*Ã‚ƒø√Ë ˆ

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return[1,2,3,6,9,8,7,4,5].*/
public class Solution {
    public ArrayList<Integer> spiralOrder1(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix.length == 0) return result;
        boolean visited[][] = new boolean[matrix.length][matrix[0].length];
        go(result, matrix, visited, 0, 0, 0);
        return result;
    }
    public void go(ArrayList<Integer> result,int[][]matrix, boolean visted[][], int i, int j, int direct){
    	if(!visted[i][j]){
    		visted[i][j] = true;
    		result.add(matrix[i][j]);
    		if(direct == 0){
    			if(j < matrix[0].length-1 && !visted[i][j+1]) go(result, matrix, visted, i, j+1, 0);
    			else if(i < matrix.length - 1 && !visted[i+1][j]) go(result, matrix, visted, i+1, j, 1);
    		}
    		else if(direct == 1){
    			if(i < matrix.length - 1 && !visted[i+1][j]) go(result, matrix, visted, i+1, j, 1);
    			else if(j > 0 && !visted[i][j-1]) go(result, matrix, visted, i, j-1, 2);
    		}
    		else if(direct == 2){
    			if(j > 0 && !visted[i][j-1]) go(result, matrix, visted, i, j-1, 2);
    			else if(i > 0 && !visted[i-1][j]) go(result, matrix, visted, i-1, j, 3);
    		}
    		else if(direct == 3){
    			if(i > 0 && !visted[i-1][j]) go(result, matrix, visted, i-1, j, 3);
    			else if(j < matrix[0].length-1 && !visted[i][j+1]) go(result, matrix, visted, i, j+1, 0);
    		}		
    	}
    }

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
    	if(matrix == null || matrix.length < 1 || matrix[0].length < 1)
    	return new ArrayList<Integer>();
    	int top = 0;
    	int bottom = matrix.length-1;
    	int left = 0;
    	int right = matrix[0].length-1;
    	ArrayList<Integer> res = new ArrayList<Integer>();
    	while(top <= bottom && left <= right) {
	    	for(int i=left; i <= right && top <= bottom; i++)
	    		res.add(matrix[top][i]);
	    	top++;
	    	for(int i=top; i <= bottom && left <= right; i++)
	    		res.add(matrix[i][right]);
	    	right--;
	    	for(int i=right; i >= left && top <= bottom; i--)
	    		res.add(matrix[bottom][i]);
	    	bottom--;
	    	for(int i=bottom; i >= top && left <= right; i--)
	    		res.add(matrix[i][left]);
	    	left++;
    	}
    	return res;
    }
    public static void main(String[] args) {
		int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(new Solution().spiralOrder(matrix));
	}
}
