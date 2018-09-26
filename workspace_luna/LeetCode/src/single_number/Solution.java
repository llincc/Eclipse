package single_number;

/*Given an array of integers, every element appears twice except for one. Find that single one.

Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

public class Solution {
	
	//ʹ������˼��
    public int singleNumber(int[] A) {
        int num = 0;
        for(int i: A){
        	num ^= i;
        }
        return num;
    }
}