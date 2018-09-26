package binary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
//	//先序遍历--->递归方式
//	public ArrayList<Integer> preorderTraversal(TreeNode root)  {
//        ArrayList<Integer>  traversalList = new ArrayList<Integer>();
//        
//        preTraval(root, traversalList);
//        
//        return traversalList;
//    }
//    public void preTraval(TreeNode root, ArrayList<Integer> list){
//    	if(root == null) return;
//    	list.add(root.val);
//    	preTraval(root.left, list);
//    	preTraval(root.right, list);
//    }
    
	//先序遍历——非递归
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer>  traversalList = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p;
        if(root==null) return traversalList;
        stack.push(root);
        while(!stack.isEmpty()){
            p = stack.pop();
            traversalList.add(p.val);
            if(p.right != null) stack.push(p.right);
            if(p.left != null) stack.push(p.left);
        }
        
        return traversalList;
    }
}
