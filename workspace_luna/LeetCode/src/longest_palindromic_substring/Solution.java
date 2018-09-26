package longest_palindromic_substring;
/*题目描述

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

*/
public class Solution {
    public String longestPalindrome(String s) {
    	int maxlength = 0;
    	int start = 0;
    	int end = 1;
        for(int i=0; i<s.length(); i++){
        	for(int j=0; j<2; j++){ //以i为中心的情况，和以i, i+1为中心的情况
            	int left = i;   
            	int right = i+j;
            	if(right == s.length()) break;
            	while(left >= 0 && right <s.length() && s.charAt(left) == s.charAt(right)){
            		left--;
            		right++;
            	}
            	left ++;
            	if(maxlength < right - left){
            		maxlength = right-left;
            		start = left;
            		end = right;
            	}
        	}
        }
        return s.substring(start, end);
    }
}
