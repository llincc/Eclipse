package palindrome_partitioning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s ="aab",

�ҵ����л����Ӵ�����
Return

[
  ["aa","b"],
  ["a","a","b"]
]*/
public class Solution {
	//�����ȷ�������˳����𰸲�һ��
//    public ArrayList<ArrayList<String>> partition(String s) {
//        ArrayList<ArrayList<String>> strArr = new ArrayList<ArrayList<String>>();
//        strArr.add(new ArrayList<String>());
//        for(int len=1; len<=s.length(); len++){
//        	ArrayList<String> posArr = new ArrayList<String>();
//        	ArrayList<String> lefArr;
//        	
//	    	for(int i=0; i<len; i++){
//				String leaveStr = s.substring(i, len); //���ַ����ұ�ʣ�µ��ַ���
//				lefArr = strArr.get(i);
//				if(i == 0 && isPalindrome(leaveStr)){
//					posArr.add(leaveStr);
//					continue;
//				}
//				if(lefArr.size() != 0 && isPalindrome(leaveStr)){//lefArr.size() != 0˵������Ӵ��ܲ��
//					//�Ӵ�����߲��ֺ��ұ߲�������
//					for(String leftStr: lefArr){
//						posArr.add(leftStr+" "+leaveStr);
//					}
//				}
//			}
//			strArr.add(posArr); 		
//    	}
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//        for(String spl: strArr.get(s.length())){    
//        	result.add(new ArrayList<String>(Arrays.asList(spl.split(" "))));
//        }
//        return result;
//    }
//    
    private boolean isPalindrome(String str){
    	int i,j;
    	
    	for(i=0, j=str.length()-1; i<=j && str.charAt(i)==str.charAt(j); i++, j--);
//    	System.out.println("i="+i+" j="+j);
    	return i>j;
    }
    
/*	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>>  list=new ArrayList<ArrayList<String>>();
		boolean[] flag=new boolean[s.length()];     //flag[i]==true,��ʾ��iλ������ָ�����������Ĵ���
		func(list,s,new StringBuffer(),s.length(),flag);
		return list;
	}
	private void func(ArrayList<ArrayList<String>>list, String s, StringBuffer ans, int i, boolean[] flag) {
	    for(int j = i - 1; j >= 0; j--) {
	        if(isPalindrome(s.substring(j, i))) {
	            StringBuffer tmp = new StringBuffer(ans);
	            if(j == 0) {
	                tmp.insert(0, s.substring(j, i)); //�ҵ���ͷ
	                list.add(new ArrayList<String>(Arrays.asList(tmp.toString().split(" "))));
	            } else {
	                if(flag[j] == false) {         //���flag[j] = true����˵����j���ﻮ������Ч�ģ�֮ǰ���Եó��Ľ����
	                    int oldsize = list.size(); //�ݹ����ǰsub(0,j)֮ǰ�б���
	                    tmp.insert(0, " " + s.substring(j, i));
	                    func(list, s, tmp, j, flag); //����sub(0,j)
	                    if(oldsize == list.size()) //����б���û�仯��˵�����ﻮ������Ч�ģ���ʹsub(j, i)ȷʵ���ֵ��У�
	                        flag[j] = true;
	                }
	            }
	        }
	    }
	}
	*/
	public ArrayList<ArrayList<String>> partition(String s) {
		ArrayList<ArrayList<String>> strArr = new ArrayList<ArrayList<String>>();
		Stack<String> subArr = new Stack<String>();
        dfs(s, subArr, strArr);
        return strArr;
        
	}
	void dfs(String s, Stack<String> subArr, ArrayList<ArrayList<String>> strArr ){
		if (s.length()==0) {
			strArr.add(new ArrayList<String>(subArr));
			return;
		}
		for(int i=1; i<=s.length(); i++){
			String leaveStr = s.substring(0, i);
			if(isPalindrome(leaveStr)){
				subArr.push(leaveStr);
				dfs(s.substring(i), subArr, strArr);
				subArr.pop();
			}
		}
	}
	
    public static void main(String[] args) {
    	Solution solution = new Solution();
		String s = "ab";
		System.out.println(solution.partition(s));
		

	}
}
