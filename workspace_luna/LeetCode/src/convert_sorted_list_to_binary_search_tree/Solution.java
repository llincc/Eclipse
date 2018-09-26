package convert_sorted_list_to_binary_search_tree;


/*Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
   	    if(head == null) return null;
   	    if(head.next == null) return new TreeNode(head.val);
        ListNode fast,mid,pre;
        fast = mid = head;
        pre = null;
        while(fast!=null && fast.next != null){
            pre = mid;
	       	fast = fast.next.next;
	        mid = mid.next;
        }
        pre.next = null;
        TreeNode midT = new TreeNode(mid.val);
        midT.left = sortedListToBST(head);
        midT.right = sortedListToBST(mid.next);
        return midT;
    }
}
