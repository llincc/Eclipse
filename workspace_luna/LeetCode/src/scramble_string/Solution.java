package scramble_string;

import java.util.Stack;

import javax.net.ssl.SSLContext;

/*Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 ="great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node"gr"and swap its two children, it produces a scrambled string"rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that"rgeat"is a scrambled string of"great".

Similarly, if we continue to swap the children of nodes"eat"and"at", it produces a scrambled string"rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that"rgtae"is a scrambled string of"great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.*/
public class Solution {
    public boolean isScramble(String s1, String s2){
    	if(s1.length()!=s2.length()) return false;
    	if(s1.equals(s2)) return true;
        int C[] = new int[26];
        for(int i=0; i<s1.length(); i++){
        	C[s1.charAt(i)-'a']++;
        	C[s2.charAt(i)-'a']--;
        }
        for(int i=0; i<C.length; i++){
        	if(C[i]!=0) return false;
        }
    	for(int i=1; i<s1.length(); i++){
    		String lefts1 = s1.substring(0, i);
    		String rights1 = s1.substring(i);
    		String lefts2 = s2.substring(0, i);
    		String rights2 = s2.substring(i);
    		String lefts2v = s2.substring(0, s2.length()-i);
    		String rights2v = s2.substring(s2.length()-i);
    		if(isScramble(lefts1,lefts2) && isScramble(rights1, rights2)) return true;
    		if(isScramble(lefts1,rights2v) && isScramble(rights1, lefts2v)) return true;
    	}
    	return false;
    }
    public static void main(String[] args) {
		String s1 = "abc"; 
		String s2 = "acb";
		String s3 = "bca";
		String s4 = "cba";
		System.out.println(new Solution().isScramble(s1, s3));
	}
}
