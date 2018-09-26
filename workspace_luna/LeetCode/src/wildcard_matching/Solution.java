package wildcard_matching;

import java.util.Stack;

import javax.xml.stream.events.StartDocument;

/*��Ŀ����

Implement wildcard pattern matching with support for'?'and'*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") �� false
isMatch("aa","aa") �� true
isMatch("aaa","aa") �� false
isMatch("aa", "*") �� true
isMatch("aa", "a*") �� true
isMatch("ab", "?*") �� true
isMatch("aab", "c*a*b") �� false*/
public class Solution {
    public boolean isMatch1(String s, String p) {
        char chs[] = s.toCharArray();
        char chp[] = p.toCharArray();
        return match(chs, 0, chp, 0);
        
    }
    private boolean match(char[]s, int i, char[]p, int j){
    	
    	if(i >= s.length && j >= p.length) return true;
    	if((i >= s.length && j<p.length) || ( i<s.length && j>=p.length)) return false;
    	if(p[j] == '*'){
    		for(int k = i; k<=s.length; k++){ 
    			if(match(s, k, p, j+1)) return true;
    		}
    		return false;
    	}
    	else if(p[j] == '?' || s[i] == p[j]){
    		return match(s, i+1, p, j+1);
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean isMatch(String s, String p) {
        int i=0, j=0, j_recall = 0, i_recall=0;
        while(i<s.length() && j<p.length()){
        	if(p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)){
        		i++;
        		j++;
        		continue;
        	}
        	if(p.charAt(j) == '*'){
        		i_recall = i;
        		j_recall = ++j;
        		continue;
        	}
        	if(j_recall>0){
        		i = ++i_recall;
        		j = j_recall;
        		continue;
        	}
        	return false;
        }
        while(j<p.length() && p.charAt(j)=='*') ++j;
        if(j<p.length()) return false;
        else return true;
    }
    


    public boolean isMatch2(String s, String p) {
    	int row = s.length();
    	int col = p.length();
/*    	�����*����ô��Ӧ�������:*
 *      �滻
 *      0���ַ���dp[i+1][j]����
    	һ���ַ�(dp[i][j])
    	����ַ�(dp[i][j+1])���� s0-i-1��s0-jΪ������
    	���ж���ַ���ʵ�������Ϊ���ȱ������*��Ȼ��ȥ��һ���ַ����ظ����ξ��Ƕ���ַ�*/
    	boolean[][] dp = new boolean[row + 1][col + 1];
    	dp[0][0] = true;
    	for (int j = 1; j < col + 1; j++) {
	    	if (dp[0][j - 1]) {// ��һ�У�ƥ���ַ�Ϊ�գ����Կ��Ǵ�ƥ���ַ�Ϊ*�����
		    	if (p.charAt(j - 1) == '*')
		    		dp[0][j] = true;
		    	else
		    		break;
		    }
	    }
	    for (int i = 0; i < row; i++)
	    	for (int j = 0; j < col; j++) {
	    		if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
	    			dp[i + 1][j + 1] = dp[i][j];//s0~i-1   po~j-1
	    		else if (p.charAt(j) == '*') {
	    			                            //s0-i     po~j-1      s0~i-1  p0~j
	    			dp[i + 1][j + 1] = dp[i][j] || dp[i + 1][j] || dp[i][j + 1]; 
	    	}
    	}
    	return dp[row][col];
    }
    public static void main(String[] args) {
		System.out.println(new Solution().isMatch("aa", "a"));
	}
} 
