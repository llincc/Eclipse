package median_of_two_sorted_arrays;
//ÌâÄ¿ÃèÊö
//
//There are two sorted arrays A and B of size m and n respectively. 
//Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int cur = 0;
        int pre = 0;
        int i = 0, j = 0;
        int total = A.length + B.length;
        while(i < A.length && j<B.length){
        	pre = cur;
        	if(A[i] < B[j]){
        		cur = A[i++];
        	}
        	else{
        		cur = B[j++];
        	}
        	if( i + j == total / 2 + 1){
        		if(total % 2 == 0) return (double)(pre + cur) / 2;
        		else return (double)cur;
        	}
        }
        while(i<A.length){
        	pre = cur;
        	cur = A[i++];
        	if( i + j == total / 2 + 1){
        		if(total % 2 == 0) return (double)(pre + cur) / 2;
        		else return (double)cur;
        	}
        }
        while(j<B.length){
        	pre = cur;
        	cur = B[j++];
        	if( i + j == total / 2 + 1){
        		if(total % 2 == 0) return (double)(pre + cur) / 2;
        		else return (double)cur;
        	}
        }
    	if(total % 2 == 0) return (double)(pre + cur) / 2;
    	else return (double)cur;
    }
}
