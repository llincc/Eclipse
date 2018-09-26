package binary_tree_zigzag_level_order_traversal;

import java.util.ArrayList;
import java.util.LinkedList;


/*Ã‚ƒø√Ë ˆ

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree{3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root==null) return result;
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(root);
	    int depth = 0;
	    while(!queue.isEmpty()){
	    	ArrayList<Integer> levelList = new ArrayList<Integer>();
	    	int size = queue.size();
	    	
	    	LinkedList<TreeNode> levelqueue = new LinkedList<TreeNode>();
	    	while(size!=0){
	    		TreeNode cur;
	    		cur =  queue.pollLast();
	    		levelList.add(cur.val);
	    		size--;
	    		if(depth%2 == 1){
	    			if(cur.right!= null) levelqueue.offer(cur.right);
	    			if(cur.left != null) levelqueue.offer(cur.left);
	    		}
	    		else{
		            if(cur.left != null) levelqueue.offer(cur.left);	
		            if(cur.right!= null) levelqueue.offer(cur.right);
	    		}
               
	    	}
	        queue.addAll(levelqueue);
	    	result.add(levelList);
	    	depth++;
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(new Solution().zigzagLevelOrder(root));
	}
}
