package binary_tree_level_order_traversal_ii;

import java.util.ArrayList;
import java.util.LinkedList;


/*题目描述

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree{3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7

return its level order traversal as:

[
  [3],
  [9,20],
  [15,7]
]

confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".*/
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
            result.add(levelList);
        }
        return result;    
    }
}
