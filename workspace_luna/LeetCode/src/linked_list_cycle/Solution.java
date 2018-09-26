package linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?
//必须明确的是，因为链表是单链表，所以有环也必然是最后一个节点指向前面某个节点产生了环（不可能中间某个节点之前它前面的节点）
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	//方法1： 标记法：用哈希表或者数组标记访问过的节点 ===需要额外空间
//	public boolean hasCycle(ListNode head) {
//    	if(head == null) return false;
//        Set<ListNode> hashSet = new HashSet<ListNode>();
//        ListNode temp = head;
//        while(temp.next != null){
//        	if(hashSet.contains(temp.next)) return true;
//        	else{
//        		hashSet.add(temp);
//        		temp = temp.next;
//        	}
//        }
//        return false;
//    }
    
	//方法2：快慢指针法
	public boolean hasCycle(ListNode head) { 
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        	if(fast == slow) return true;
        }
        
        return false;
    }
}
