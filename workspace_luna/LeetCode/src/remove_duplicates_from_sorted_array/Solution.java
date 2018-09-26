package remove_duplicates_from_sorted_array;
/*ÌâÄ¿ÃèÊö

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A =[1,1,2],

Your function should return length =2, and A is now[1,2].*/
public class Solution {
    public int removeDuplicates(int[] A) {
        int dupindex = 1;
        for(int i=1; i< A.length; i++){
        	if(A[i] != A[i-1]){
        		A[dupindex++] = A[i];
        	}
        }
        return dupindex;
    }
}
