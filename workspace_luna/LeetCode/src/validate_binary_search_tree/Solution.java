package validate_binary_search_tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
/*ÌâÄ¿ÃèÊö

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.*/
public class Solution {
	boolean isBST = true;
    TreeNode preNode = null;
    public boolean isValidBST(TreeNode root) {
        inOrderTraverse(root);
        return isBST;
    }
    public void inOrderTraverse(TreeNode root){
    	if(!isBST) return;
    	if(root == null) return;
    	
    	inOrderTraverse(root.left);
    	
    	if(preNode != null && preNode.val >= root.val){
    		isBST = false;
    		return;
    	}
    	preNode = root;
    	
    	inOrderTraverse(root.right);
    	
    }
}
