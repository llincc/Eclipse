package merge_sorted_array;
/*ÌâÄ¿ÃèÊö

Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note: 
You may assume that A has enough space to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
    	int C[] = new int[m];
    	for(int i=0; i<m; i++) C[i] = A[i];
    	int i,j,k;
        for(i=0, j=0, k=0; i<m && j<n; ){
        	if(C[i]<=B[j]) A[k++] = C[i++];
        	else A[k++] = B[j++];
        }
        while(i<m) A[k++] = C[i++];
        while(j<n) A[k++] = B[j++];
    }
    public static void main(String[] args) {
		int A[] = {1,2,4,5,6};
		int B[] = {3};
		new Solution().merge(A, 5, B, 1);
	}
}
