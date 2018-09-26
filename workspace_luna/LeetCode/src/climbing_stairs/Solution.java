package climbing_stairs;

import java.awt.color.CMMException;

/*ÌâÄ¿ÃèÊö

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

*/
public class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return 0+n;
        int one = 1;
        int two = 2;
        int three = 3;
        for(int i=3; i<=n; i++){
        	three = one + two;
        	one = two;
        	two = three;
        }
        return three;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().climbStairs(6));
	}
}
