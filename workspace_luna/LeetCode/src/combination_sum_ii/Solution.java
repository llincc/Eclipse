package combination_sum_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*题目描述

Given a collection of candidate numbers ( C ) and a target number ( T ), find all unique combinations in C where the candidate numbers sums to T .

Each number in C may only be used once in the combination. //只用一次

Note:

All numbers (including target) will be positive integers.
Elements in a combination (a 1, a 2, … , a k) must be in non-descending order. (ie, a 1 ≤ a 2 ≤ … ≤ a k).
The solution set must not contain duplicate combinations.

For example, given candidate set10,1,2,7,6,1,5and target8, 
A solution set is: 
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]*/
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {  	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();	
    	Arrays.sort(candidates);
    	for(int i=0; i<candidates.length && candidates[i]<=target; i++){
    		if(i!=0 && candidates[i] == candidates[i-1]) continue;
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
    		for(int i=index+1; i<candidates.length; i++){
    			if(i!=index+1 && candidates[i] == candidates[i-1]) continue;
    			combination(result, stack, candidates, target, sum + candidates[index], i);
    		}
    		stack.pop();
    	}
    }
    public static void main(String[] args) {
		int []candidates = {10,1,2,7,6,1,5};
		System.out.println(new Solution().combinationSum2(candidates, 8));
	}
    
}
