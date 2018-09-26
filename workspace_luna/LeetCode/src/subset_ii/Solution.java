package subset_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;


/*题目描述

Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S =[1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]*/
public class Solution {
	Comparator cmp = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 > o2 ? 1 : -1;
		}
	};
	public void qsort(int num[], int left, int right){
		if(left >= right) return;
		int i=left, j=right;
		int mid = (i + j) / 2;
		int axis = Math.min(Math.max(num[i], num[j]), num[mid]);
		int index = num[i] == axis? i: (num[j]==axis? j: mid);
		if(index != i) {
			num[index] = num[i];
			num[i] = axis;
		}
		while(i<j){
			while(i<j && num[j]>= axis) j--;
			if(i<j) num[i++] = num[j]; 
			while(i<j && num[i]< axis) i++;
			if(i<j) num[j--] = num[i];
		}
		num[i] = axis;
		qsort(num, left, i-1);
		qsort(num, i+1, right);
		
	}
//    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
//         Arrays.sort(num);
//         Stack<Integer> stack = new Stack<Integer>();
//         ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
//         DFS(num, stack, result, 0);
//         return result;
//    }
//    //左边表示不加入，右边表示加入
//    public void DFS(int[]num, Stack<Integer> stack, ArrayList<ArrayList<Integer>> result, int level){
//    	if(level == num.length){
//    		ArrayList<Integer> subset = new ArrayList<Integer>(stack);
//    	    boolean exist = false;
//    	    for(int i=0; i<result.size(); i++){
//    	    	if(exist) break;
//    	    	ArrayList<Integer> arr = result.get(i);
//    	    	if(subset.size()!=arr.size()) continue;
//    	    	boolean flag = true;
//    	    	for(int j=0; j<arr.size(); j++){
//    	    		if(!flag) break;
//    	    	    flag &= arr.get(j) == subset.get(j);
//    	    	}
//    	    	exist ^= flag;
//    	    }
//    	    if(!exist) result.add(subset);
//    		return;
//    	}
//        DFS(num, stack, result, level+1);
//        
//        stack.push(num[level]);
//        DFS(num, stack, result, level+1);
//        stack.pop();
//    }
	   public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<Integer> list=new ArrayList<Integer>();
		    Arrays.sort(num);
		    
		    for(int j=0;j<=num.length;j++) //长度从0到n，都在0开始
		    	backtracking(result, num,j,0,list);
		    return result;
	   }
	   public void backtracking(ArrayList<ArrayList<Integer>> result, int[] nums,int k,int start,ArrayList<Integer> list){
		   if(k<0) return;
		   if(k==0){
			   ArrayList<Integer> subset = new ArrayList<Integer>(list);
			   if(result.size() == 0) result.add(subset);
			   else{
				   ArrayList<Integer> last = result.get(result.size()-1);
				   
				   if(last.size() == subset.size()){
					   boolean exist = true;
					   for(int i=0; i<subset.size(); i++){
						   if(!exist) break;
						   exist &= last.get(i) == subset.get(i);
					   }
					   if(!exist) result.add(new ArrayList<Integer>(list));
				   }
				   else{
					   result.add(new ArrayList<Integer>(list));
				   }
				   
			   }
		   }
		   else {
			   for(int i=start; i<nums.length; i++){
				   list.add(nums[i]);
				   backtracking(result, nums, k-1, i+1, list);
				   list.remove(list.size()-1);
			   }
		   }
	   }
    public static void main(String[] args) {
		int num[] = {2,2,2,2,1};
//		new Solution().qsort(num, 0, num.length-1);
		System.out.println(new Solution().subsetsWithDup(num));
		
	}
   
}
