package sum_root_to_leaf_numbers;

/*Given a binary tree containing digits from0-9only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path1->2->3which represents the number123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3

The root-to-leaf path1->2represents the number12.
The root-to-leaf path1->3represents the number13.

Return the sum = 12 + 13 =25.*/

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumTree(root, 0);
    }
    
    public int sumTree(TreeNode root, int sum){
    	if(root == null) return 0;
    	if(root.left == null && root.right == null) return sum * 10 + root.val;
    	return sumTree(root.left, sum * 10 + root.val) + sumTree(root.right, sum * 10 + root.val);
    }
    
    public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.right = new TreeNode(3);
		System.out.println(new Solution().sumNumbers(treeNode));
	}
}