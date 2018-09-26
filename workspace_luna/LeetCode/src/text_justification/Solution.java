package text_justification;

	import java.util.ArrayList;
import java.util.Arrays;
/*题目描述
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces' 'when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words:["This", "is", "an", "example", "of", "text", "justification."]
L:16.

Return the formatted lines as:

[
   "This    is    an",
   "example  of text",
   "justification.  "
]

Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:

A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.*/

//*****要点：生成不定长度的空白字符串的效率https://bbs.csdn.net/topics/270015407
public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        int left = 0;
        int right = 0;
        int len = 0;
        ArrayList<String> result = new ArrayList<String>();
        for(int i=0; i<words.length; i++){
        	if(words[i].length()+len + i-left > L){
        		right = i - 1;       		
        		result.add(generate(words, left, right, len, L));
        		len = words[i].length();
        	    left = i;
        	}
        	else{
        		len += words[i].length();
        	}	
        }
        result.add(generate(words, left, words.length-1, len, L));
        return result;
    }
    private String generate(String words[], int left, int right, int len,  int L){
    	StringBuffer temp = new StringBuffer("");
    	if(right != words.length-1){
			int blanknum = L - len;
			int gapnum = right - left;
			int mod = 0;
			int div = 0;
			if(gapnum != 0){
				mod = blanknum % gapnum;
				div = blanknum / gapnum;
			}    			
			for(int j=left; j<=right; j++){
			    temp.append(words[j]);
			    if(j<right){
			    	if(j-left < mod){
			    		temp.append(blankline(div+1));
			    	}
			    	else{
			    		temp.append(blankline(div));
			    	}
			    }
			}
    	}
    	else{
    		for(int j=left; j<=right; j++){
    		   temp.append(words[j]);
    		   if(j<right)  temp.append(" ");
    		}
    	}
		while(temp.length()!=L){
		   temp.append(" ");
		}	
		return temp.toString();
    }
    private String blankline(int num){
    	char []chs = new char[num];
    	Arrays.fill(chs, ' ');
    	return new String(chs);
    }
    
    public static void main(String[] args) {
		long  time1 = System.currentTimeMillis();
		String words[] = {"What","must","be","shall","be."};
		System.out.println(new Solution().fullJustify(words, 12));
		long time2 = System.currentTimeMillis();
		
		System.out.println(time2-time1);
	}
}
