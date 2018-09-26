package powx_n;
/*ÌâÄ¿ÃèÊö

Implement pow(x, n).*/
public class Solution {
	
    public double pow(double x, int n) {
       if(n >= 0) return pows(x, n);
       else return 1 / pows(x, -n);
    }
    private double pows(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;
        double divpow = pows(x, n / 2);
        return divpow * divpow * (n % 2 == 1? x : 1);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().pow(2, 10));
	}
}
