package unique_binary_search_trees;
/*Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3*/
public class Solution {
    public int numTrees(int n) {
    	if(n==0) return 1;
    	if(n==1) return 1;
    	if(n==2) return 2;
    	int num = 0;
        for(int i=1; i<=n; i++){
        	num += numTrees(i-1) * numTrees(n-i);
        }
        return num;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().numTrees(4));
	}
}
