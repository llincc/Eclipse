package simplify_path;

import java.util.Stack;

 

/*ÌâÄ¿ÃèÊö
Given an absolute path for a file (Unix-style), simplify it.

For example,
path ="/home/", =>"/home"
path ="/a/./b/../../c/", =>"/c"

click to show corner cases.

Corner Cases:

Did you consider the case where path ="/../"?
In this case, you should return"/".
Another corner case is the path might contain multiple slashes'/'together, such as"/home//foo/".
In this case, you should ignore redundant slashes and return"/home/foo".*/
public class Solution {
    public String simplifyPath(String path) {
        String paths[] = path.split("/|//");
        Stack<String> stack = new Stack<String>();
        for(String str: paths){
        	if("".equals(str) || ".".equals(str)) continue;
        	if("..".equals(str) ){
        		if(!stack.isEmpty()) stack.pop();
        	}
        	else{
        		stack.push(str);
        	}
        }
        
        String result = stack.isEmpty() ? "/" : "";
        while(!stack.isEmpty()){
        	result = "/" + stack.pop() + result;
        }
        return result;
    }
	
	public static void main(String[] args) {
		String path = "/home/node/../home//s";
		System.out.println(new Solution().simplifyPath(path));
	}
}
