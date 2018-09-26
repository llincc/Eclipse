package sort_list;



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
//   public ListNode sortList(ListNode head) {
//	   //�������򡪡�>�������� ʱ�临�Ӷ�O(n^2)���ռ临�Ӷ�O(1)
//       if(head == null || head.next == null) return head;
//       
//       
//       ListNode startNode = new ListNode(0);
//       ListNode curNode = head.next;
//       ListNode curPreNode = head;
//       startNode.next = head;
//       
//       
//       while(curNode != null){
//    	
//    	   
//    	   ListNode preNode = startNode;
//    	   ListNode tempNode = startNode.next;
//
//    	   while(tempNode != curNode && curNode.val >= tempNode.val){
//    		   preNode = preNode.next;
//    		   tempNode = tempNode.next;
//    	   }
//    	   if(tempNode == curNode) curPreNode = curNode; //curNodeλ�ò���
//    	   else{ //��curNode����
//    		   curPreNode.next = curNode.next; 
//    		   preNode.next = curNode;
//    		   curNode.next = tempNode;
//    	   }
//    	   
//    	   curNode = curPreNode.next;
//       }
//       head = startNode.next;
//	   
//	   return head;
//   }
	
	
    //��·�鲢����
	public ListNode Merge(ListNode lista, ListNode listb){
	    ListNode head = new ListNode(0);
	    ListNode conHead = head;
	    while(lista != null && listb != null){
	    	if(lista.val <= listb.val){
	    		head.next = lista;
	    		lista = lista.next;
	    	}
	    	else{
	    		head.next = listb;
	    		listb = listb.next;
	    	}
	    	head = head.next;
	    }
	    if(lista != null) head.next = lista;
	    if(listb != null) head.next = listb;
	    return conHead.next;
	}
	
    public ListNode sortList(ListNode head) {
	    
    	ListNode conHead = head;
        int len = 0;
        while(head!=null){ //���㳤��
        	len ++;
        	head = head.next;
        }
	    if(len < 2) return conHead;
	    
	    ListNode lista = conHead;
	    ListNode listb = conHead;
	    
	    //��һ��������lista , listb��������
	    for(int i = 0; i< len/2; i++){ 
	       if(i == len/2 - 1) head = listb;
	       listb = listb.next;
	    }
	    head.next = null; //lista������null����listb�Ͽ�
	    
	    lista = sortList(lista);
	    listb = sortList(listb);
        head = Merge(lista, listb);
	    
	    return head;
    }	
}