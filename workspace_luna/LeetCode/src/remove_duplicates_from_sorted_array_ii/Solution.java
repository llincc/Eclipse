package remove_duplicates_from_sorted_array_ii;
/*ÌâÄ¿ÃèÊö

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A =[1,1,1,2,2,3],

Your function should return length =5, and A is now[1,1,2,2,3].*/
public class Solution {
    public int removeDuplicates1(int[] A) {
    	if(A.length<=2) return A.length;
        int dupindex = 1;
        if(A[dupindex] == A[dupindex-1]) dupindex++;
        for(int i=dupindex; i< A.length; i++){
        	if(A[i] != A[i-1]){
        		A[dupindex++] = A[i]; 
        		if(i < A.length-1 && A[i+1] == A[i]){
        			A[dupindex++] = A[i]; 	
        		}
        	}
        }
        return dupindex;
    }
    //~~~~~~~
    public int removeDuplicates(int[] A) {
    	if(A.length<=2) return A.length;
        int dupindex = 2;
        for(int i=2; i< A.length; i++){
        	if(A[i] != A[dupindex-2]){ 
        		A[dupindex++] = A[i]; 
        	}
        }
        return dupindex;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().removeDuplicates(new int[]{1,1,1,2,2,3}));
	}
}
