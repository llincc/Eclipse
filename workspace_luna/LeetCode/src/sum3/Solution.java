package sum3;

import java.util.ArrayList;
import java.util.Arrays;

/*ÌâÄ¿ÃèÊö

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ¡Ü b ¡Ü c)
The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
        for(int sum1 = 0; sum1 < num.length; sum1++){
        	if((sum1 != 0 && num[sum1-1] == num[sum1])) continue;
        	if(num[sum1] > 0) break;
        	for(int sum2 = sum1+1; sum2 < num.length; sum2++){
        		if(sum2 != sum1+1 && num[sum2-1] == num[sum2]) continue;
        		if(num[sum1]+num[sum2] > 0) break;
        		for(int sum3 = sum2+1; sum3<num.length; sum3++){
        			if(sum3 != sum2+1 && num[sum3-1] == num[sum3]) continue;
        			if(num[sum1]+num[sum2]+num[sum3] > 0) break;
        			if(num[sum1] + num[sum2] + num[sum3] == 0){
        				ArrayList<Integer> list = new ArrayList<Integer>();
        				list.add(num[sum1]);
        				list.add(num[sum2]);
        				list.add(num[sum3]);
        				result.add(list);
        			}
        		}
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		int []num = {-4,-1, 0, 1, 2, -1, 4};
		System.out.println(new Solution().threeSum(num));
	}
}
