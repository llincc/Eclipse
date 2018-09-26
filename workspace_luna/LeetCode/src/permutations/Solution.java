package permutations;

import java.util.ArrayList;
import java.util.Stack;

/*题目描述

题目描述

Given a collection of numbers, return all possible permutations.

For example,
[1,2,3]have the following permutations:
[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2], and[3,2,1].*/
public class Solution {
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
    	boolean used[] = new boolean[num.length];
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();
        getResult(result,num, used, stack, 0);
        return result;
    }
    public void getResult(ArrayList<ArrayList<Integer>> result, int[]num , boolean used[], Stack<Integer> stack, int count){
    	if(count == num.length ){
    		result.add(new ArrayList<Integer>(stack));
    	}
    	for(int i=0; i<num.length; i++){
    		if(!used[i]){
    			used[i] = true;
    			stack.push(num[i]);
    			getResult(result, num, used, stack, count+1);
    			stack.pop();
    			used[i] = false;		
    		}
    	}
    }
}
