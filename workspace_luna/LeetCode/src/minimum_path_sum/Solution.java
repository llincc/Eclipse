package minimum_path_sum;
/*ÌâÄ¿ÃèÊö

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/
public class Solution {
    public int minPathSum(int[][] grid) {
    	for(int i=1; i<grid.length; i++) grid[i][0] += grid[i-1][0];
    	for(int j=1; j<grid[0].length; j++) grid[0][j] += grid[0][j-1];
        for(int i=1; i<grid.length; i++){
        	for(int j=1; j<grid[0].length; j++){
        		grid[i][j] = Math.min(grid[i-1][j]+grid[i][j], grid[i][j-1]+grid[i][j]);
        	}
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
