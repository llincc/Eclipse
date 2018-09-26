package symmetric_tree;

/*
Ã‚ƒø√Ë ˆ

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3

But the following is not:

    1
   / \
  2   2
   \   \
   3    3*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
//    public boolean isSymmetric(TreeNode root) {
//    	if(root == null) return true;
//        StringBuffer buffer1 = new StringBuffer("");
//        StringBuffer buffer2 = new StringBuffer("");
//        lmidorder(root.left, buffer1);
//        rmidorder(root.right, buffer2 );
//        System.out.println(buffer1.toString());
//        System.out.println(buffer2.toString());
//        return buffer1.toString().equals(buffer2.toString());
//        
//    }
//    public void lmidorder(TreeNode root, StringBuffer buffer){
//    	if(root == null) {
//    		buffer.append("#");
//    		return;
//    	}
//    	buffer.append("_"+root.val);
//    	if(root.left==null && root.right == null) return;
//    	lmidorder(root.left, buffer);	
//    	lmidorder(root.right, buffer);
//    }
//    public void rmidorder(TreeNode root, StringBuffer buffer){
//    	if(root == null){
//    		buffer.append("#");
//    		return;
//    	}
//    	buffer.append("_"+root.val);
//    	if(root.left==null && root.right == null) return;
//    	rmidorder(root.right, buffer);
//    	rmidorder(root.left, buffer);
//    }
    
	public boolean isSymmetric(TreeNode root) {
	    if(root == null) return true;
	    return sym(root.left, root.right);
	}
    private boolean sym(TreeNode root1, TreeNode root2){
    	if(root1 == null && root2 == null) return true;
    	if(root1 == null || root2 == null) return false;
    	return root1.val == root2.val && sym(root1.left, root2.right) && sym(root1.right, root2.left);
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(4);
		root.left.right.left = new TreeNode(8);
		root.left.right.right = new TreeNode(9);
		root.right.left.left = new TreeNode(9);
		root.right.left.right = new TreeNode(8);
		new Solution().isSymmetric(root);
	}
}
