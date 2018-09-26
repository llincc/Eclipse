package distinct_subsequences;
/*��Ŀ����

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie,"ACE"is a subsequence of"ABCDE"while"AEC"is not).

Here is an example:
S ="rabbbit", T ="rabbit"

Return3.

*/
public class Solution {
	//��̬�滮��dp[i][j]��ʾS[0-j]��T[0-i]��ƥ��ĸ��������Sj = Ti��dp[i][j] = dp[i-1][j-1] + dp[i][j-1]������dp[i][j] = dp[i][j-1]
    public int numDistinct(String S, String T) {
    	if(T == null ) return 0;
        int [][]dp = new int[T.length()][S.length()+1];
        
        for(int i=0; i<T.length(); i++){
        	char tch = T.charAt(i);
        	for(int j=0; j<S.length(); j++){
        		if(S.charAt(j)==tch){
        		    if(i==0) dp[i][j+1] = dp[i][j] + 1;
        		    else dp[i][j+1] = dp[i-1][j] + dp[i][j];
        		}
        		else{
        			dp[i][j+1] = dp[i][j];
        		}
        	}
        }
        return dp[T.length()-1][S.length()];
        //������rabbbit, rabbit�������
    }
    
    public static void main(String[] args) {
		String S = "rabbbit";
		String T = "rabbit";
		System.out.println(new Solution().numDistinct(S, T));
	}
}
