package palindrome_partitioning_ii;

import java.util.HashMap;
import java.util.Map;

//Given a string s, partition s such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of s.
//
//For example, given s ="aab",
//Return1since the palindrome partitioning["aa","b"]could be produced using 1 cut.
public class Solution {
//    public int minCut(String s) {
//        Map<String, Integer> mincut = new HashMap<String, Integer>();
//        return cut(s, mincut);
//    }
//    public int cut(String s, Map<String, Integer> mincut){
//
//        if(mincut.containsKey(s)) return mincut.get(s);
//        if(isPalindrome(s)){
//        	mincut.put(s, 0);
//        	return 0;
//        }
//        int min = Integer.MAX_VALUE;
//        for(int i=1; i<s.length(); i++){
//        	int cost = cut(s.substring(0, i), mincut) + cut(s.substring(i), mincut) + 1;
//        	min = min > cost? cost:min;
//        }
//        mincut.put(s, min);
//        return min;
//    }
//    
//    private boolean isPalindrome(String str){
//    	int i,j;
//    	for(i=0, j=str.length()-1; i<=j && str.charAt(i)==str.charAt(j); i++, j--);
//    	return i>j;
//    }
    
    public int minCut(String s) {
        int []dp = new int[s.length()+1]; //dp[i]表示i-len-1这段的最小分割
        boolean [][]p = new boolean[s.length()][s.length()]; //p[i][j]表示是回文
        
        for(int i=s.length()-1; i>=0; i--){
        	dp[i] = Integer.MAX_VALUE;
        	for(int j=i; j<s.length(); j++){ //i <= j < len
        		if(s.charAt(i)==s.charAt(j) && (j-i<2 || p[i+1][j-1])){
        			p[i][j] = true;
        			dp[i] = Math.min(dp[i], dp[j+1]+1); //因为j+1>i,所以dp[j+1]必然是先被计算的
        		}
        	}
        }
        return dp[0]-1;
    }
    
    public static void main(String[] args) {
    	Solution solution = new Solution();
		String s = "dfafdsdshreaefwagfdsafdsafdsagewafdsafdsafddfafdsdshreaefwagfdsafdsafdsagewafdsafdsafddfafdsdshreaefwagfdsafdsafdsagewafdsafdsafd";
		System.out.println(solution.minCut(s));

	}
    
}
