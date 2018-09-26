package search_a_2d_matrix;
/*题目描述

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:


Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target =3, returntrue.*/
public class Solution {
	//最慢
    public boolean searchMatrix1(int[][] matrix, int target) {
    	int i=0;
    	for(i=0; i<matrix.length && matrix[i][0]<=target; i++);
    	if(i!=0) i--;
    	for(int j=0; j<matrix[i].length; j++){
    		if(matrix[i][j] == target) return true;
    	}
    	return false;
    }
    //二分，时间复杂度O(log2(m * n))
    public boolean searchMatrix2(int[][] matrix, int target) {
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int start = 0;
    	int end = row * col -1;
    	int mid, x, y;
    	while(start<=end){
    		mid = (start+end)/2;
    		x = mid / col;
    		y = mid % col;
    		if(matrix[x][y] == target) return true;
    		else if(matrix[x][y] < target) start = mid + 1;
    		else end = mid - 1;
    	}
        return false;
    }
    
    //左上角//右下角开始，时间复杂度log2(m*n)< O(sqrt(m2+n2)) < m + n
    public boolean searchMatrix3(int[][] matrix, int target) {
    	int i = 0;
    	int j = matrix[0].length - 1;
    	while(i < matrix.length && j>=0){
    		if(matrix[i][j]== target) return true;
    		else if(matrix[i][j] < target) i++; //去掉这一行
    		else j--; //去掉一列
    	}
        return false;
    }
    public static void main(String[] args) {
		int[][]matrix = {{1}};
		new Solution().searchMatrix2(matrix, 0);
	}
}
