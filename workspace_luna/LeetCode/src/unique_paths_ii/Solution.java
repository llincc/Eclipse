package unique_paths_ii;
/*��Ŀ����

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as1and0respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is2.

Note: m and n will be at most 100.

*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 0? 1:0;
        for(int i=1; i<m; i++){
        	if(obstacleGrid[i][0] == 0) dp[i][0] = dp[i-1][0];
        	else dp[i][0] = 0;
        }
        for(int j=1; j<n; j++){
        	if(obstacleGrid[0][j] == 0) dp[0][j] = dp[0][j-1];
        	else dp[0][j] = 0;
        }
        for(int i=1; i<m ;i++){
        	for(int j=1; j<n; j++){
        		if(obstacleGrid[i][j] == 0) dp[i][j] = dp[i][j-1] + dp[i-1][j];
        		else dp[i][j] = 0;
        	}
        }
        return dp[m-1][n-1]; 
    }
}
