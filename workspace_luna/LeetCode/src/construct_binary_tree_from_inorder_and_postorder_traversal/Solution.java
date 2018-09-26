package construct_binary_tree_from_inorder_and_postorder_traversal;


/*

题目描述

Given inorder and postorder traversal of a tree, construct the binary tree.

Note: 
You may assume that duplicates do not exist in the tree.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	int postindex;
	//后序遍历倒过来就是 先右子树的先序遍历
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(inorder==null) return null;
        postindex = postorder.length;
        return bt(inorder, postorder, 0, inorder.length-1);    
    }
    
    private TreeNode bt(int[] inorder, int[] postorder, int left, int right){  
    	if(left > right) return null;
    	postindex--;
    	if(postindex < 0) return null;
    	if(left == right) return new TreeNode(inorder[left]);
    	int mid;
    	for(mid=left; postorder[postindex] != inorder[mid]; mid++);
    	TreeNode midT = new TreeNode(postorder[postindex]);
    	midT.right = bt(inorder, postorder, mid+1, right);
    	midT.left = bt( inorder, postorder, left, mid-1);
    	return midT;  	
    }
    
    public static void main(String[] args) {
		int inorder[] = {1,2};
		int postorder[] = {2,1};
		new Solution().buildTree(inorder, postorder);
	}
}
