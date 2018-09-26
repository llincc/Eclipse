package sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/*ÌâÄ¿ÃèÊö

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)*/
public class Solution {
	//DFS³¬Ê±
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
        for(int sum1 = 0; sum1 < num.length; sum1++){
        	if((sum1 != 0 && num[sum1-1] == num[sum1])) continue;
        	if(num[sum1] > target && num[sum1] >= 0) break;
        	for(int sum2 = sum1+1; sum2 < num.length; sum2++){
        		if(sum2 != sum1+1 && num[sum2-1] == num[sum2]) continue;
        		if(num[sum1]+num[sum2] > target && num[sum2] >= 0) break;
        		for(int sum3 = sum2+1; sum3<num.length; sum3++){
        			if(sum3 != sum2+1 && num[sum3-1] == num[sum3]) continue;
        			if(num[sum1]+num[sum2]+num[sum3] > target && num[sum3] >= 0) break;
        			for(int sum4 = sum3+1; sum4 <num.length; sum4++){
        				if(sum4 != sum3+1 && num[sum4-1] == num[sum4]) continue;
        				if(num[sum1]+num[sum2]+num[sum3]+num[sum4] > target && num[sum4] >= 0) break;
            			if(num[sum1] + num[sum2] + num[sum3] + num[sum4] == target){
            				ArrayList<Integer> list = new ArrayList<Integer>();
            				list.add(num[sum1]);
            				list.add(num[sum2]);
            				list.add(num[sum3]);
            				list.add(num[sum4]);
            				result.add(list);
            			}		
        			}
        		}
        	}
        }
        return result;
    } 
    public static void main(String[] args) {
		int num[] = {1,0,-1,0,-2,-2,2,2};
		System.out.println(new Solution().fourSum(num, 0));
	}
}
