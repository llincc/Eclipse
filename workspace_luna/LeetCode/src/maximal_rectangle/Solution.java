package maximal_rectangle;

import java.util.Stack;
/*��Ŀ����

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

*/
public class Solution {
    //˼����leetcode84һ��largest-rectangle-in-histogram
    public int maximalRectangle(char[][] matrix) {
    	 
    	 if(matrix == null || matrix.length == 0 || matrix[0].length==0) return 0;	 
         int m = matrix.length, n = matrix[0].length;
    	 int max = 0;
    	 int hgt[] = new int[n];
    	 Stack<Integer> stack = new Stack<Integer>();
    	 //ʾ���߶�Ϊ05434560��ʱ���������
    	 for(int i=0; i<m; i++){
    		 stack.clear();
    		 stack.push(-1);
    		 for(int j=0; j<n; j++){
    			 if(matrix[i][j] == '1') hgt[j]++;
    			 else hgt[j] = 0;
    		 }
    		 for(int j=0; j<n; j++){
    			 while(stack.peek() != -1 && hgt[j] < hgt[stack.peek()]){ //ǰһ���Ⱥ�һ���͵�ʱ��
    				 int top = stack.pop();
    				 max = Math.max(max, (j - 1 - stack.peek())*hgt[top]);
    			 }
    			 stack.push(j);
    		 }
    		 while (stack.peek()!=-1) {
				int top = stack.pop();
				max = Math.max(max, (n - 1 - stack.peek())*hgt[top]);
			}
    	 }
    	 return max;
    	 
    }
    
    
    public static void main(String[] args) {
		char matrix[][] = {{'0','1','1','0','1'},
				           {'1','1','0','1','0'},
				           {'0','1','1','1','0'},
				           {'1','1','1','1','0'},
				           {'1','1','1','1','1'},
				           {'0','0','0','0','0'}};
		System.out.println(new Solution().maximalRectangle(matrix));
		
	}
}
