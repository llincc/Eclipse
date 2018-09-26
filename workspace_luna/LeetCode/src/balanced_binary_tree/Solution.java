package balanced_binary_tree;

/*题目描述

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
of the two subtrees of every node never differ by more than 1.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	boolean isbalance;
    public boolean isBalanced(TreeNode root) {
    	isbalance = true;
    	balancd(root);
        return isbalance;
    }
    private int balancd(TreeNode root){
    	if(!isbalance) return 0; //如果有子树不平衡了，就停止遍历了
    	if(root == null) return 0;
    	int left = balancd(root.left);
    	int right = balancd(root.right);
    	if(Math.abs(left-right) > 1){
    		isbalance = false;
    		return 0;
    	}
    	return 1 + Math.max(left, right);
    }
}
