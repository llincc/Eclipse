package divide_two_integers;

/*��Ŀ����

	Divide two integers without using multiplication, division and mod operator.

*/
public class Solution {
    public int divide(int dividend, int divisor) {
       if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) return Integer.MAX_VALUE;
       int sign = ((dividend<0)^(divisor<0)) ? -1 : 1;   	
	   int result = 0;
	   long dvd = Math.abs((long)dividend);  //��תlong����Ȼ abs(Integer.MIN_VALUE) = Integer.MIN_VALUE �һᳬʱ
	   long dsr = Math.abs((long)divisor);
	   while(dsr <= dvd){
           long tmp = dsr;
           int factor = 1;
           while(dvd > tmp){
           	   if(dvd < (tmp << 1)) break;  
           	   tmp <<= 1;
               factor <<= 1;  
           }
           result += factor;
           dvd = dvd - tmp;
	   	}
	    return sign > 0 ? result : -result; //�涨���ܳ�
    }
    

    public int add(int a, int b) {
    	int sum = a;
    	int arr = b;// ��ʾ��λ
    	while (arr != 0) {
	    	sum = a ^ b;        //����ֻ��һ��Ϊ1�ı�����������û�н�λ�ĵط���  
	    	arr = (a & b) << 1; //ֻҪ����1�Ż�Ϊ1��Ȼ�����ƣ� ����һλ   
	    	a = sum;
	    	b = arr;
    	}
    	return sum;
    }
    public static void main(String[] args) {
		System.out.println(new Solution().add(526586, 532899));
		System.out.println(Integer.MIN_VALUE/53654);
	}
}
