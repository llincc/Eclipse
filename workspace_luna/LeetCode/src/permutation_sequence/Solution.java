package permutation_sequence;
/*题目描述

The set[1,2,3,…,n]contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"

Given n and k, return the k th permutation sequence.

Note: Given n will be between 1 and 9 inclusive.*/
public class Solution {
    public String getPermutation(int n, int k) {
    	boolean num[] = new boolean[n+1];
    	int total = 1;
    	for(int i=1; i<=n; i++) total *= i;
        return getResult(num, total, n, k );
    }
    public String getResult(boolean num[],  int total, int n, int k){
    	if(n == 0) return "";
    	total = total / n;                 //相同开头数字有多少种变化 比如123 132两种 ，总共6种  6 / 3 = 2
    	int count  = (k - 1) / total + 1;  //开头是余下n个数字的第几个数字（相当于第几行）  
    	int next_k = (k - 1) % total + 1;  //相当于第几列                                                                                 
    	int i = 1;                                                                    
    	while(count > 0){  //找第count个没用过的数字
    		if(!num[i]) count--;			
    		i++;
    	}
    	i--;
    	num[i] = true; // 数字i用完，设为true
    	return String.valueOf(i)+getResult(num, total, n-1, next_k);	
    }
    
}
