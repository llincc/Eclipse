package generate_parentheses;

import java.util.ArrayList;

/*题目描述

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"*/
public class Solution {
	//先左后右，左个数>=右个数
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        DFS(result, sb, 0, 0, n);
        return result;
    }
    private void DFS(ArrayList<String> result, StringBuilder sb, int leftnum, int rightnum, int n){
    	if(rightnum == n){
    		result.add(sb.toString());
    		return;
    	}
    	if(leftnum<n){
    		sb.append('(');
    		DFS(result, sb, leftnum+1, rightnum, n);
    		sb.deleteCharAt(sb.length()-1);
    	}
    	if(leftnum>rightnum){
    		sb.append(')');
    		DFS(result, sb, leftnum, rightnum+1, n);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().generateParenthesis(6));
	}
}
