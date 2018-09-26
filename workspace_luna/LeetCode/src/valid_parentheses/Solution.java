package valid_parentheses;

import java.util.Stack;

/*ÌâÄ¿ÃèÊö

Given a string containing just the characters'(',')','{','}','['and']', determine if the input string is valid.

The brackets must close in the correct order,"()"and"()[]{}"are all valid but"(]"and"([)]"are not.*/
public class Solution {
    public boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
        	char ch = s.charAt(i);
        	if(ch == '{' || ch == '[' || ch == '('){
        		stack.push(ch);
        	}
        	else{
        		if(stack.isEmpty()) return false;
        		char pch = stack.pop();
        		if((ch == '}' && pch != '{')||(ch == ']' && pch != '[')||( ch == ')' && pch != '(')){
        			return false;
        		}
        	}
        }
        return stack.isEmpty();
    }
    
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
        	char ch = s.charAt(i);
        	if(ch == '{') stack.push('}');
        	else if(ch == '[') stack.push(']');
        	else if(ch == '(') stack.push(')');
        	else if(stack.isEmpty() || stack.pop() != ch){
        		return false;
        	}
        }
        return stack.isEmpty();
    }
}
