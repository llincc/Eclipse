package construct_binary_tree_from_preorder_and_inorder_traversal;


/*ÌâÄ¿ÃèÊö

Given preorder and inorder traversal of a tree, construct the binary tree.

Note: 
You may assume that duplicates do not exist in the tree.

*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	int preindex;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder == null) return null;
        preindex = -1;
        return bt(preorder, inorder, 0, preorder.length-1);
    }
    
    private TreeNode bt(int[]preorder,  int[]inorder, int left, int right){  
    	if(left > right) return null;
    	preindex++;
    	if(preindex==preorder.length) return null;
    	if(left == right) return new TreeNode(inorder[left]);
    	int mid;
    	for(mid=left; preorder[preindex] != inorder[mid]; mid++);
    	
    	TreeNode midT = new TreeNode(preorder[preindex]);
    	midT.left = bt(preorder, inorder, left, mid-1);
    	midT.right = bt(preorder, inorder, mid+1, right);
    	return midT;  	
    }
}
