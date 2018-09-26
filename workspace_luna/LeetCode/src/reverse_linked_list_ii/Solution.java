package reverse_linked_list_ii;
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
	val = x;
	next = null;
	}
}
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode heaD = new ListNode(-1);
    	heaD.next = head;
        int i=1;
        ListNode p = head;
        ListNode lefttail, righthead, reversetail, tmp;
        
        lefttail = heaD;
        reversetail = heaD;
        righthead = head;
        while(i<=n){
        	if(i>=m){
        	   if(i==m){
        		   reversetail = p;
        		   lefttail.next = null;
        	   }
        	   if(i==n){
        		   righthead = p.next;
        	   }
               tmp = p;
               p = p.next;
               tmp.next = lefttail.next;
               lefttail.next = tmp;
        	}
        	else{
               lefttail = p;
               p = p.next;   		
        	}
        	i++;
        }
        reversetail.next = righthead;
        return heaD.next; 
    }
}
