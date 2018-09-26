package container_with_most_water;
/*题目描述

Given n non-negative integers a1 , a2 , ..., an , where each represents a point at coordinate (i, ai ). n vertical lines are drawn such that the two endpoints of line i is at (i, ai ) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.*/
public class Solution {
    public int maxArea1(int[] height) {
    	int maxvalue = 0;
        for(int i=0; i<height.length-2; i++){
        	for(int j=i+1; j<height.length; j++){
        		maxvalue = Math.max((j-i)*Math.min(height[i], height[j]), maxvalue);
        	}
        }
        return maxvalue;
    }
    /*链接：https://www.nowcoder.com/questionTerminal/c97c1400a425438fb130f54fdcef0c57
    	来源：牛客网

    	这题最关键的是两点，一是两边往中间找，二是每次放弃最短的版。
    	这么做的原因在于：从起点和终点开始找，宽度最大，这时每移动一次其中一个点，必然宽度变小。
    	如此一来，想求最大，只有高度增长才有可能做到，去掉限制----短板，即放弃高度较小的点。*/
    public int maxArea(int[] height) {
    	int maxvalue = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<right){
        	if(height[left] <= height[right]){
        		maxvalue = Math.max((right-left)*height[left++], maxvalue);
        	}
        	else{
        		maxvalue = Math.max((right-left)*height[right--], maxvalue);
        	}
        }
        return maxvalue;
    }
}
