package sort_colors;
/*Ã‚ƒø√Ë ˆ
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: 
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up: 
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?*/
public class Solution {
//    public void sortColors(int[] A) {
//        int count[] = new int[3];
//        for(int i=0; i<A.length; i++) count[A[i]]++;
//        for(int i=0, j=0; i<count.length; i++){
//        	while(count[i]-->0) A[j++] = i;
//        }
//    }
//    
    public void sortColors(int[] A) {
        int index0 = 0;
        int index2 = A.length - 1;
        for(int i=0; i<A.length; i++){
        	if(A[i] == 0 && index0 < i) swap(A, index0++, i);
        	else if(A[i] == 2 && index2>i) swap(A, index2--, i);
        }
    }
    public void swap(int []A, int i, int j){
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
