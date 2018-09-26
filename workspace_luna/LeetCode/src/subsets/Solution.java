package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;


/*题目描述

Given a set of distinct integers, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.

For example,
If S =[1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]*/
public class Solution {
//    public ArrayList<ArrayList<Integer>> subsets(int[] num) {
//         Arrays.sort(num);
//         Stack<Integer> stack = new Stack<Integer>();
//         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//         DFS(num, stack, result, 0);
//         return result;
//    }
//    //左边表示不加入，右边表示加入
//    public void DFS(int[]num, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result, int level){
//    	if(level == num.length){
//    	    result.add(new ArrayList<Integer>(stack));
//    		return;
//    	}
//        DFS(num, stack, result, level+1);
//      
//        stack.push(num[level]);
//        DFS(num, stack, result, level+1);
//        stack.pop();
//    }
   public ArrayList<ArrayList<Integer>> subsets(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Integer> list=new ArrayList<Integer>();
	    Arrays.sort(num);
	    for(int j=0;j<=num.length;j++) //长度从0到n，都在0开始
	    	backtracking(result, num,j,0,list);
	    return result;
   }
   public void backtracking(ArrayList<ArrayList<Integer>> result, int[] nums,int k,int start,ArrayList<Integer> list){
	   if(k<0) return;
	   if(k==0) result.add(new ArrayList<Integer>(list));
	   else {
		   for(int i=start; i<nums.length; i++){
			   list.add(nums[i]);
			   backtracking(result, nums, k-1, i+1, list);
			   list.remove(list.size()-1);
		   }
	   }
   }
    
    public static void main(String[] args) {
		int num[] = {2,1};
//		new Solution().qsort(num, 0, num.length-1);
		System.out.println(new Solution().subsets(num));
		
	}
   
}
