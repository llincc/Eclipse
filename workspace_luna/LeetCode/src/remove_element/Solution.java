package remove_element;
/*ÌâÄ¿ÃèÊö

Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/
public class Solution {
    public int removeElement(int[] A, int elem) { // 54 4    45 4
        int left = 0;
        int right = A.length-1;
        int temp;
        while(left<=right){
        	while(A[left] == elem && left <= right){
        		temp = A[right];
        		A[right--] = A[left];
        		A[left] = temp;
        	}
        	left++;
        }
        return right+1;
    }
}
