package gray_code;

import java.util.ArrayList;
/*题目描述

The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return[0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note: 
For a given n, a gray code sequence is not uniquely defined.

For example,[0,2,3,1]is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/
public class Solution {
	/*递归生成码表
	这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
	1位格雷码有两个码字
	(n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
	(n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1 [4] 
	n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
	https://baike.baidu.com/item/%E6%A0%BC%E9%9B%B7%E7%A0%81/6510858?fr=aladdin*/
    public ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if(n==0){
    		result.add(0);
    		return result;
    	}
        ArrayList<String> graycode = new ArrayList<String>();
        graycode.add("0");
        graycode.add("1");
        for(int i=2; i<=n; i++){
        	ArrayList<String> newgraycode = new ArrayList<String>();
        	for(int j=0; j<graycode.size(); j++){
        		newgraycode.add("0"+graycode.get(j));
        	}
        	for(int j=graycode.size()-1; j>=0; j--){
        		newgraycode.add("1"+graycode.get(j));
        	}
        	graycode = newgraycode;
        }
        
        for(String s: graycode){
        	result.add(getValue(s));
        }
        return result;
    }
    
    public int getValue(String s){
    	int value = 0;
    	for(int i=0; i<s.length(); i++) value = (value << 1 )+ s.charAt(i)-'0';
    	return value;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().getValue("100"));
	}
}
