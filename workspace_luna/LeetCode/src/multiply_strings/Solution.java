package multiply_strings;

import java.util.ArrayList;

/*ÌâÄ¿ÃèÊö

Given two numbers represented as strings, return multiplication of the numbers as a string.

Note: The numbers can be arbitrarily large and are non-negative.*/
public class Solution {
    public String multiply(String num1, String num2) {
    	if("0".equals(num1) || "0".equals(num2)) return "0";
        StringBuilder sBuilder = new StringBuilder();
        int result[] = new int[num1.length()+num2.length()+2];
        int base = 0;
        int c = 0;
        for(int i=num1.length()-1; i>=0; i--){
        	int factor = num1.charAt(i) - '0';
        	if(factor == 0) continue;
        	base = num1.length() - i - 1;
        	int v = 0;
        	for(int j=num2.length()-1; j>=0; j--){
        		v = c + (num2.charAt(j)-'0') * factor + result[base];
        		
        		c = v / 10;
        		v = v % 10;
        		result[base++] = v;
        	}
        	while(base < result.length){
        		if(c == 0) break;
        		v = c + result[base];
        		c = v / 10;
        		v = v % 10;
        		result[base++] = v;
        	}
        }        
        for(int i=base-1; i>=0; i--){
        	sBuilder.append(result[i]);
        }
        return sBuilder.toString();
    }
    
    public static void main(String[] args) {
		String num1 = "99";
		String num2 = "98";
		System.out.println(new Solution().multiply(num1, num2));
	}
}
