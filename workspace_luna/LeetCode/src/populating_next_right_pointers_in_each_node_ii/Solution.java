	package populating_next_right_pointers_in_each_node_ii;

import java.util.LinkedList;

/*题目描述

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.

For example,
Given the following binary tree,

         1
       /  \
      2    3
     / \    \
    4   5    7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL*/

class TreeLinkNode {
   int val;
   TreeLinkNode left, right, next;
   TreeLinkNode(int x) { val = x; }
}
public class Solution {
    public void connect1(TreeLinkNode root) {
    	if(root == null) return;
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.offer(root);
    	
    	TreeLinkNode lastNode;
    	while(!queue.isEmpty()){
    		lastNode = queue.poll();
    		int size = queue.size();
			if(lastNode.left!=null) queue.offer(lastNode.left);
			if(lastNode.right!=null)queue.offer(lastNode.right);
			
    		TreeLinkNode node;
    		while(size>0){
    			node = queue.poll();
    			size--;
    			lastNode.next = node;
    			lastNode = node;
    			if(node.left!=null) queue.offer(node.left);
    			if(node.right!=null)queue.offer(node.right);	
    		}	
    	}
    }
    
    //法二
    public void connect(TreeLinkNode root) {
    	while(root!=null){
    		TreeLinkNode tempFirst = new TreeLinkNode(0); //root的下一层新建一个头结点
    		TreeLinkNode cur = tempFirst;
    		while(root!=null){
    			if(root.left != null){
    				cur.next = root.left;
    				cur = cur.next;
    			}
    			if(root.right != null){
    				cur.next = root.right;
    				cur = cur.next;
    			}
    			root = root.next;
    		}
    		root = tempFirst.next;
    	}
    }
    
    public static void main(String[] args) {
		TreeLinkNode root = new TreeLinkNode(1);
		root.left = new TreeLinkNode(2);
		root.right = new TreeLinkNode(3);
		root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        root.left.left.left = new TreeLinkNode(8);
        root.left.left.right = new TreeLinkNode(9);
        root.left.right.left = new TreeLinkNode(10);
        root.left.right.right = new TreeLinkNode(11);
        root.right.left.left = new TreeLinkNode(12);
        root.right.left.right = new TreeLinkNode(13);
        root.right.right.left = new TreeLinkNode(14);
        root.right.right.right = new TreeLinkNode(15);
		new Solution().connect(root);
		System.out.println(root.left.next.val);
	}
}
