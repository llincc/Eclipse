package reverse_nodes_in_k_group;


/*ÌâÄ¿ÃèÊö

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list:1->2->3->4->5

For k = 2, you should return:2->1->4->3->5

For k = 3, you should return:3->2->1->4->5*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	val = x;
	next = null;
	}
}
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
    	if(head == null) return null;
    	ListNode temphead = new ListNode(0);
    	ListNode tail = temphead;
    	ListNode headtail = temphead;
    	ListNode temp = head;
    	int count = 0;
        while(temp.next!=null && temp.next.next!=null){
        	temp = temp.next.next;
        	count++;
        }
        if(temp.next == null) count = count * 2 + 1;
        else count = count * 2 + 2;      
        for(int i=0; i<count/k; i++){
        	tail = head;       	
            for(int j=0; j<k; j++){   	
            	temp = head;
            	head = head.next;	
            	temp.next = headtail.next;
            	headtail.next = temp;
            }  
            headtail = tail;
        }
        tail.next = head;
        return temphead.next;
    }
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		new Solution().reverseKGroup(head, 2);
	}
}
