package binary_tree_maximum_path_sum;

import java.util.concurrent.atomic.AtomicInteger;


/*Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return6.*/
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
public class Solution {

    public int maxPathSum(TreeNode root) {
    	AtomicInteger max = new AtomicInteger(Integer.MIN_VALUE);
        maxSum(root, max);   
        return max.get();
    }
    public int maxSum(TreeNode root,AtomicInteger max){
        if(root==null) return 0;  
        int left = Math.max(0, maxSum(root.left, max)); //左右小于0就舍弃不考虑（置0）
        int right = Math.max(0, maxSum(root.right, max));
        max.set(Math.max(max.get(), left + right + root.val)); //左+右+中组合的最大值
        return root.val + Math.max(left, right); //返回本节点+左路， 本节点+右路， 本节点（必须右本节点且只能左路或者右路）中的最大值
    }
    
    public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(-3);
		treeNode.left = new TreeNode(-1);
		System.out.println(new Solution().maxPathSum(treeNode));
	}
    
}
