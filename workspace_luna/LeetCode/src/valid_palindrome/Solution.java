package valid_palindrome;

import java.util.regex.Pattern;

/*Ã‚ƒø√Ë ˆ

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama"is a palindrome.
"race a car"is not a palindrome.

Note: 
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.*/
public class Solution {
    public boolean isPalindrome(String s) {
        int i,j;
        s = s.toLowerCase();
        for(i=0,j=s.length()-1; i<s.length() && j>=0 && i<=j; i++, j--){
//        	while(Character.ischarAt(i))
        	while(i<s.length() && !isAlphanumeric(s.charAt(i))) i++;
        	while(j>=0 && !isAlphanumeric(s.charAt(j))) j--;
//        	System.out.printf("%d %d %n",i,j);
        	if(i>=s.length() || j<0) return true;
        	if(s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char ch){
    	Pattern pattern = Pattern.compile("^[0-9a-z]$");
    	return pattern.matcher(String.valueOf(ch)).matches();
    }
    
    public boolean isPalindrome2(String s) {
        s = s.replaceAll("\\W", "");
        s = s.toLowerCase();
        for(int i=0; i<s.length()/2; i++){
        	if(s.charAt(i)!=s.charAt(s.length()-i-1)){
        		return false;
        	}
        }
        return true;
    }
    
    
    public static void main(String[] args) {
    	
    	System.out.println(new Solution().isPalindrome2("A man, a plan, a canal: Panama"));
    	
	}
}
