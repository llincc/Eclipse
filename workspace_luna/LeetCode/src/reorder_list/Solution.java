package reorder_list;

import java.util.Stack;

//L0->L1->......->Ln变为L0->Ln->L1->Ln-1......

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	//使用栈的方法
//    public void reorderList(ListNode head) {
//    	if(head == null) return;
//        Stack<ListNode> stack = new Stack<ListNode>();
//        
//        ListNode temp = head;
//        while(temp != null){
//            stack.push(temp);
//            temp = temp.next;
//        }
//        ListNode startNode = head;
//        ListNode p;
//        while(true){
//        	p = stack.pop();
//        	p.next = null;
//        	if(startNode == p || startNode.next == p){
//        		break;
//        	}
//        	p.next = startNode.next;
//        	startNode.next = p;
//        	startNode = p.next;
//        }
//    }
	//方法二：快慢指针找中间节点，拆分链表，反转后面的链表，合并链表
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null) return;
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	//快慢指针找中间节点
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//拆分链表
    	ListNode list2 = slow.next;
    	ListNode list1 = head;
    	slow.next = null;
    	
    	//反转后面的链表
    	ListNode temp_head = list2;
    	ListNode temp_tail = null;
    	while(list2!=null){
    		temp_head = list2;
    		list2 = list2.next;
    		temp_head.next = temp_tail;
    		temp_tail = temp_head; 		
    	}
    	list2 = temp_head;
   
    	//合并链表
    	temp_tail = list1;
    	temp_head = list2;
    	while(list2 != null){
    		temp_head = list2;
    		list2 = list2.next;
    		temp_head.next = temp_tail.next;
    		temp_tail.next = temp_head;
    		temp_tail = temp_head.next;
    	}   		
    }
}
