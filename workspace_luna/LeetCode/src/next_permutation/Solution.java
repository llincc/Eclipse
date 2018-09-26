package next_permutation;

import java.util.Arrays;

/*��Ŀ����

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3��1,3,2
3,2,1��1,2,3
1,1,5��1,5,1

*/
public class Solution {
    public void nextPermutation(int[] num) {
        int start = num.length-1;
        int end = num.length-1;
        while(start>0 && num[start-1]>=num[start]) start--;
        if(start == 0) reverse(num, start, end);
        else{
        	int j = num.length - 1;
        	while(num[j]<=num[start-1]) j--; //1 3 2���Ա�����   //���ҵ���1�����2���ٽ���1 2�� �ڵߵ� 3 1 
        	System.out.println(start+" "+j);
        	swap(num, start-1, j);           // 2 3 1 ���ҵ���2�����3������ 2 3�� �ٵߵ�2 1
        	reverse(num, start, end);
        }
        
    }
    private void reverse(int[] num, int start, int end){
    	while(start<end){
    		swap(num, start++, end--);
    	}
    }
    private void swap(int[] num, int i, int j){
    	int temp = num[i];
    	num[i] = num[j];
    	num[j] = temp;
    }
    public static void main(String[] args) {
		new Solution().nextPermutation(new int[]{2,3,1});
	}
}
