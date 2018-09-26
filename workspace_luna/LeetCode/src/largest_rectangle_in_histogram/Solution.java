package largest_rectangle_in_histogram;

import java.util.Stack;

/*��Ŀ����

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.



Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].




The largest rectangle is shown in the shaded area, which has area =10unit.


For example,
Given height =[2,1,5,6,2,3],
return10.

*/
public class Solution {
    public int largestRectangleArea(int[] height) {
   	 if(height == null) return 0;	 
	 int max = 0;
	 Stack<Integer> stack = new Stack<Integer>();
	 stack.push(-1);
	 //ʾ���߶�Ϊ05434560��ʱ���������
	 for(int i=0; i<height.length; i++){
		 while(stack.peek() != -1 && height[i] < height[stack.peek()]){ //ǰһ���Ⱥ�һ���͵�ʱ��
		      int top = stack.pop();
			  max = Math.max(max, (i - 1 - stack.peek())*height[top]);
		 }
	     stack.push(i);
	 }
	 while (stack.peek()!=-1) {
		 int top = stack.pop();
		 max = Math.max(max, (height.length - 1 - stack.peek())*height[top]);
	 }
	 return max;	
    }
}
