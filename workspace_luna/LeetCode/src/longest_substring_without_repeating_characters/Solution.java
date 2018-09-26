package longest_substring_without_repeating_characters;

import java.util.Arrays;

//Ã‚ƒø√Ë ˆ
//
//Given a string, find the length of the longest substring without repeating characters. 
//For example, the longest substring without repeating letters for "abcabcbb" is "abc",
//which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int count[] = new int[128];
        int maxlength = 0;
        int start = 0; 
        for(int i=0; i<s.length(); i++){
        	char ch = s.charAt(i);
        	count[(int)ch]++;
        	if(count[ch]>1){
        		maxlength = Math.max(maxlength, i - start); 
        		while(s.charAt(start) != ch){
        			count[s.charAt(start)] --;
        			start++;
        		}
        		count[ch]--;
        		start++;
        	}
        }
        maxlength = Math.max(maxlength, s.length() - start);
        return maxlength;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
	}
}
