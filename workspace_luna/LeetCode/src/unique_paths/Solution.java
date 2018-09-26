package unique_paths;
/*��Ŀ����

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?



Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.

*/
public class Solution {
	//������Ϸ����Ƚ�m���ֳ�div�֣��ٽ�div�ݲ��뵽n��
    public int uniquePaths1(int m, int n) {
        m = m - 1;
        n = n - 1;
        if(n == 0 || m == 0) return 1;
        if(n == 1 || m == 1) return Math.max(n, m)+1;
        int cn = Math.max(n, m);
        int cm = Math.min(n, m);
        int result = 0;
        for(int div = 1; div<= cm; div++){  //div�� m�Ļ��ָ���
            result += Comb(cm-1, div-1) * Comb(cn+1, div);
        }
        return result;     
    }  
    public int Comb(int cn, int cm){
    	if(cn == cm || cm == 0 || cn == 0) return 1;
    	cm = Math.min(cn - cm, cm);
    	long fenzi = 1;
    	for(int i=cn; i>= cn-cm+1; i--) fenzi *= i;
    	long fenmu = 1;
    	for(int j=2; j<= cm; j++) fenmu *= j;
    	return (int) (fenzi / fenmu);
    }
    //��̬�滮
    public int uniquePaths2(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i=0; i<m; i++) dp[i][0] = 1;
        for(int j=0; j<n; j++) dp[0][j] = 1;
        for(int i=1; i<m ;i++){
        	for(int j=1; j<n; j++){
        		dp[i][j] = dp[i][j-1] + dp[i-1][j];
        	}
        }
        return dp[m-1][n-1];     
    }  
    //���򵥵��������
    public int uniquePaths(int m, int n) {
        long x = m + n -2 ;//�ܹ��Ĳ���;   C(x, y)   x��������m-1��������
        long y = Math.min(m, n) - 1;
        long up = 1, down = 1;
        for(int i=(int) x; i>=x-y+1; i--) up *= i;
        for(int i=1; i<=y; i++) down *= i;
        return (int)(up/down);     
    }  
    public static void main(String[] args) {
		System.out.println(new Solution().uniquePaths(23, 12));
	}
}
