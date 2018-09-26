package add_binary;
/*题目描述

Given two binary strings, return their sum (also a binary string).

For example,
a ="11"
b ="1"
Return"100".*/
public class Solution {
//    public String addBinary(String a, String b) {
//        StringBuffer result = new StringBuffer();
//        int c = 0;
//        int i = 0, j=0, v;
//        for(i=a.length()-1, j=b.length()-1; i>=0 && j>=0; i--, j--){
//           v = a.charAt(i) + b.charAt(j) - '0'-'0' + c;
//           c = add(result, v, c);
//        }
//        while(i>=0){
//        	v = c + a.charAt(i--) - '0';
//            c = add(result, v, c);
//        }
//        while(j>=0){
//        	v = c + b.charAt(j--) - '0';
//        	c = add(result, v, c);
//        }
//        if(c == 1) result.append('1');
//        return result.reverse().toString();
//    }
//    private int add(StringBuffer result, int v, int c){
//        if(v > 1){
//     	   c = 1;
//     	   v -= 2;
//        }
//        else{
//     	   c = 0;
//        }
//        result.append((char)(v+'0'));
//        return c;
//    }
    
    public String addBinary(String a, String b) {
    	StringBuilder res = new StringBuilder();
    	int i = a.length() - 1, j = b.length() - 1, carry = 0;
    	
    	while (i >= 0 || j >= 0 || carry != 0) {
	    	int sum = carry;
	    	if (i >= 0)
	    		sum += a.charAt(i--) - '0';
	    	if (j >= 0)
	    		sum += b.charAt(j--) - '0';
	    	res.append(sum % 2);
	    	carry = sum / 2;
    	}
    	//res是倒序，必须进行反转
    	return res.reverse().toString();
    }
    public static void main(String[] args) {
		String a = "11";
		String b = "";
		System.out.println(new Solution().addBinary(a, b));
	}
}
