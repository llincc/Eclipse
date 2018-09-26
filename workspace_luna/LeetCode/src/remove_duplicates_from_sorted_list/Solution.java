package remove_duplicates_from_sorted_list;
/*ÌâÄ¿ÃèÊö

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given1->1->2, return1->2.
Given1->1->2->3->3, return1->2->3.*/
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
        ListNode HEAD = new ListNode(Integer.MAX_VALUE);
        HEAD.next =  head;
        ListNode pre = HEAD, temp=head;
        while(temp!=null){
        	if(pre.val == temp.val){
        		temp = temp.next;
        		pre.next = temp;
        	}
        	else{
        		pre = temp;
        		temp = temp.next;
        	}
        }
        return HEAD.next;
    }
}
