package recover_binary_search_tree;
/*题目描述

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note: 
A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	//使用8 9 10 5 7 6 11即可意会
	TreeNode firstElem = null, secondElem = null;
	TreeNode preElem = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        inOrderTraverse(root);
        firstElem.val ^= secondElem.val;
        secondElem.val ^= firstElem.val;
        firstElem.val ^= secondElem.val;
    }
    private void inOrderTraverse(TreeNode root){
    	if(root == null) return;
    	inOrderTraverse(root.left);
    	if(firstElem == null && preElem.val >= root.val) firstElem = preElem;
    	if(firstElem != null && preElem.val >= root.val) secondElem = root;
    	preElem = root;
    	inOrderTraverse(root.right);
    }
}
