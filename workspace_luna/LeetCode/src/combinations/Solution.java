package combinations;

import java.util.ArrayList;
import java.util.Stack;

/*题目描述

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]*/
public class Solution {
   //与subsets类似
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();
    	if(k>n) return result;
        backtrack(result, n, 1, k, stack);
        return result;
    }
    
    private void backtrack(ArrayList<ArrayList<Integer>> result,int n, int start, int len, Stack<Integer> stack){
    	if(len == 0){
    		result.add(new ArrayList<Integer>(stack));
    		return;
    	}
    	for(int i=start; i<=n-len+1; i++){
    		stack.push(i);
    		backtrack(result, n, i+1, len-1, stack);  //i+1变为start+1有惊喜
    		stack.pop();
    	} 
    }
    
    public static void main(String[] args) {
		int n = 4;
		int k = 2;
		System.out.println(new Solution().combine(n, k));
	}
    
}
