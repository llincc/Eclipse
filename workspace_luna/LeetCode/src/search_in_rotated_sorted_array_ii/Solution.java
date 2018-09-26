package search_in_rotated_sorted_array_ii;

/*ÌâÄ¿ÃèÊö

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e.,0 1 2 4 5 6 7might become4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.*/
public class Solution {
    public boolean search(int[] A, int target) {
        int left = 0, right = A.length-1;
        while(left<right && A[left] == A[left+1]) left++;
        while(right>left && A[right] == A[right-1]) right--;
        while(left<=right){
        	int mid = (left+right)/2;
        	if(A[mid] == target) return true;
        	if(A[left]<=A[mid]){ //×ó±ßÓĞĞò
        		if(A[left]<=target && target <= A[mid]){ 
        			right = mid - 1;
        		}
        		else{
        			left = mid + 1;
        		}
        	}
        	else{
        		if(A[mid]<=target && target <= A[right]){
        			left = mid + 1;
        		}
        		else{
        			right = mid -1;
        		}
        	}
            while(left<right && A[left] == A[left+1]) left++;
            while(right>left && A[right] == A[right-1]) right--;
        }
        return false;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().search(new int[]{1,1,3,1,1,1,1}, 3));
	}
}
