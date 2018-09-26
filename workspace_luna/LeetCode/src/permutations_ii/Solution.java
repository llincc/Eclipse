package permutations_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*ÌâÄ¿ÃèÊö

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2]have the following unique permutations:
[1,1,2],[1,2,1], and[2,1,1].

*/
public class Solution {
	 public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	boolean used[] = new boolean[num.length];
    	Arrays.sort(num);
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Stack<Integer> stack = new Stack<Integer>();
        getResult(result,num, used, stack);
        return result;
    }
    public void getResult(ArrayList<ArrayList<Integer>> result, int[]num , boolean used[], Stack<Integer> stack){
    	if(stack.size() == num.length ){
    		result.add(new ArrayList<Integer>(stack));
    		return;
    	}
    	int last = Integer.MAX_VALUE;
    	for(int i=0; i<num.length; i++){
    		if(!used[i] && num[i] != last){
    			used[i] = true;
    			stack.push(num[i]);
    			getResult(result, num, used, stack);
    			last = stack.pop();
    			used[i] = false;		
    		}
    	}
    }
    public static void main(String[] args) {
		int[]num = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2};
		System.out.println(new Solution().permuteUnique(num));
	}
}
