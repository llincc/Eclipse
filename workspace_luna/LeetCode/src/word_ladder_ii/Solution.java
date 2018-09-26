package word_ladder_ii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
/*题目描述

Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:
start ="hit"
end ="cog"
dict =["hot","dot","dog","lot","log"]

Return

  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]

Note:

All words have the same length.
All words contain only lowercase alphabetic characters.*/
public class Solution {
	//宽度优先搜索
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
    	ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
    	
    	LinkedList<String> queue = new LinkedList<String>();
        ArrayList<Integer> indexList = new ArrayList<Integer>(); //记录节点的父节点的index
        ArrayList<String> strList = new ArrayList<String>();  //记录每一层的string
        //
        int fater = -1; //记录父节点的位置
        int totalLen = 0;
        
    	dict.remove(start);
    	dict.remove(end);
        queue.offer(start);
        strList.add(start);
        indexList.add(-1);
        
        boolean reachMinDeep = false;
        
        while(!queue.isEmpty()){
        	int len, size;
        	len = size = queue.size();
        	totalLen += size;
        	String tmp;
        	
        	ArrayList<String> removeList = new  ArrayList<String>();
        	while(size>0){
        		tmp = queue.poll();
        		
        		fater = totalLen - size;
        		
//        		System.out.println(totalLen);
//        		System.out.println(fater);
        		size--;
        		for(int i=0; i<tmp.length(); i++){   //测试tmp的每一种可能
        			char oldCh = tmp.charAt(i);
        			char newCh;
        			String newStr;
        			
        			for(int j=0; j<26; j++){
        				newCh = (char) (97 + j);
        				if(newCh != oldCh){
        					StringBuffer bf = new StringBuffer(tmp);
        					newStr = bf.replace(i, i+1, String.valueOf(newCh)).toString();
        					
        					if(newStr.equals(end)){

        						if(!reachMinDeep){
        							reachMinDeep = true;
        							while(strList.size() != totalLen) {  //去除同一层未达到最低点的点
        								strList.remove(strList.size()-1);
        								indexList.remove(indexList.size()-1);
        							}
        						}
        						strList.add(newStr);
        						indexList.add(fater);
        					}
        					else if(!reachMinDeep && dict.contains(newStr)){ 
        						removeList.add(newStr);
//        						dict.remove(newStr);  //不能再这里删除节点，同层可能用到相同的[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
        						queue.offer(newStr);
        						strList.add(newStr);
        						indexList.add(fater); //记录父节点在indexList中的位置，同时也是相应字符串在strList的位置
        					}
        				}
        			}
        		}	
        	}
        	for(String str: removeList){
        		dict.remove(str);
        	}
//        	System.out.println(dict);
//        	System.out.println(strList);
//        	System.out.println(indexList);
//        	System.out.println(reachMinDeep);
//        	System.out.println(totalLen);
        	if(reachMinDeep){    		
        		for(int i=totalLen; i<indexList.size(); i++){
            		LinkedList<String> list = new LinkedList<String>();
//        			list.offer(strList.get(i));
        			int nextIndex = i;
        			while(nextIndex != -1){
        				list.push(strList.get(nextIndex));
        				nextIndex = indexList.get(nextIndex);
//        				System.out.println(nextIndex);
        				
        			}
//        			System.out.println(list);
        			result.add(new ArrayList<String>(list));
        		}
        		break;
        	}
        }
        return result;
    }
    public static void main(String[] args) {
		String start = "red";
		String end = "tax";
		HashSet<String> dict = new HashSet<String>();
		dict.add("ted");
		dict.add("tex");
		dict.add("red");
		dict.add("den");
		dict.add("rex");
		dict.add("pee");
		dict.add("tad");
		System.out.println(new Solution().findLadders(start, end, dict));
		
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("a");
//		list.add("b");
//		dict.remove(list);
//		System.out.println(dict);
	}
}
