package jump_game;
/*ÌâÄ¿ÃèÊö

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A =[2,3,1,1,4], return true.

A =[3,2,1,0,4], return false.*/
public class Solution {
    public boolean canJump1(int[] A) {
        return jump(A, 0);
    }
    public boolean jump(int[] A, int i){
    	if(i >= A.length) return false;
    	if(i == A.length - 1) return true;
    	if(A[i] == 0 && i != A.length-1) return false;
    	for(int j=1; j<=A[i]; j++){
    		if(jump(A, i + j)) return true;
    	}
    	A[i] = 0;
    	return false;	
    }
    
    public boolean canJump2(int []A){
    	int maxReach = 0;
    	for(int i=0; i<A.length && i<=maxReach; i++){
    		maxReach = Math.max(maxReach, i+A[i]);
    	}
    	if(maxReach < A.length-1) return false;
    	return true;
    }
    
    public static void main(String[] args) {
		int A[] = {3,2,1,1};
		System.out.println(new Solution().canJump2(A));
	}
}
