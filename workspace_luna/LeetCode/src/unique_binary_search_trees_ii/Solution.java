package unique_binary_search_trees_ii;

import java.util.ArrayList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

/*Ã‚ƒø√Ë ˆ

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTree(1, n);
    }
    public ArrayList<TreeNode> generateTree(int left, int right){
    	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    	if(left > right){
    		list.add(null);
    		return list;
    	}
    	if(left == right){
    		list.add(new TreeNode(left));
    		return list;
    	}
    	for(int i=left; i<=right; i++){
    		TreeNode mid;
    		ArrayList<TreeNode> leftarr = generateTree(left, i-1);
    		ArrayList<TreeNode> rigtarr = generateTree(i+1, right);
    		for(TreeNode leftNode: leftarr){
    			for(TreeNode rightNode : rigtarr){
    				mid = new TreeNode(i);
    				mid.left = leftNode;
    				mid.right = rightNode;
    				list.add(mid);
    			}
    		}
    	}
    	return list;
    }
    public int numTrees(int n) {
    	if(n==0) return 1;
    	if(n==1) return 1;
    	if(n==2) return 2;
    	int num = 0;
        for(int i=1; i<=n; i++){
        	num += numTrees(i-1) * numTrees(n-i);
        }
        return num;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().numTrees(4));
	}
}
