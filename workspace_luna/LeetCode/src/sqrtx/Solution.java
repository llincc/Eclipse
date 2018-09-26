package sqrtx;
/*ÌâÄ¿ÃèÊö

Implementint sqrt(int x).

Compute and return the square root of x.*/
public class Solution {
    public int sqrt(int x) {
        long left = 0;
        long right = x;
        long mid = 0, v;
        while(left<=right){
        	mid = (left+right)/2;
        	v = mid * mid;
        	if(v == x) break;
        	if(v < x) left = mid+1;
        	else right = mid-1; 
        }
        if(mid * mid > x) mid--;
        return (int) mid;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().sqrt(625));
	}
}
