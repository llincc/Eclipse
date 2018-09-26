package linked_list_cycle_ii;

import java.util.HashSet;
import java.util.Set;

//Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
//
//Follow up:
//Can you solve it without using extra space?
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
//	//����1�� ��Ƿ����ù�ϣ����������Ƿ��ʹ��Ľڵ� ===��Ҫ����ռ䣬�Һ�ʱ
//    public ListNode detectCycle(ListNode head) {
//    	if(head == null) return null;
//        Set<ListNode> hashSet = new HashSet<ListNode>();
//        ListNode temp = head;
//        while(temp.next != null){
//        	if(hashSet.contains(temp.next)) return temp.next;
//        	else{
//        		hashSet.add(temp);
//        		temp = temp.next;
//        	}
//        }
//        return null;
//    }
    
	//����2�� ����ָ�뷨
	//֤����https://www.nowcoder.com/questionTerminal/6e630519bf86480296d0f1c868d425ad
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow){
        		break;
        	}
        }
        
        if(fast == null || fast.next == null) return null;
        
        slow = head;
        while(slow != fast){
        	slow = slow.next;
        	fast = fast.next;
        }
        
        return slow;
    }
}
