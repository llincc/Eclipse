package evaluate_reverse_polish_notation;

import java.util.Stack;
//逆波兰表达式求值
public class Solution {
    public int evalRPN(String[] tokens) {  	
        Stack<Integer> stack = new Stack<Integer>();
        int v1, v2;
        for(String item: tokens){
        	switch (item) {
				case "+":
					stack.push(stack.pop()+stack.pop());
					break;
				case "-":
					v1 = stack.pop();
					v2 = stack.pop();
					stack.push(v2 - v1);
					break;
				case "*":
					stack.push(stack.pop()*stack.pop());
					break;
				case "/":
					v1 = stack.pop();
					v2 = stack.pop();
					stack.push(v2 / v1);
					break;
				default:
					stack.push(Integer.valueOf(item));
			}
        }       
        return stack.pop();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String[] a = {"2", "1", "+", "3", "*"};
		System.out.println(solution.evalRPN(a));

	}

}
