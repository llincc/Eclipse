package rotate_image;
/*��Ŀ����

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/
public class Solution {
    public void rotate(int[][] matrix) {
    	int n = matrix.length;
        for(int i=0; i< n/2;i++){ //����㵽������
        	int len = n - i- 1;
        	for(int j=i; j<len; j++){
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[n-j-1][i];
        		matrix[n-j-1][i] = matrix[len][n-j-1];
        		matrix[len][n-j-1] = matrix[j][len];
        		matrix[j][len] = temp;
        	}
        }
    }
}
