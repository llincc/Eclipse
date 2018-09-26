package restore_ip_addresses;

import java.util.ArrayList;
import java.util.Stack;

/*ÌâÄ¿ÃèÊö

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given"25525511135",

return["255.255.11.135", "255.255.111.35"]. (Order does not matter)*/
public class Solution {
//    public ArrayList<String> restoreIpAddresses(String s) {
//        ArrayList<String> result = new ArrayList<String>();
//        if(s.length()<4 || s.length()>12) return result;
//        for(int i=2; i<=s.length()-2; i++){
//        	ArrayList<String> left = divide(s.substring(0, i));
//        	ArrayList<String> righ = divide(s.substring(i, s.length()));
//        	for(int j=0; j<left.size(); j++){
//        		for(int k=0; k<righ.size(); k++){
//        			result.add(left.get(j)+"."+righ.get(k));
//        		}
//        	}
//        }
//        return result;
//    }
//    private ArrayList<String> divide(String s){
//    	ArrayList<String> div = new ArrayList<String>();
//    	if(s.length()<2 || s.length()>6) return div;	
//    	for(int i=1; i<s.length(); i++){
//    		String left = s.substring(0, i);
//    		String righ = s.substring(i, s.length());
//    		
//    		if(left.length()>3 || righ.length()>3) continue;
//    		if(Integer.valueOf(left)>255 || Integer.valueOf(righ)>255) continue;
//    		if((left.length()!=1 && left.startsWith("0"))||(righ.length()!=1 && righ.startsWith("0"))) continue;
//    		div.add(left+"."+righ);
//    	}
//    	return div;
//    }
    
    private boolean isIp(String s){
		if(s.length()>3 || Integer.valueOf(s)>255 || (s.length()!=1 && s.startsWith("0"))) return false;
		return true;
    }
    
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        GO(s, stack, result);
        return result;
    }
    public void GO(String s, Stack<String> stack,ArrayList<String> result){   	
    	for(int i=1; i<s.length() && i<=3; i++){
    		String left = s.substring(0, i);
    		String rest = s.substring(i);
    		if(stack.size() < 2 && isIp(left)){
    			stack.push(left);
    			GO(rest, stack, result);
    			stack.pop();
    		}
    		else if(stack.size() == 2 && isIp(left) && isIp(rest)){
    			StringBuilder sb = new StringBuilder();
    			for(String str: stack){
    				sb.append(str).append('.');
    			}
    			sb.append(left).append('.');
    			sb.append(rest);
    			result.add(sb.toString());
    		}
    	}
    }
    public static void main(String[] args) {
		String s = "010010";
		System.out.println(new Solution().restoreIpAddresses(s));
	}
}
