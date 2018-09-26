package pascals_triangle;

import java.util.ArrayList;

/*Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]*/
public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<numRows; i++){
        	ArrayList<Integer> lastList = new ArrayList<Integer>();
        	if(i != 0) lastList = result.get(i-1);
        	ArrayList<Integer> arrayList = new ArrayList<Integer>();
        	for(int j=0; j<= i; j++){
        		if(j==0||j==i) {
        			arrayList.add(1);
        			continue;
        		}
        		arrayList.add(lastList.get(j-1)+lastList.get(j));
        	}
        	result.add(arrayList);
        }
        return result;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().generate(3));
	}
}
