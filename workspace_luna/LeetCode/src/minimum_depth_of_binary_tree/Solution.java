package minimum_depth_of_binary_tree;

import java.util.LinkedList;


public class Solution {
//	public int run(TreeNode root){
//		int depth = 0;
//		if(root == null){
//			return depth;
//		}
//	
//		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
////		Deque<E>
//		depth = 1;
//		TreeNode last;  //标识一层的最后一个元素
//		TreeNode now;
//		last = now = root;
//		
//		queue.offer(root);
//		
//		while(!queue.isEmpty()){
//			now = queue.peek();
//  			queue.poll();
//	        if(now.left == null && now.right == null) break; //找到叶节点了
//	        if(now.left!=null) queue.offer(now.left);
//	        if(now.right!=null) queue.offer(now.right);
//	        
//	        if(last==now){ //如果当前元素是一层的最后一个元素
//	        	depth++;//层数+1
//	        	if(!queue.isEmpty()) last = queue.getLast();
//	        }
//  		}
//		
//		return depth;
//	}
	public int run(TreeNode root){
	    if(root == null) return 0;
	    if(root.left == null && root.right == null) return 1; //叶节点
	    if(root.left == null) return run(root.right)+1;
	    if(root.right== null) return run(root.left) +1;
	    return Math.min(run(root.left), run(root.right))+1;
	}
	
	
}
