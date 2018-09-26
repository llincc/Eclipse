package remove_duplicates_from_sorted_list_ii;
/*ÌâÄ¿ÃèÊö

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given1->2->3->3->4->4->5, return1->2->5.
Given1->1->1->2->3, return2->3.*/
class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) {
	 val = x;
	 next = null;
	 }
}
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
    	if(head == null || head.next == null) return head;
        ListNode HEAD = new ListNode(Integer.MAX_VALUE);
        HEAD.next =  head;
        ListNode pre = HEAD, start=head, temp = head.next;
        while(temp!=null){
        	if(start.val == temp.val){
        		temp = temp.next;
        	}
        	else{
        		if(start.next != temp) pre.next = temp;
        		else pre = pre.next;
        		start = temp;
        		temp = temp.next;
        	}
        }
        if(start.next!=null) pre.next = temp;
        return HEAD.next;
    }
}
