package word_ladder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

/*题目描述

Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]

As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length5.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.*/
public class Solution {
	//用广度优先搜索找到段小深度&&同minimum_depth_of_binary_tree
    public int ladderLength(String start, String end, HashSet<String> dict) {
    	LinkedList<String> queue = new LinkedList<String>();
        //
    	dict.remove(start);
    	dict.remove(end);
        queue.offer(start);
        int deep = 1;
        while(!queue.isEmpty()){
        	int size = queue.size();
        	String tmp;
        	while(size>0){
        		tmp = queue.poll();
        		size--;
        		for(int i=0; i<tmp.length(); i++){
        			char oldCh = tmp.charAt(i);
        			char newCh;
        			String newStr;
        			
        			for(int j=0; j<26; j++){
        				newCh = (char) (97 + j);
        				if(newCh != oldCh){
        					StringBuffer bf = new StringBuffer(tmp);
        					newStr = bf.replace(i, i+1, String.valueOf(newCh)).toString();
        					
        					if(newStr.equals(end)){
        						return deep + 1;
        					}
        					else if(dict.contains(newStr)){
        						dict.remove(newStr);
        						queue.offer(newStr);
        					}
        				}
        			}
        		}	
        	}
        	deep++;
        }
        return 0;
    }
    
    public static void main(String[] args) {
		String start = "hot";
		String end = "dog";
		HashSet<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		System.out.println(new Solution().ladderLength(start, end, dict));
	}
}
