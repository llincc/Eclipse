package longest_valid_parentheses;

import java.util.Stack;

/*题目描述

Given a string containing just the characters'('and')', find the length of the longest valid (well-formed) parentheses substring.

For"(()", the longest valid parentheses substring is"()", which has length = 2.

Another example is")()())", where the longest valid parentheses substring is"()()", which has length = 4.

*/
public class Solution {
    public int longestValidParentheses1(String s) {
        int maxLenght = 0;
        Stack<Integer>  inStack = new Stack<Integer>();
        int sip[] = new int[s.length()]; //记录 sip[i]是否和之前有配对
        for(int i=0; i<s.length(); i++) sip[i] = i;
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) == '('){
        		inStack.push(i);
        	}
        	else{
        		if(!inStack.isEmpty() && s.charAt(inStack.peek())=='('){
        			int preIndex = inStack.pop();
        			if(preIndex-1>=0 && sip[preIndex-1]!=preIndex-1){
        				preIndex = sip[preIndex-1];
        			}
        			sip[i] = preIndex;
        			maxLenght = Math.max(i-preIndex+1, maxLenght);
        		}
        	}
        }
        return maxLenght;       
    }
    
    public int longestValidParentheses(String s) {
        int maxLenght = 0;
        Stack<Integer>  inStack = new Stack<Integer>();
        int last = -1;
        for(int i=0; i<s.length(); i++){
        	if(s.charAt(i) == '('){
        		inStack.push(i);
        	}
        	else{
        		if(inStack.isEmpty()){
        			last = i;
        		}
        		else{
        			inStack.pop();
        			if(inStack.isEmpty()){
        				maxLenght = Math.max(maxLenght, i-last);
        			}
        			else{
        				maxLenght = Math.max(maxLenght, i-inStack.peek());
        			}
        		}
        	}
        }
        return maxLenght;       
    }
    public static void main(String[] args) {
		System.out.println(new Solution().longestValidParentheses(")()()"));
	}
}
