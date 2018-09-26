package search_for_a_range;
/*ÌâÄ¿ÃèÊö

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return[-1, -1].

For example,
Given[5, 7, 7, 8, 8, 10]and target value 8,
return[3, 4].

*/
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while(left<=right){
        	int mid = (left+right)/2;
        	if(A[mid]>=target) right = mid-1;
        	else left = mid + 1;
        }
        int result[] = {-1,-1};
        if(left<A.length && A[left]==target){
        	result[0] = result[1] = left;
            for(int i=left-1; i>=0; i--){
            	if(A[i] == target) result[0] = i;
            	else break;
            }
            for(int i=left+1; i<A.length; i++){
            	if(A[i] == target) result[1] = i;
            	else break;
            }
            return result;
        }
        else{
        	return result;
        }
    }
}
