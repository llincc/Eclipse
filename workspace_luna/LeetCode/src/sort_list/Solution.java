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
//	   //链表排序——>插入排序， 时间复杂度O(n^2)，空间复杂度O(1)
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
//    	   if(tempNode == curNode) curPreNode = curNode; //curNode位置不变
//    	   else{ //将curNode插入
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
	
	
    //二路归并排序
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
        while(head!=null){ //计算长度
        	len ++;
        	head = head.next;
        }
	    if(len < 2) return conHead;
	    
	    ListNode lista = conHead;
	    ListNode listb = conHead;
	    
	    //将一条链表拆成lista , listb两条链表
	    for(int i = 0; i< len/2; i++){ 
	       if(i == len/2 - 1) head = listb;
	       listb = listb.next;
	    }
	    head.next = null; //lista最后加上null，与listb断开
	    
	    lista = sortList(lista);
	    listb = sortList(listb);
        head = Merge(lista, listb);
	    
	    return head;
    }	
}