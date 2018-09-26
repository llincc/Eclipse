package length_of_last_word;
/*ÌâÄ¿ÃèÊö

Given a string s consists of upper/lower-case alphabets and empty space characters' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s ="Hello World",
return5.

*/
public class Solution {
    public int lengthOfLastWord(String s) {
    	if("".equals(s)) return 0;
        int count = 0;
        int i = s.length()-1;
        while(i>= 0 && s.charAt(i) == ' ') i--;
        for(; i>=0; i--){
        	if(Character.isAlphabetic(s.charAt(i))){
        		count++;
        	}
        	else{
        		break;
        	}
        }
        return count;
    }
    public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(new Solution().lengthOfLastWord(s));
	}
}
