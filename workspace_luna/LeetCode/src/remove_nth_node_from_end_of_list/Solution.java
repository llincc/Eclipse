package remove_nth_node_from_end_of_list;


/*ÌâÄ¿ÃèÊö

Given a linked list, remove the n th node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note: 
Given n will always be valid.
Try to do this in one pass.

*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	val = x;
	next = null;
	}
}
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temphead = new ListNode(-1);
        temphead.next = head;
        ListNode temp = temphead;
        while(n-->1 && head != null){
        	head = head.next;
        }
        if(n > 1) return  head;
        while(head.next!=null){
        	head = head.next;
        	temp = temp.next;
        }
        temp.next = temp.next.next;
        return temphead.next;
    }
}
