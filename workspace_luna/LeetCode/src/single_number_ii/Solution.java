package single_number_ii;

/*Given an array of integers, every element appears three times except for one. Find that single one.

Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

//https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a

public class Solution {
	
	////������
	public int singleNumber(int[] A) {
	    int a = 0, b = 0;
	    for(int c : A) {
	        int ta, tb;
	        ta = a;
	        tb = b;
	        a = (ta & (~tb) & (~c)) | ((~ta) & tb & c);
	        b = ~ta & ((~c & tb) | (~tb & c));

	    }
	    return a | b;

	}
	
	//��һ�ֱ�ʾ��
	//ones������ʾ���ֹ�һ�ε�bits��������������twos��ʾ
	//�� ones�����0 0 ->0, 0 1->1 , 1 0->1, 1 1->1(��ʱ��twos��Ӧ��λ1��ʾ���ֵĶ��Σ�����֮��ones��ӦλΪ0�� twos��ӦλΪ1���ٳ���һ��1,��ones��Ӧλ��Ϊ1����ʱ�ͱ������ֵ�3��)
	
	//ones������ʾ���ֹ����ε�bits��
	
	//���ַ�����������=======������������ô���ģ�ֻҪ��Ӧλ�õ�1���ֵ����Σ��Ͱ����λ����Ϊ0
	//��Ϊ�����ֵ����Σ���Ӧλ�õ�1��Ȼ�ǳ�����3�ı����Σ�
//	public int singleNumber(int[] A) {
//	    int ones = 0;//��¼ֻ���ֹ�1�ε�bits
//	    int twos = 0;//��¼ֻ���ֹ�2�ε�bits
//	    int threes;
//	    for(int i = 0; i < A.length; i++) {
//	        int t = A[i];
//	        twos |= ones & t; //Ҫ�ڸ���onesǰ�����twos   �� ֻ�� 1 1->1
//	        ones ^= t;        
//	        threes = ones & twos; //ones��twos�ж�Ϊ1��������3��
//	        ones &= ~threes;//Ĩȥ������3�ε�bits
//	        twos &= ~threes;
//	    }
//	    return ones;
//	}
}