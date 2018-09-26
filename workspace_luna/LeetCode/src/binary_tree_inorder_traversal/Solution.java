package binary_tree_inorder_traversal;

import java.util.ArrayList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inOrder(root, result);
        return result;
    }
    
    private void inOrder(TreeNode root, ArrayList<Integer> result){
    	if(root == null) return;
    	inOrder(root.left, result);
    	result.add(root.val);
    	inOrder(root.right, result);
    }
}
