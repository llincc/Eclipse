package substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*Ã‚ƒø√Ë ˆ

You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S:"barfoothefoobarman"
L:["foo", "bar"]

You should return the indices:[0,9].
(order does not matter).

*/
public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        for(String string: L){
        	if(strMap.containsKey(string)) strMap.put(string, strMap.get(string)+1);
        	else strMap.put(string, 1);
        }
        int n = S.length();
        int num = L.length;
        int len = L[0].length();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i=0; i< n - num * len + 1; i++){
        	 Map<String, Integer>  sub = new HashMap<String, Integer>();
        	 int j=0; 
        	 for(; j<num; j++){
        		 String word = S.substring(i+j*len, i+j*len+len);
        		 Integer realCount = strMap.get(word);
        		 Integer curCount;
                 if(realCount != null){
                	 curCount = sub.get(word);
                	 if(curCount != null) curCount++;
                	 else curCount = 1;
                	 if(curCount > realCount) break;
                	 sub.put(word, curCount);
                 }
        		 else break;
        	 }
        	 if(j == num) result.add(i);
        }
        return result;
    }
    public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int a = map.get(0);
		System.out.println(a);
	}
}
