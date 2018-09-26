package spiral_matrix_ii;

/*ÌâÄ¿ÃèÊö

Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.

For example,
Given n =3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/
public class Solution {
    public int[][] generateMatrix(int n) {
    	if(n==0) return new int[0][0];
    	int [][]matrix = new int[n][n];
    	int top = 0;
    	int bottom = matrix.length-1;
    	int left = 0;
    	int right = matrix[0].length-1;
    	int start = 1;
    	while(top <= bottom && left <= right) {
	    	for(int i=left; i <= right && top <= bottom; i++)
	    		matrix[top][i] = start++;
	    	top++;
	    	for(int i=top; i <= bottom && left <= right; i++)
	    		matrix[i][right] = start++;
	    	right--;
	    	for(int i=right; i >= left && top <= bottom; i--)
	    		matrix[bottom][i] = start++;
	    	bottom--;
	    	for(int i=bottom; i >= top && left <= right; i--)
	    		matrix[i][left] = start++;
	    	left++;
    	}
    	return matrix;   
    }
}
