package search_insert_position;
/*ÌâÄ¿ÃèÊö

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 ¡ú 2
[1,3,5,6], 2 ¡ú 1
[1,3,5,6], 7 ¡ú 4
[1,3,5,6], 0 ¡ú 0

*/
public class Solution {
    public int searchInsert1(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while(left<=right){
        	int mid = (left+right)/2;
        	if(A[mid] == target) return mid;
        	else if(A[mid] > target) right = mid - 1;
        	else left = mid + 1;
        }
        return left;
    }
    public int searchInsert(int[] A, int target) {
        int left = 0;
        int right = A.length-1;
        while(left<=right){
        	int mid = (left+right)/2;
        	if(A[mid]>=target) right = mid-1;
        	else left = mid + 1;
        }
        return left;
    }   
    public static void main(String[] args) {
		int A[] = {1,3,5,6};
		System.out.println(new Solution().searchInsert(A, 4));
		
	}
}
