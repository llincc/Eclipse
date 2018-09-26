package add_two_numbers;

/*ÌâÄ¿ÃèÊö

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8*/
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; next = null; }
}
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int c = 0;
        ListNode temphead = new ListNode(-1);
        temphead.next = l1;
        ListNode temp = temphead;
        while(l1!=null && l2 != null){
        	c = l1.val + l2.val + c;      	
        	temp.next = new ListNode(c % 10);
        	temp = temp.next;       	
        	l1 = l1.next;
        	l2 = l2.next;
        	c = c / 10;
        }
        temp.next = l1 == null? l2: l1;
        while(temp.next!=null){
        	c = temp.next.val + c;     	
        	temp.next.val = c % 10;
        	temp = temp.next;
        	c = c / 10;
        }
        if(c != 0) temp.next = new ListNode(c);
        return temphead.next;    
    }
}
