package plus_one;

import java.util.ArrayList;

/*ÌâÄ¿ÃèÊö

Given a number represented as an array of digits, plus one to the number.*/
public class Solution {
    public int[] plusOne(int[] digits) {
    	int c = 1;
        for(int i=digits.length-1; i>=0; i--){
        	digits[i] = c + digits[i];
        	if(digits[i] > 9){
        		c = 1;
        		digits[i] -= 10;
        	}
        	else{
        		c = 0;
        	}
        }
       
        if(c != 1){
        	return digits;
        }
        else{
        	int result[] = new int[digits.length+1];
        	result[0] = 1;
        	for (int i = 1; i < result.length; i++) {
				result[i] = digits[i-1];
			}
        	return result;
        }  
    }
}
