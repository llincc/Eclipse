package n_queens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/*题目描述

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where'Q'and'.'both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/
public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        boolean col[] = new boolean[n+1];    //列
        boolean tip1[] = new boolean[n*2+1]; //右对角斜线 2~2n
        boolean tip2[] = new boolean[n*2+1]; //左对角斜线 2~2n
        Stack<String> stack = new Stack<String>();
        nQueens(n, 1, col, tip1, tip2, result, stack);
        return result;
    }
    public void nQueens(int n, int cou, boolean col[], boolean tip1[], boolean tip2[], ArrayList<String[]> result, Stack<String> stack){
    	if(cou > n){
    		String a[] = new String[n];
    		stack.toArray(a);
    		result.add(a);
    		return;
    	}
    	for(int i=1; i<=n; i++){
    		if(!col[i] && !tip1[cou+i] && !tip2[n-cou+1+i]){
    		    stack.push(genString(i, n));
    		    col[i] = true;
    		    tip1[cou+i] = true;
    		    tip2[n-cou+1+i] = true;
    		    nQueens(n, cou+1, col, tip1, tip2, result, stack);
    		    col[i] = false;
    		    tip1[cou+i] = false;
    		    tip2[n-cou+1+i] = false;
    		    stack.pop();
    		}
    	}
    }
    public String genString(int i, int len){
    	char chs[] = new char[len];
    	Arrays.fill(chs, '.');
    	chs[i-1] = 'Q';
    	return new String(chs);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().solveNQueens(4).get(0)[0]);
	}
}
