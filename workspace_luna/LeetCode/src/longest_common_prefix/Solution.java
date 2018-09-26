package longest_common_prefix;
/*Ã‚ƒø√Ë ˆ

Write a function to find the longest common prefix string amongst an array of strings.*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
    	if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        String firstStr = strs[0];
        for(int i=0; i<firstStr.length(); i++){
        	char ch = firstStr.charAt(i);
        	boolean isCommon = true;
        	for(int j=1; j<strs.length; j++){
        		if(i>= strs[j].length() || strs[j].charAt(i) != ch){
        			isCommon = false;
        			break;
        		}
        	}
        	if(isCommon){
        		sb.append(ch);
        	}
        	else{
        		break;
        	}
        }    
        return sb.toString();
    }
}
