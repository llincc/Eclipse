package minimum_window_substring;
/*题目描述

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S ="ADOBECODEBANC"
T ="ABC"

Minimum window is"BANC".

Note: 
If there is no such window in S that covers all characters in T, return the emtpy string"".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

*/
public class Solution {
    public String minWindow(String S, String T) {
        int count[] = new int[128];
        for(int i=0; i<T.length(); i++) count[T.charAt(i)]++;
        
        int start = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        
        while(end< S.length()){
        	if(count[S.charAt(end++)]-->0){ //无论是>0或者<=0， count都需要减，但counter只有在>0时才会减
        		counter--;
        	}
        	while(counter == 0){
        		if(end - start < d){
        			head = start;
        			d = end - start;
        		}
        		if(count[S.charAt(start++)]++ == 0){  //start非T字符或者是多余的T字符如AA相应的count必然<0，因此!=0，而是T字符必然==0
        			// = 0说明目前[start , end)这段的所需的S.charAt(start)字符个数刚好，
        			counter++;
        		}
        	}
        }
        return d == Integer.MAX_VALUE ? "": S.substring(head, head+d);
    }
    public static void main(String[] args) {
		String S = "KAACFECATMCF";
		String T = "ACF";
		System.out.println(new Solution().minWindow(S, T));
	}
}
