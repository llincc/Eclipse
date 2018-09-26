package merge_k_sorted_lists;

import java.util.ArrayList;


/*ÌâÄ¿ÃèÊö

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if(lists == null || lists.size()==0) return null;
        while(lists.size()>1){
        	ArrayList<ListNode> newlist = new ArrayList<ListNode>();
        	for(int i=0; i<lists.size()/2; i++){
        	    newlist.add(mergeTwoLists(lists.get(i*2),lists.get(i*2+1)));
        	}
        	if(lists.size()%2 == 1) newlist.add(lists.get(lists.size()-1));
        	lists = newlist;
        }
        return lists.get(0);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temphead = new ListNode(-1);
        ListNode tail = temphead;
        while(l1 != null && l2 != null){
        	if(l1.val <= l2.val){
        		tail.next = l1;
        		l1 = l1.next;
        	}
        	else{
        		tail.next = l2;
        		l2 = l2.next;
        	}
        	tail = tail.next;
        }
        if(l1 != null) tail.next = l1;
        if(l2 != null) tail.next = l2;
        return temphead.next;     
    }
}
