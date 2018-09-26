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

//�����ھ������˵Ľⷨ
//�Ӵ����ȴ�1��s.length()�𽥼����Ӵ��Ƿ��ܲ��
//Fi,j = {Fi,j, Fi,i+1 & Fi+1,j, Fi,i+2 & Fi+2,j,����, Fi,j-1 & Fj-1,j }

public class Solution {
	
	//����һ�Ľ�һ������ʱ~
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	boolean[][] breakmatrix = new boolean[s.length()][s.length()+1];
//    	
//    	//��Set�� ��Ϊ���ܳ����ظ� ������leetcodecode��������leetcode code��leet codecode�Ļ��֣�֮���������leet code code
//    	Map<String, Set<String>> posMap = new HashMap<String, Set<String>>();
//    	
//    	for(int r=1; r<= s.length(); r++){//���ַ�������r = 1.....s.length()
//    		for(int start=0; start<s.length() - r +1; start++){//���ַ�����ʼλ��
//    		     int end = start + r; //���ַ�������λ��
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
//	//����һ�Ľ�һ������ʱ~
//    public ArrayList<String> wordBreak(String s, Set<String> dict) {
//   
//    	Map<String, ArrayList<String>> posMap = new HashMap<String, ArrayList<String>>();
//    	
//    	for(int r=1; r<= s.length(); r++){//���ַ�������r = 1.....s.length()
//    		
//    		for(int start=0; start<s.length() - r +1; start++){//���ַ�����ʼλ��
//    		     int end = start + r; //���ַ�������λ��
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
    
//	//��������ת̬ת�Ʒ���f(i) = f(j) && f(j+1,i); 0 <= j < i; ��ǰ�����ң���ʱ
//	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	ArrayList<LinkedList<String>> strArr = new ArrayList<LinkedList<String>>();        
//    	strArr.add(new LinkedList<String>());
//    	
//    	for(int r=1; r<= s.length(); r++){//sub(0, r)���ַ�������r = 1.....s.length()
//    		LinkedList<String> posArr = new LinkedList<String>();
//    		LinkedList<String> lefArr;
//    		for(int i=0; i<r; i++){
//    			String leaveStr = s.substring(i, r); //���ַ����ұ�ʣ�µ��ַ���
//    			lefArr = strArr.get(i);
//    			if(i == 0 && dict.contains(leaveStr)){
//    				posArr.add(leaveStr);
//    				continue;
//    			}
//    			if(lefArr.size() != 0 && dict.contains(leaveStr)){//lefArr.size() != 0˵������Ӵ��ܲ��
//    				//�Ӵ�����߲��ֺ��ұ߲�������
//    				for(String leftStr: lefArr){
//    					posArr.add(leftStr+" "+leaveStr);
//    				}
//    			}
//    		}
//    		strArr.add(posArr); 		
//    	}
//    	return new ArrayList<String>(strArr.get(s.length()));
//    }
	 
		//��������ת̬ת�Ʒ���f(i) = f(j) && f(j+1,i); 0 <= j < i; ��ǰ�����ң���ʱ
//	 public ArrayList<String> wordBreak(String s, Set<String> dict) {
//        
//    	ArrayList<LinkedList<StringBuffer>> strArr = new ArrayList<LinkedList<StringBuffer>>();        
//    	strArr.add(new LinkedList<StringBuffer>());
//    	
//    	for(int r=1; r<= s.length(); r++){//sub(0, r)���ַ�������r = 1.....s.length()
//    		LinkedList<StringBuffer> posArr = new LinkedList<StringBuffer>();
//    		LinkedList<StringBuffer> lefArr;
//    		
//    		String leaveStr = s.substring(0,r);
//    		if(dict.contains(leaveStr)) posArr.add(new StringBuffer(leaveStr));
//    		
//    		for(int i=1; i<r; i++){
//    			lefArr = strArr.get(i);
//    			if(lefArr.size() == 0) continue;
//    			leaveStr = s.substring(i, r); //���ַ����ұ�ʣ�µ��ַ���
//    			
//    			if(dict.contains(leaveStr)){//lefArr.size() != 0˵������Ӵ��ܲ��
//    				//�Ӵ�����߲��ֺ��ұ߲�������
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
	
	//���������Ӻ���ǰ���ݹ����
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> list=new ArrayList<String>();
		boolean[] flag=new boolean[s.length()];     //flag[i]==true,��ʾ��iλ������ָ�����������Ĵ���
		func(list,s,new StringBuffer(),s.length(),dict,flag);
		return list;
	}
	private void func(ArrayList<String> list, String s, StringBuffer ans, int i, Set<String> dict, boolean[] flag) {
	    for(int j = i - 1; j >= 0; j--) {
	        if(dict.contains(s.substring(j, i))) {
	            StringBuffer tmp = new StringBuffer(ans);
	            if(j == 0) {
	                tmp.insert(0, s.substring(j, i)); //�ҵ���ͷ
	                list.add(tmp.toString());
	            } else {
	                if(flag[j] == false) {         //���flag[j] = true����˵����j���ﻮ������Ч�ģ�֮ǰ���Եó��Ľ����
	                    int oldsize = list.size(); //�ݹ����ǰsub(0,j)֮ǰ�б���
	                    tmp.insert(0, " " + s.substring(j, i));
	                    func(list, s, tmp, j, dict, flag); //����sub(0,j)
	                    if(oldsize == list.size()) //����б���û�仯��˵�����ﻮ������Ч�ģ���ʹsub(j, i)ȷʵ���ֵ��У�
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
