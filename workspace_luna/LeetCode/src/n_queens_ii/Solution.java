package n_queens_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/*题目描述

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/
public class Solution {
	int count;
	public int totalNQueens(int n) {
		count = 0;
        boolean col[] = new boolean[n+1];    //列
        boolean tip1[] = new boolean[n*2+1]; //右对角斜线 2~2n
        boolean tip2[] = new boolean[n*2+1]; //左对角斜线 2~2n
        nQueens(n, 1, col, tip1, tip2);
        return count;
    }
    public void nQueens(int n, int cou, boolean col[], boolean tip1[], boolean tip2[]){
    	if(cou > n){
    		count++;
    		return;
    	}
    	for(int i=1; i<=n; i++){
    		if(!col[i] && !tip1[cou+i] && !tip2[n-cou+1+i]){
    		    col[i] = true;
    		    tip1[cou+i] = true;
    		    tip2[n-cou+1+i] = true;
    		    nQueens(n, cou+1, col, tip1, tip2);
    		    col[i] = false;
    		    tip1[cou+i] = false;
    		    tip2[n-cou+1+i] = false;
    		}
    	}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().totalNQueens(5));
	}
}
