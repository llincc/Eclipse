package letter_combinations_of_a_phone_number;

import java.util.ArrayList;

/*ÌâÄ¿ÃèÊö

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note: 
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/
public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
    	ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        list.add("0");
        list.add("1");
        list.add("abc");
        list.add("def");
        list.add("ghi");
        list.add("jkl");
        list.add("mno");
        list.add("pqrs");
        list.add("tuv");
        list.add("wxyz");    
        StringBuilder sb = new StringBuilder();
        DFS(result, list, sb, 0, digits);
        return result;
    }
    private void DFS(ArrayList<String> result, ArrayList<String> list, StringBuilder sb, int i, String digits){
    	if(i == digits.length()){
    		result.add(sb.toString());
    		return;
    	}
    	String cur = list.get(digits.charAt(i)-'0');
    	for(int j=0; j<cur.length(); j++){
    		sb.append(cur.charAt(j));
    		DFS(result, list, sb, i+1, digits);
    		sb.deleteCharAt(sb.length()-1);
    	}
    }
    public static void main(String[] args) {
		System.out.println(new Solution().letterCombinations("2"));
	}
}
