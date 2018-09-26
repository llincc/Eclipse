package word_break;

import java.util.HashSet;
import java.util.Set;

//Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
//
//For example, given
//s ="leetcode",
//dict =["leet", "code"].
//
//Return true because"leetcode"can be segmented as"leet code".



public class Solution {
	
	//����һ�������ھ������˵Ľⷨ
	//�Ӵ����ȴ�1��s.length()�𽥼����Ӵ��Ƿ��ܲ��
	//ת̬ת�Ʒ��̣�Fi,j = {Fi,j, Fi,i+1 & Fi+1,j, Fi,i+2 & Fi+2,j,����, Fi,j-1 & Fj-1,j }

	//ȱ�㣺�в���Ҫ�ļ��㣬��Ϊ�ַ��������ͷ��ʼ���ܲ�֣����ַ����Եö����ˣ�Fi,j��i����Ϊ0������Ҫ������Fi,j���м��㣩
//    public boolean wordBreak(String s, Set<String> dict) {
//        
//    	boolean[][] breakmatrix = new boolean[s.length()][s.length()+1];
//    	
//    	for(int r=1; r<= s.length(); r++){//���ַ�������r = 1.....s.length()
//    		for(int start=0; start<s.length() - r +1; start++){//���ַ�����ʼλ��
//    		     int end = start + r; //���ַ�������λ��
//    		     String substr = s.substring(start, end);
//    		     if(dict.contains(substr)) breakmatrix[start][end] = true;
//    		     else{
//    		    	 breakmatrix[start][end] = false;
//    		    	 for(int j=start+1; j<end; j++){
//    		    		 boolean isbreak = breakmatrix[start][j] & breakmatrix[j][end];
//    		    		 if(isbreak){
//    		    			 breakmatrix[start][end] = true;
//    		    			 break;
//    		    		 }
//    		    	 }
//    		     }
//    		     
//    		}
//    	}
//    	return breakmatrix[0][s.length()];
//    }
    
	//��������ת̬ת�Ʒ���f(i) = f(j) && f(j+1,i); 0 <= j < i;
    public boolean wordBreak(String s, Set<String> dict) {
        
    	boolean[] breakmatrix = new boolean[s.length()+1];
    	breakmatrix[0] = true;

    	for(int r=1; r<= s.length(); r++){//������ַ�������r = 1.....s.length()
    		for(int i=0; i<r; i++){
    			if(breakmatrix[i] && dict.contains(s.substring(i, r))){
    				breakmatrix[r] = true;
    				break;
    			}
    		}
    	}
    	return breakmatrix[s.length()];
    }
    public static void main(String[] args) {
    	Solution solution = new Solution();
		String s = "leetcod";
		Set<String> dict = new HashSet<String>();
		dict.add("leet");
		dict.add("code");
		System.out.println(solution.wordBreak(s, dict));
		
	}
}
