package valid_number;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
//ÌâÄ¿ÃèÊö

/*Validate if a given string is numeric.

Some examples:
"0"=>true
" 0.1 "=>true
"abc"=>false
"1 a"=>false
"2e10"=>true

Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.*/
public class Solution {
    public boolean isNumber(String s) {
        return s.matches("\\s*(\\+?|-?)((\\d+\\.?\\d*)|(\\d*\\.?\\d+))(e(\\+?|-?)\\d+)?\\s*");
    }
    public static void main(String[] args) {
		String s = "-1e1";
		System.out.println(new Solution().isNumber(s));
	}
}
