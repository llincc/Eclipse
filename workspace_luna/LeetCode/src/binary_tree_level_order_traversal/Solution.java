package binary_tree_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;


/*题目描述

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree{3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7]
  [9,20],
  [3],
]*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	//宽度优先
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) { 	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if(root==null) return result;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
        	ArrayList<Integer> levelList = new ArrayList<Integer>();
        	int size = queue.size();
        	while(size!=0){
        		TreeNode cur = queue.poll();
        		levelList.add(cur.val);
        		size--;
        		if(cur.left != null) queue.offer(cur.left);
        		if(cur.right!= null) queue.offer(cur.right);
        	}
            result.add(0,levelList);
        }
        return result;    
    }
}
