package rotate_list;

/*ÌâÄ¿ÃèÊö

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given1->2->3->4->5->NULLand k =2,
return4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null) return head;
        
        ListNode tail = head;
        int len = 1;
        while(tail.next!=null){
        	len ++;
        	tail = tail.next;
        }
        tail.next = head;
        
        int rum = len - (n%len);
        while(rum-->0){
        	tail = tail.next;
        }
        head = tail.next;
        tail.next = null;
        return head;  
    }
}
