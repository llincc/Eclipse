package convert_sorted_array_to_binary_search_tree;

import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
	public TreeNode sortedArrayToBST(int[] num) {
        if(num == null) return null;
        return BST(num, 0, num.length-1);
    }
	private TreeNode BST(int[] num, int left, int right){
		if(left>right) return null;
		if(left == right) return new TreeNode(num[left]);
		
		int mid = (left+right+1)/2;
		TreeNode midT = new TreeNode(num[mid]);
		midT.left = BST(num, left, mid-1);
		midT.right = BST(num, mid+1, right);
		return midT;
	}
}
