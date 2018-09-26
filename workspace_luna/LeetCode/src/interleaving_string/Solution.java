package interleaving_string;

import java.sql.SQLClientInfoException;
import java.util.Arrays;

/*题目描述

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 ="aabcc",
s2 ="dbbca",

When s3 ="aadbbcbcac", return true.
When s3 ="aadbbbaccc", return false.

*/
public class Solution {
	
    public boolean isInterleave(String s1, String s2, String s3) {
    	if(s1.length()+s2.length()!=s3.length()) return false;
    	//int 矩阵也可用boolean代替
    	int dp[][] = new int[s1.length()+1][s2.length()+1];
        dp[0][0] = 0;
        for(int i=1; i<s2.length()+1; i++){
        	if(s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]>=0) dp[0][i] = i-1;
        	else dp[0][i] = -1;
        }
        for(int i=1; i<s1.length()+1; i++){
        	if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]>=0) dp[i][0] = i-1;
        	else dp[i][0] = -1;
        }
        dp[0][0] = -1;
    	for(int i=1; i<s1.length()+1; i++){
    		char s1ch = s1.charAt(i-1);
    		for(int j=1; j<s2.length()+1; j++){
    		    if((dp[i-1][j] >= 0 && s1ch == s3.charAt(i+j-1))||(dp[i][j-1] >=0 && s2.charAt(j-1) == s3.charAt(i+j-1))) 
    		    	dp[i][j] = i+j-1;
    		    else 
					dp[i][j] = -1;		
    		}
    	}
    	return dp[s1.length()][s2.length()] == s3.length()-1;
    }
    public static void main(String[] args) {
		String s1 = "a";
		String s2 = "";
		String s3 = "a";
		System.out.println(new Solution().isInterleave(s1, s2, s3));
	}
}
