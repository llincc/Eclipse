package single_number_ii;

/*Given an array of integers, every element appears three times except for one. Find that single one.

Note: 
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?*/

//https://www.nowcoder.com/questionTerminal/1097ca585245418ea2efd0e8b4d9eb7a

public class Solution {
	
	////三进制
	public int singleNumber(int[] A) {
	    int a = 0, b = 0;
	    for(int c : A) {
	        int ta, tb;
	        ta = a;
	        tb = b;
	        a = (ta & (~tb) & (~c)) | ((~ta) & tb & c);
	        b = ~ta & ((~c & tb) | (~tb & c));

	    }
	    return a | b;

	}
	
	//另一种表示，
	//ones仅仅表示出现过一次的bits，出现两次则由twos表示
	//即 ones是异或，0 0 ->0, 0 1->1 , 1 0->1, 1 1->1(这时用twos相应的位1表示出现的二次，二次之后ones对应位为0， twos对应位为1，再出现一个1,则ones对应位变为1，这时就表明出现的3次)
	
	//ones仅仅表示出现过二次的bits，
	
	//这种方法容易想象=======》不管数是怎么样的，只要相应位置的1出现的三次，就把这个位置置为0
	//因为数出现的三次，对应位置的1必然是出现了3的倍数次，
//	public int singleNumber(int[] A) {
//	    int ones = 0;//记录只出现过1次的bits
//	    int twos = 0;//记录只出现过2次的bits
//	    int threes;
//	    for(int i = 0; i < A.length; i++) {
//	        int t = A[i];
//	        twos |= ones & t; //要在更新ones前面更新twos   即 只有 1 1->1
//	        ones ^= t;        
//	        threes = ones & twos; //ones和twos中都为1即出现了3次
//	        ones &= ~threes;//抹去出现了3次的bits
//	        twos &= ~threes;
//	    }
//	    return ones;
//	}
}