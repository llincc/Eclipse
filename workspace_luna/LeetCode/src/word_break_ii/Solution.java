package word_break_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s ="leetcode",
//dict =["leet", "code"].
//
//Return true because"leetcode"can be segmented as"leet code".

//Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
//
//Return all such possible sentences.
//
//For example, given
//s ="catsanddog",
//dict =["cat", "cats", "and", "sand", "dog"].
//
//A solution is["cats and dog", "cat sand dog"].

//类似于矩阵连乘的解法
//子串长度从1到s.length()逐渐检验子串是否能拆分
//Fi,j = {Fi,j, Fi,i+1 & Fi+1,j, Fi,i+2 & Fi+2,j,……, Fi,j-1 & Fj-1,j }

public class Solution {
	
	//方法一的进一步，超时~
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	boolean[][] breakmatrix = new boolean[s.length()][s.length()+1];
//    	
//    	//用Set， 因为可能出现重复 ，比如leetcodecode，可能有leetcode code和leet codecode的划分，之后会变成两个leet code code
//    	Map<String, Set<String>> posMap = new HashMap<String, Set<String>>();
//    	
//    	for(int r=1; r<= s.length(); r++){//子字符串长度r = 1.....s.length()
//    		for(int start=0; start<s.length() - r +1; start++){//子字符串开始位置
//    		     int end = start + r; //子字符串结束位置
//    		     String substr = s.substring(start, end);
//    		     String pos = getPosStr(start, end);
//    		     
//    		     Set<String> strArr;
//    		     if(dict.contains(substr)){
//    		    	 strArr = new HashSet<String>();
//    		    	 strArr.add(s.substring(start, end));
//    		    	 breakmatrix[start][end] = true;
//    		    	 posMap.put(substr, strArr);
//    		     }
//    		     else{
//    		    	 breakmatrix[start][end] = false;
//    		    	 for(int j=start+1; j<end; j++){
//    		    		 boolean isbreak = breakmatrix[start][j] & breakmatrix[j][end];
//    		    		 if(isbreak){
//    		    			 breakmatrix[start][end] = true;
//    		    			 strArr = posMap.get(substr);
//    		    			 if(strArr == null){
//    		    				 strArr = new HashSet<String>();
//    		    			 }
//    		    			 Set<String> leftArr = posMap.get(s.substring(start, j));
//    		    			 Set<String> rigthArr = posMap.get(s.substring(j, end));
//    		    			 for(String leftstr: leftArr){
//    		    				 for(String rightstr: rigthArr){
//    		    					 strArr.add(leftstr+" "+rightstr);
//    		    				 }
//    		    			 }
//    		    			 posMap.put(substr, strArr);
//    		    			 
//    		    		 }
//    		    	 }
//    		     }
//    		}
//    	}
//    	ArrayList<String> result = new ArrayList<String>();
//    	if(breakmatrix[0][s.length()]){
//        	for(String str: posMap.get(s.substring(0, s.length()))){
//        		result.add(str);
//        	}
//    	}
//    	return result;
//    }
//	//方法一的进一步，超时~
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//   
//    	Map<String, ArrayList<String>> posMap = new HashMap<String, ArrayList<String>>();
//    	
//    	for(int r=1; r<= s.length(); r++){//子字符串长度r = 1.....s.length()
//    		
//    		for(int start=0; start<s.length() - r +1; start++){//子字符串开始位置
//    		     int end = start + r; //子字符串结束位置
//    		     String substr = s.substring(start, end);
//    		     if(posMap.containsKey(substr)) continue;
//    		     ArrayList<String> strArr;
//    		     if(dict.contains(substr)){
//    		    	 strArr = new ArrayList<String>();
//    		    	 strArr.add(s.substring(start, end));
//    		    	 posMap.put(substr, strArr);
//    		     }
//    		     else{
//    		    	 for(int j=start+1; j<end; j++){
//		    			 ArrayList<String> leftArr  = posMap.get(s.substring(start, j));
//		    			 ArrayList<String> rigthArr = posMap.get(s.substring(j, end));
//		    			 if(leftArr != null && rigthArr !=null){
//    		    			 strArr = posMap.get(substr);
//    		    			 if(strArr == null){
//    		    				 strArr = new ArrayList<String>();
//    		    			 }
//    		    			 for(String leftstr: leftArr){
//    		    				 for(String rightstr: rigthArr){
//    		    					 strArr.add(leftstr+" "+rightstr);
//    		    				 }
//    		    			 }
//    		    			 posMap.put(substr, strArr);
//    		    			 
//    		    		 }
//    		    	 }
//    		     }
//    		}
//    	}
//    	if(posMap.containsKey(s)) return posMap.get(s);
//    	else return new ArrayList<String>();
//    }
    
//	//方法二：转态转移方程f(i) = f(j) && f(j+1,i); 0 <= j < i; 从前往后找，超时
//	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	ArrayList<LinkedList<String>> strArr = new ArrayList<LinkedList<String>>();        
//    	strArr.add(new LinkedList<String>());
//    	
//    	for(int r=1; r<= s.length(); r++){//sub(0, r)子字符串长度r = 1.....s.length()
//    		LinkedList<String> posArr = new LinkedList<String>();
//    		LinkedList<String> lefArr;
//    		for(int i=0; i<r; i++){
//    			String leaveStr = s.substring(i, r); //子字符串右边剩下的字符串
//    			lefArr = strArr.get(i);
//    			if(i == 0 && dict.contains(leaveStr)){
//    				posArr.add(leaveStr);
//    				continue;
//    			}
//    			if(lefArr.size() != 0 && dict.contains(leaveStr)){//lefArr.size() != 0说明左边子串能拆分
//    				//子串的左边部分和右边部分整合
//    				for(String leftStr: lefArr){
//    					posArr.add(leftStr+" "+leaveStr);
//    				}
//    			}
//    		}
//    		strArr.add(posArr); 		
//    	}
//    	return new ArrayList<String>(strArr.get(s.length()));
//    }
	 
		//方法二：转态转移方程f(i) = f(j) && f(j+1,i); 0 <= j < i; 从前往后找，超时
//	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	ArrayList<LinkedList<StringBuffer>> strArr = new ArrayList<LinkedList<StringBuffer>>();        
//    	strArr.add(new LinkedList<StringBuffer>());
//    	
//    	for(int r=1; r<= s.length(); r++){//sub(0, r)子字符串长度r = 1.....s.length()
//    		LinkedList<StringBuffer> posArr = new LinkedList<StringBuffer>();
//    		LinkedList<StringBuffer> lefArr;
//    		
//    		String leaveStr = s.substring(0,r);
//    		if(dict.contains(leaveStr)) posArr.add(new StringBuffer(leaveStr));
//    		
//    		for(int i=1; i<r; i++){
//    			lefArr = strArr.get(i);
//    			if(lefArr.size() == 0) continue;
//    			leaveStr = s.substring(i, r); //子字符串右边剩下的字符串
//    			
//    			if(dict.contains(leaveStr)){//lefArr.size() != 0说明左边子串能拆分
//    				//子串的左边部分和右边部分整合
//    				for(StringBuffer leftStr: lefArr){
//    					posArr.add(leftStr.append(" ").append(leaveStr));
//    				}
//    			}
//    		}
//    		strArr.add(posArr); 		
//    	}
//    	ArrayList<String> result = new ArrayList<String>();
//    	for(StringBuffer str: strArr.get(s.length())){
//    		result.add(str.toString());
//    	}
//    	return result;
//    }
	
	//方法三：从后往前，递归测试
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> list=new ArrayList<String>();
		boolean[] flag=new boolean[s.length()];     //flag[i]==true,表示从i位置往后分割不出满足条件的串。
		func(list,s,new StringBuffer(),s.length(),dict,flag);
		return list;
	}
	private void func(ArrayList<String> list, String s, StringBuffer ans, int i, Set<String> dict, boolean[] flag) {
	    for(int j = i - 1; j >= 0; j--) {
	        if(dict.contains(s.substring(j, i))) {
	            StringBuffer tmp = new StringBuffer(ans);
	            if(j == 0) {
	                tmp.insert(0, s.substring(j, i)); //找到开头
	                list.add(tmp.toString());
	            } else {
	                if(flag[j] == false) {         //如果flag[j] = true，则说明在j这里划分是无效的（之前测试得出的结果）
	                    int oldsize = list.size(); //递归测试前sub(0,j)之前列表长度
	                    tmp.insert(0, " " + s.substring(j, i));
	                    func(list, s, tmp, j, dict, flag); //测试sub(0,j)
	                    if(oldsize == list.size()) //如果列表长度没变化，说明这里划分是无效的（即使sub(j, i)确实在字典中）
	                        flag[j] = true;
	                }
	            }
	        }
	    }
	}
	
    public String getPosStr(int start, int end){
    	return String.valueOf(start)+"_"+String.valueOf(end);
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		String s = "catsanddog";
		Set<String> dict = new HashSet<String>();
		dict.add("cat");
		dict.add("cats");
		dict.add("sand");
		dict.add("and");
		dict.add("dog");
		System.out.println(solution.wordBreak(s, dict));
//    	Set<Integer> iSet = new HashSet<Integer>();
//    	ArrayList<Integer> iArr = new ArrayList<Integer>();
//    	
//    	long begin = System.currentTimeMillis();
//    	for(int i=0; i<100000; i++) iSet.add(i);
//    	long end = System.currentTimeMillis();
//    	System.out.println(end-begin);
//    	
//    	begin = System.currentTimeMillis();
//    	for(int i=0; i<100000; i++) iArr.add(i);
//    	end = System.currentTimeMillis();
//    	System.out.println(end-begin);
		
	}
}
