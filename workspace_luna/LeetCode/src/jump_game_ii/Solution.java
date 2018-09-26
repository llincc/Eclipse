package jump_game_ii;

import java.util.Arrays;

/*ÌâÄ¿ÃèÊö

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A =[2,3,1,1,4], return true.

A =[3,2,1,0,4], return false.*/
public class Solution {
    public int jump1(int[] A) {
    	int count[] = new int[A.length];
    	Arrays.fill(count, 0);
    	go(A, count, 0);
    	return count[A.length-1];
    }
    public void go(int[] A, int []count, int i){
    	for(int j=1; j<=A[i]; j++){
    		int target = i+j;
    		if(target<A.length && count[target]!=0){
    			count[target] = count[i]+1;
    			go(A, count, target);
    		}
    	}
    }
    
    public int jump2(int []A){
    	int count[] = new int[A.length];
    	int start = 0;
    	int end = A[0];
    	int maxReach = end;
    	for(int i=1; i<A.length && i<=end; i++){
    		count[i] = count[start] + 1;
    		maxReach = Math.max(maxReach, i+A[i]);
    		if(i == end){
    			start = i = end;
    			end = maxReach;
    		}
    	}
    	return count[A.length-1];
    }
    
    public int jump(int []A){
    	int step = 0;
    	int end = 0;
    	int maxReach = 0;
    	for(int i=0; i<A.length; i++){
    		maxReach = Math.max(maxReach, i+A[i]);
    		if(i == end && end != A.length-1){
    			step++;
    			end = maxReach;
    		}
    	}
    	return step;
    }
    
    public static void main(String[] args) {
		int A[] = {2,3,1,1,4};
		System.out.println(new Solution().jump(A));
	}
}
