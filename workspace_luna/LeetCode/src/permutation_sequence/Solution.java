package permutation_sequence;
/*��Ŀ����

The set[1,2,3,��,n]contains a total of n! unique permutations.

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
    	total = total / n;                 //��ͬ��ͷ�����ж����ֱ仯 ����123 132���� ���ܹ�6��  6 / 3 = 2
    	int count  = (k - 1) / total + 1;  //��ͷ������n�����ֵĵڼ������֣��൱�ڵڼ��У�  
    	int next_k = (k - 1) % total + 1;  //�൱�ڵڼ���                                                                                 
    	int i = 1;                                                                    
    	while(count > 0){  //�ҵ�count��û�ù�������
    		if(!num[i]) count--;			
    		i++;
    	}
    	i--;
    	num[i] = true; // ����i���꣬��Ϊtrue
    	return String.valueOf(i)+getResult(num, total, n-1, next_k);	
    }
    
}
