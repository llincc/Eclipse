package decode_ways;

import java.awt.datatransfer.StringSelection;
import java.util.Stack;

/*题目描述

A message containing letters fromA-Zis being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message"12", it could be decoded as"AB"(1 2) or"L"(12).

The number of ways decoding"12"is 2.*/
public class Solution {
    public int numDecodings(String s) {
    	if("".equals(s)) return 0;
        int num[] = new int[s.length()+1];
        num[0] = 1;
        if(s.charAt(0)-'0'>0) num[1] = 1;
        for(int len=2; len<=s.length(); len++){ //长度为len是可以划分的个数
        	if(s.charAt(len-1)-'0'>0) num[len] += num[len-1];
        	int v = Integer.valueOf(s.substring(len-2, len));
        	if(v<=26 && v>=10) num[len]+=num[len-2]; //前一个字符不能为0（即两个字符大于等于10），两个字符不能大于26
        } 
        return num[s.length()];
    }
    public static void main(String[] args) {
		System.out.println(new Solution().numDecodings("00"));
	}
}
