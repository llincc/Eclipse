package maximal_rectangle;

import java.util.Stack;
/*题目描述

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

*/
public class Solution {
    //思想与leetcode84一致largest-rectangle-in-histogram
    public int maximalRectangle(char[][] matrix) {
    	 
    	 if(matrix == null || matrix.length == 0 || matrix[0].length==0) return 0;	 
         int m = matrix.length, n = matrix[0].length;
    	 int max = 0;
    	 int hgt[] = new int[n];
    	 Stack<Integer> stack = new Stack<Integer>();
    	 //示例高度为05434560的时候计算可理解
    	 for(int i=0; i<m; i++){
    		 stack.clear();
    		 stack.push(-1);
    		 for(int j=0; j<n; j++){
    			 if(matrix[i][j] == '1') hgt[j]++;
    			 else hgt[j] = 0;
    		 }
    		 for(int j=0; j<n; j++){
    			 while(stack.peek() != -1 && hgt[j] < hgt[stack.peek()]){ //前一个比后一个低的时候
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
