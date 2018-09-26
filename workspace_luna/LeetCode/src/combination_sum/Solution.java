package combination_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*题目描述

Given a set of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

The same repeated number may be chosen from C unlimited number of times. //可以用多次

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).  //不存在重复
The solution set must not contain duplicate combinations.

For example, given candidate set2,3,6,7and target7, 
A solution set is: 
[7]
[2, 2, 3]*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {  	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();	
    	Arrays.sort(candidates);
    	for(int i=0; i<candidates.length && candidates[i]<=target; i++){
    		combination(result, stack, candidates, target, 0, i);
    	}	
    	return result;
    	
    }
    private void combination(ArrayList<ArrayList<Integer>> result, Stack<Integer> stack, int[]candidates,int target, int sum, int index){
    	if(sum + candidates[index] > target) return;
    	if(sum + candidates[index] == target){
    		stack.push(candidates[index]);
    		result.add(new ArrayList<Integer>(stack));
    		stack.pop();
    	}
    	else{
    		stack.push(candidates[index]);
    		for(int i=index; i<candidates.length; i++){
    			combination(result, stack, candidates, target, sum+candidates[index], i);
    		}
    		stack.pop();
    	}
    }
    public static void main(String[] args) {
		int []candidates = {2,3,6,7};
		System.out.println(new Solution().combinationSum(candidates, 7));
	}
    
}
