package path_sum;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
   int val;
   TreeNode left;
   TreeNode right;
   TreeNode(int x) { val = x; }
}
/*题目描述

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree andsum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
public class Solution {
	//DFS， 节点值可以为负数，所以不能通过root.val - sum > 0来减枝
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Stack<Integer> stack = new Stack<Integer>();
        DFS(root, sum, result, stack);
        return result;
    }
    private void DFS(TreeNode root, int sum, ArrayList<ArrayList<Integer>> result, Stack<Integer> stack){
    	if(root==null) return;
    	if(root.left == null && root.right == null && sum == root.val){
    		stack.push(root.val);
    		result.add(new ArrayList<Integer>(stack));
    		stack.pop();
    		return;
    	}
    	stack.push(root.val);
    	DFS(root.left, sum-root.val, result, stack);
    	DFS(root.right, sum-root.val, result, stack);
    	stack.pop();
    }
}
