package edit_distance;
/*题目描述

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character*/
public class Solution {
    public int minDistance(String word1, String word2) {
    	int dst[][] = new int[word1.length()+1][word2.length()+1];
    	for(int i=0; i<=word1.length(); i++){
    		dst[i][0] = i;
    	}
    	for(int j=0; j<=word2.length(); j++){
    		dst[0][j] = j;
    	}
    	//word[1...len1] 和 word2[1..len2]的编辑距离
    	for(int i=1; i<=word1.length(); i++){
    		for(int j=1; j<=word2.length(); j++){
                //dst[i][j] = min{dst[i-1][j]+1, dst[i][j-1]+1, dst[i-1][j-1]+si==sj?0:1s}
    			//删除、插入///相等或不相等替换
    			dst[i][j] = Math.min(Math.min(dst[i-1][j]+1, dst[i][j-1]+1),dst[i-1][j-1] + (word1.charAt(i-1)== word2.charAt(j-1) ? 0 : 1));
    		}
    	}
        return dst[word1.length()][word2.length()];
    }
    public static void main(String[] args) {
		String word1 = "a";
		String word2 = "ab";
		System.out.println(new Solution().minDistance(word1, word2));
	}
}
