package reorder_list;

import java.util.Stack;

//L0->L1->......->Ln��ΪL0->Ln->L1->Ln-1......

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
	//ʹ��ջ�ķ���
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
	//������������ָ�����м�ڵ㣬���������ת����������ϲ�����
    public void reorderList(ListNode head) {
    	if(head == null || head.next == null) return;
    	
    	ListNode fast = head;
    	ListNode slow = head;
    	//����ָ�����м�ڵ�
    	while(fast.next != null && fast.next.next != null){
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	//�������
    	ListNode list2 = slow.next;
    	ListNode list1 = head;
    	slow.next = null;
    	
    	//��ת���������
    	ListNode temp_head = list2;
    	ListNode temp_tail = null;
    	while(list2!=null){
    		temp_head = list2;
    		list2 = list2.next;
    		temp_head.next = temp_tail;
    		temp_tail = temp_head; 		
    	}
    	list2 = temp_head;
   
    	//�ϲ�����
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
