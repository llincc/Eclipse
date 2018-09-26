package zigzag_conversion;

import java.util.ArrayList;
import java.util.Arrays;


/*Ã‚ƒø√Ë ˆ

The string"PAYPALISHIRING"is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line:"PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3)should return"PAHNAPLSIIGYIR".*/
public class Solution {
    public String convert(String s, int nRows) {
    	if(s.length() == 0) return "";
    	if(nRows == 1) return s;
    	StringBuilder []result = new StringBuilder[nRows];
        int each = 2 * nRows - 2;
        int bottom = nRows - 1; 
        
        for(int i=0; i<nRows; i++) result[i] = new StringBuilder();
        for(int i=0; i<s.length(); i++){
        	int mod = i % each;
        	int layer = mod <= bottom ? mod: (2*bottom - mod);    
        	result[layer].append(s.charAt(i));
        }
        StringBuilder re = new StringBuilder();
        for(StringBuilder sb: result) re.append(sb);
        return re.toString();
    }
	public static void main(String[] args) {
		System.out.println(new Solution().convert("PAYPALISHIRING", 3));
	}
}
