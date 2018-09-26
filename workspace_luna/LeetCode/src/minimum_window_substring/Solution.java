package minimum_window_substring;
/*��Ŀ����

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S ="ADOBECODEBANC"
T ="ABC"

Minimum window is"BANC".

Note: 
If there is no such window in S that covers all characters in T, return the emtpy string"".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

*/
public class Solution {
    public String minWindow(String S, String T) {
        int count[] = new int[128];
        for(int i=0; i<T.length(); i++) count[T.charAt(i)]++;
        
        int start = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        
        while(end< S.length()){
        	if(count[S.charAt(end++)]-->0){ //������>0����<=0�� count����Ҫ������counterֻ����>0ʱ�Ż��
        		counter--;
        	}
        	while(counter == 0){
        		if(end - start < d){
        			head = start;
        			d = end - start;
        		}
        		if(count[S.charAt(start++)]++ == 0){  //start��T�ַ������Ƕ����T�ַ���AA��Ӧ��count��Ȼ<0�����!=0������T�ַ���Ȼ==0
        			// = 0˵��Ŀǰ[start , end)��ε������S.charAt(start)�ַ������պã�
        			counter++;
        		}
        	}
        }
        return d == Integer.MAX_VALUE ? "": S.substring(head, head+d);
    }
    public static void main(String[] args) {
		String S = "KAACFECATMCF";
		String T = "ACF";
		System.out.println(new Solution().minWindow(S, T));
	}
}
