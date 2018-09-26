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
	//��������--->�ݹ鷽ʽ
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
    
	//�������������ǵݹ�
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer>  traversalList = new ArrayList<Integer>();
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode r = null;
        while(p!=null || !stack.isEmpty()){
            if(p != null){ //�Ȱ���ڵ�ѹ��ջ
            	stack.push(p);
            	p = p.left;
            }
            else{ //����ڵ�Ϊnullʱ���Ȳ��ż��������ڵ㣬���ǲ鿴���ڵ���ҽڵ��Ƿ�Ϊnull���Ƿ񱻱�����
            	  //���û�У����ҽڵ�ѹ��ջ������˳���ҽڵ����ڵ���
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
