package longest_consecutive_sequence;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*Ã‚ƒø√Ë ˆ

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given[100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.

Your algorithm should run in O(n) complexity.*/

public class Solution {
    public int longestConsecutive(int[] num) {
        Set<Integer> set = new HashSet<Integer>();
        for(int n: num) set.add(n);
        
        int maxsum = 0;
        for(int n: num){
        	if(set.contains(n)){
        		set.remove(n);
        		int sum = 1;
        		int val_left = n-1;
        		int val_right = n+1;
        		while(set.contains(val_left)){
        			set.remove(val_left);
        			sum++;
        			val_left--;		
        		}
        		while(set.contains(val_right)){
        			set.remove(val_right);
        			sum++;
        			val_right++;
        		}
        		maxsum = Math.max(maxsum, sum);
        	}
        }
        return maxsum;
    }
    
    public static void main(String[] args) {
    	
//    	ArrayList<Integer> list = new ArrayList<Integer>();
//	    for(int i=0; i<32 ; i++){
//	    	list.add((int) Math.pow(2, i));
//	    }
//	    System.out.println(list);
    	int a[] = {100,1,200,3,4,2};
    	System.out.println(new Solution().longestConsecutive(a));
	}
}
