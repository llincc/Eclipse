package populating_next_right_pointers_in_each_node;

import java.util.LinkedList;

/*题目描述

Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.

Initially, all next pointers are set toNULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL*/

class TreeLinkNode {
   int val;
   TreeLinkNode left, right, next;
   TreeLinkNode(int x) { val = x; }
}
public class Solution {
    //法1：充分利用next
    public void connect1(TreeLinkNode root) {
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
    //
    public void connect2(TreeLinkNode root) {
    	if(root == null) return;
    	LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
    	queue.offer(root);
    	
    	TreeLinkNode lastNode;
    	while(!queue.isEmpty()){
    		lastNode = queue.poll();
    		int size = queue.size();
			if(lastNode.left!=null){
				queue.offer(lastNode.left);
				queue.offer(lastNode.right);
			}
    		TreeLinkNode node;
    		while(size>0){
    			node = queue.poll();
    			size--;
    			lastNode.next = node;
    			lastNode = node;
    			if(node.left!=null){
    				queue.offer(node.left);
    				queue.offer(node.right);
    			}		
    		}	
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
		new Solution().connect1(root);
		System.out.println(root.left.next.val);
	}
}
