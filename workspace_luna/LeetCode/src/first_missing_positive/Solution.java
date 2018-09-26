package first_missing_positive;
/*��Ŀ����

Given an unsorted integer array, find the first missing positive integer.

For example,
Given[1,2,0]return3,
and[3,4,-1,1]return2.

Your algorithm should run in O(n) time and uses constant space.

*/
public class Solution {
	//����������Ӧ��λ����ȥ�� ���ַ���
    public int firstMissingPositive1(int[] A) {
        if(A == null || A.length ==0) return 1;
        for(int i=0; i<A.length; i++){
        	//ע����whileѭ��
        	//���A[i] == A[A[i]-1]�� i��A[i]-1����λ�õ��������Ҳ j+1 = A[i],˵��A[i]-1λ��������ȷ�����ˣ�iλ�õ������ظ��ģ� 
        	while(A[i]>0 && A[i]!=i+1 && A[i]-1 < A.length && A[i]!=A[A[i]-1]){ 
        		swap(A, i, A[i]-1); //A[i]��ֵ����j = A[i]-1
        	}
        }
        for(int i=0; i<A.length; i++){
        	if(A[i]!=i+1) return i+1;
        }
        return A[A.length-1] + 1;
    }
    //��������
    public int firstMissingPositive(int[] A) {
    	int result[] = new int[A.length];
    	for(int i=0; i<A.length; i++){
    		if(A[i]-1<result.length && A[i]>0){   
    			result[A[i]-1]++;
    		}
    	}
    	int i = 0;
    	while(i<result.length && result[i]!=0) i++;
    	return i+1;
    }
    public void swap(int []A, int i, int j){
    	A[i] = A[i] ^ A[j];
    	A[j] = A[i] ^ A[j];
    	A[i] = A[i] ^ A[j];
    }
    public static void main(String[] args) {
    	int A[] = {1,3};
		System.out.println(new Solution().firstMissingPositive(A));
	}
}
