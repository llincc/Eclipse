package word_break;

import java.util.HashSet;
import java.util.Set;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s ="leetcode",
//dict =["leet", "code"].
//
//Return true because"leetcode"can be segmented as"leet code".



public class Solution {
	
	//方法一：类似于矩阵连乘的解法
	//子串长度从1到s.length()逐渐检验子串是否能拆分
	//转态转移方程：Fi,j = {Fi,j, Fi,i+1 & Fi+1,j, Fi,i+2 & Fi+2,j,……, Fi,j-1 & Fj-1,j }

	//缺点：有不必要的计算，因为字符串必须从头开始就能拆分，这种方法显得多余了（Fi,j的i必须为0，不需要对其他Fi,j进行计算）
//    public boolean wordBreak(String s, Set<String> dict) {
//        
//    	boolean[][] breakmatrix = new boolean[s.length()][s.length()+1];
//    	
//    	for(int r=1; r<= s.length(); r++){//子字符串长度r = 1.....s.length()
//    		for(int start=0; start<s.length() - r +1; start++){//子字符串开始位置
//    		     int end = start + r; //子字符串结束位置
//    		     String substr = s.substring(start, end);
//    		     if(dict.contains(substr)) breakmatrix[start][end] = true;
//    		     else{
//    		    	 breakmatrix[start][end] = false;
//    		    	 for(int j=start+1; j<end; j++){
//    		    		 boolean isbreak = breakmatrix[start][j] & breakmatrix[j][end];
//    		    		 if(isbreak){
//    		    			 breakmatrix[start][end] = true;
//    		    			 break;
//    		    		 }
//    		    	 }
//    		     }
//    		     
//    		}
//    	}
//    	return breakmatrix[0][s.length()];
//    }
    
	//方法二：转态转移方程f(i) = f(j) && f(j+1,i); 0 <= j < i;
    public boolean wordBreak(String s, Set<String> dict) {
        
    	boolean[] breakmatrix = new boolean[s.length()+1];
    	breakmatrix[0] = true;

    	for(int r=1; r<= s.length(); r++){//左边子字符串长度r = 1.....s.length()
    		for(int i=0; i<r; i++){
    			if(breakmatrix[i] && dict.contains(s.substring(i, r))){
    				breakmatrix[r] = true;
    				break;
    			}
    		}
    	}
    	return breakmatrix[s.length()];
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		String s = "leetcod";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(solution.wordBreak(s, dict));
		
	}
}
