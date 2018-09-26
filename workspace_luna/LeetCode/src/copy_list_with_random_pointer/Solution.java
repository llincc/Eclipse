package copy_list_with_random_pointer;

//A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
//
//Return a deep copy of the list.
class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
};
public class Solution {
	
	
//    public RandomListNode copyRandomList(RandomListNode head) {
//    	Map<RandomListNode, RandomListNode> old_new_map = new HashMap<RandomListNode, RandomListNode>();
//    	return deepCopy(head, old_new_map);
//    }
//    
    //复杂版,有点小问题
//    public RandomListNode deepCopy(RandomListNode head, Map<RandomListNode, RandomListNode> old_new_map){
//    	if(head == null) return null;
//    	if(old_new_map.containsKey(head)) return old_new_map.get(head);
//
//        RandomListNode head_copy = new RandomListNode(head.label);
//        old_new_map.put(head, head_copy);
//        
//        RandomListNode temp_head_copy = head_copy;
//        
//        RandomListNode next = head.next;
//        RandomListNode random = head.random;
//        
//        while (next != null && ! old_new_map.containsKey(next) ) {
//			RandomListNode node = new RandomListNode(next.label);
//            old_new_map.put(next, node);
//			temp_head_copy.next = node;
//			
//			temp_head_copy.random = deepCopy(random, old_new_map);
//			temp_head_copy = temp_head_copy.next;
//			
//			random = next.random;
//			next = next.next;
//			
//		} 
//        if(old_new_map.containsKey(next)){
//        	temp_head_copy.next = old_new_map.get(next);
//        }
//        else{
//        	temp_head_copy.next = null;
//        }
//        return head_copy;
//    }
    //简化版， 时间较长
//    public RandomListNode deepCopy(RandomListNode head, Map<RandomListNode, RandomListNode> old_new_map){
//    	if(head == null) return null;
//    	if(old_new_map.containsKey(head)) return old_new_map.get(head);
//
//        RandomListNode head_copy = new RandomListNode(head.label);
//        old_new_map.put(head, head_copy);
//        
//        head_copy.next = deepCopy(head.next, old_new_map);
//        head_copy.random = deepCopy(head.random, old_new_map);
//        
//        return head_copy;
//    }
    
    //新链表插入原有链表再拆开!
    
    public RandomListNode copyRandomList(RandomListNode head) {
    	RandomListNode copy, p;
    	
    	if(head == null) return null;
    	
    	for( p=head; p!=null; p=p.next){ //创建新链表插入到原有链表
    		copy = new RandomListNode(p.label);
    		copy.next = p.next;
    		p.next = copy;
    		p = copy;
    	}
    	copy = head.next;
    	
    	for( p=head; p!=null; p=copy.next){ //复制random
    		copy = p.next;
    		copy.random = p.random == null? null: p.random.next;
    	}
    	
    	for( p=head, head=copy=p.next; p!=null; ){ //拆分链表
    		p = p.next = copy.next;   //p.next = copy.next; p = p.next;
    		copy = copy.next = p == null ? null: p.next; //copy.next = p == null ? null: p.next;   copy = copy.next
    	}
    	
    	return head;
    }
    

    public static void main(String[] args) {
		Solution solution = new Solution();
		RandomListNode head = new RandomListNode(-1);
		head.next = new RandomListNode(-2);
		head.next.random = head;
		head.next.next = new RandomListNode(-3);
		RandomListNode copy_head = solution.copyRandomList(head);
		
	    System.out.println(head.next.random.next.label);
		System.out.println(copy_head.next.random.next.label);
		
		while(copy_head != null){
			System.out.println(copy_head.label);
			copy_head = copy_head.next;
		}
	    
	}
}
