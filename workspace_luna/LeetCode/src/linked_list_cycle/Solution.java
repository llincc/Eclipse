package linked_list_cycle;

import java.util.HashSet;
import java.util.Set;

//Given a linked list, determine if it has a cycle in it.
//
//Follow up:
//Can you solve it without using extra space?
//������ȷ���ǣ���Ϊ�����ǵ����������л�Ҳ��Ȼ�����һ���ڵ�ָ��ǰ��ĳ���ڵ�����˻����������м�ĳ���ڵ�֮ǰ��ǰ��Ľڵ㣩
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	//����1�� ��Ƿ����ù�ϣ����������Ƿ��ʹ��Ľڵ� ===��Ҫ����ռ�
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
    
	//����2������ָ�뷨
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
