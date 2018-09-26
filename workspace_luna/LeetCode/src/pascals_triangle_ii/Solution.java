package pascals_triangle_ii;

import java.util.ArrayList;

/*ÌâÄ¿ÃèÊö

Given an index k, return the k th row of the Pascal's triangle.

For example, given k = 3,
Return[1,3,3,1].

Note: 
Could you optimize your algorithm to use only O(k) extra space?*/
public class Solution {
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> lastList = new ArrayList<Integer>();
        for(int i=0; i<=rowIndex; i++){
        	ArrayList<Integer> arrayList = new ArrayList<Integer>();
        	for(int j=0; j<= i; j++){
        		if(j==0||j==i) {
        			arrayList.add(1);
        			continue;
        		}
        		arrayList.add(lastList.get(j-1)+lastList.get(j));
        	}
        	lastList = arrayList;
        }
        return lastList;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().getRow(3));
	}
}
