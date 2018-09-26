package swap_nodes_in_pairs;

/*ÌâÄ¿ÃèÊö

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given1->2->3->4, you should return the list as2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	val = x;
	next = null;
	}
}
public class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode temphead = new ListNode(0);
        ListNode temptail = temphead;
        ListNode temp1, temp2;
        while(head!=null && head.next != null){
        	temp1 = head;
        	temp2 = head.next;
        	head  = head.next.next;
        	temp1.next = head;
        	temp2.next = temp1;
        	temptail.next = temp2;
        	temptail = temp1;
        }
        temptail.next = head;
        return temphead.next;
    }
}
