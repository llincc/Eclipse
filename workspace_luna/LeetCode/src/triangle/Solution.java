package triangle;

import java.util.ArrayList;
/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).

Note: 
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.

*/
public class Solution {
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
         	
    	int smaller[] = new int[triangle.get(triangle.size()-1).size()];
    	for(int i=triangle.size()-1; i>=0; i--){
    		ArrayList<Integer> children = triangle.get(i);
    		smaller[0] += children.get(0);
    		for(int j=1; j<children.size(); j++){
    			smaller[j] += children.get(j);
    			smaller[j-1] = Math.min(smaller[j-1], smaller[j]);
    		}
    	}
    	return smaller[0];
    }
}
