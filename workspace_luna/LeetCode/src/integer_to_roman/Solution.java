package integer_to_roman;
/*Ã‚ƒø√Ë ˆ

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.*/
public class Solution {
    public String intToRoman(int num) {
        String roman[][] = {{"I","II","III","IV","V","VI","VII","VIII","IX"}
                           ,{"X","XX","XXX","XL","L","LX","LXX","LXXX","XC"}
                           ,{"C","CC","CCC","CD","D","DC","DCC","DCCC","CM"}
                           ,{"M","MM","MMM"}};
        int lev = 0;
        int i =0;
        StringBuilder sb = new StringBuilder();
        while(true){
        	lev = num % 10;
        	num = num / 10;
        	if(lev != 0){
        		sb.insert(0, roman[i][lev-1]);
        	}
        	i++;
        	if(num == 0) break;
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().intToRoman(49));
	}
}
