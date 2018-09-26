package partition_list;

/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lesshead = new ListNode(-1);
        ListNode morehead = new ListNode(-1);
        ListNode tmp, lesstail=lesshead, moretail=morehead;
        while(head!=null){
    		tmp = head;
    		head = head.next;
        	if(tmp.val<x){
        		lesstail.next = tmp;
        		lesstail = tmp;
        		lesstail.next = null;
        	}
        	else{
        		moretail.next = tmp;
        		moretail = tmp;
        		moretail.next = null;
        	}
        }
        lesstail.next = morehead.next;
        return lesshead.next;
    }
}
