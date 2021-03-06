package sum3_closest;

import java.util.Arrays;

/*��Ŀ����

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).*/
public class Solution {
    public int threeSumClosest(int[] num, int target) {
    	Arrays.sort(num);
    	int closevalue = num[0]+num[1]+num[2];
        for(int i=0; i<num.length-2; i++){
        	int left = i+1;
        	int right = num.length-1;
        	int sum = 0;
        	while(left<right){
        		sum = num[i] + num[left] + num[right];
        		if(sum == target) return target;
        		if(Math.abs(sum - target) < Math.abs(closevalue - target)){
        			closevalue = sum;
        		}
        		if(sum > target)right--;
        		else left++;
        	}
        }
        return closevalue;
    }
}
