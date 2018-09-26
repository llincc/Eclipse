package binary_tree_postorder_traversal;

import java.util.ArrayList;
import java.util.Stack;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	//后续遍历--->递归方式
//    public ArrayList<Integer> postorderTraversal(TreeNode root) {
//        ArrayList<Integer>  traversalList = new ArrayList<Integer>();
//        
//        postTraval(root, traversalList);
//        
//        return traversalList;
//    }
//    public void postTraval(TreeNode root, ArrayList<Integer> list){
//    	if(root == null) return;
//    	postTraval(root.left, list);
//    	postTraval(root.right, list);
//    	list.add(root.val);
//    }
    
	//后续遍历——非递归
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>  traversalList = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode r = null;
        while(p!=null || !stack.isEmpty()){
            if(p != null){ //先把左节点压入栈
            	stack.push(p);
            	p = p.left;
            }
            else{ //当左节点为null时，先不着急弹出父节点，而是查看父节点的右节点是否为null且是否被遍历了
            	  //如果没有，则将右节点压入栈，继续顺着右节点的左节点找
            	p = stack.peek();
            	if(p.right!=null && p.right != r){
            		p = p.right;
            		stack.push(p);
            		p = p.left;
            	}
            	else{
            		p = stack.pop();
            		traversalList.add(p.val);
            		r = p;
            		p = null;
            	}
            }
        	
        }
        
        return traversalList;
    }
}
