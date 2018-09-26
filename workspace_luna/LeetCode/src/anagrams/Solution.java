package anagrams;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        
        boolean isAdd = false;
        boolean hasAdd[] = new boolean[strs.length];
        int cou[] = new int[26];
        int counter = 0;
        for(int i=0; i<strs.length; i++){
        	if(hasAdd[i]) continue;
        	String str = strs[i];
    		counter = 0;
    		Arrays.fill(cou, 0);
    		for(int j=0; j<str.length(); j++){
    			cou[str.charAt(j)-'a']++;
    			counter++;
    		}
    		isAdd = false;
        	for(int j=i+1; j<strs.length; j++){
        		if(hasAdd[j]) continue;
        	    String strj = strs[j];
        		int nowcounter = counter;   		
        		int count[] = Arrays.copyOf(cou, cou.length);
        		boolean noana = false;
        		for(int k=0; k<strj.length(); k++){
        			if(count[strj.charAt(k)-'a']>0){
        				count[strj.charAt(k)-'a']--;
        				nowcounter--;
        			}
        			else{
        				noana = true;
        				break;
        			}
        		}
        		if(noana) continue;
        		if(nowcounter == 0){
        			
        			if(!isAdd){
        				result.add(str);
        				isAdd = true;
        			}
        			result.add(strj);
        			hasAdd[j] = true;
        		}
        	}
        }
        return result;
    }
    
    public ArrayList<String> anagrams2(String[] strs) {
    	ArrayList<String> result = new ArrayList<String>();
    	int cou[][] = new int[strs.length][26];
    	for(int i=0; i<strs.length; i++){
    		String str = strs[i];
    		for(int j=0; j<str.length(); j++){
    			cou[i][str.charAt(j)-'a']++;
    		}
    	}
    	boolean hasAdd[] = new boolean[strs.length];
    	for(int i=0; i<strs.length; i++){
    		if(hasAdd[i]) continue;
    		for(int j=i+1; j<strs.length; j++){
    			if(hasAdd[j]) continue;
    			boolean isana = true;
    			for(int k=0; k<26; k++){
    				if(cou[i][k] != cou[j][k]){
    					isana = false;
    					break;
    				}
    			}
    			if(isana){
    				if(!hasAdd[i]){
    					result.add(strs[i]);
    					hasAdd[i] = true;
    				}
    				result.add(strs[j]);
    				hasAdd[j] = true;
    			}
    		}
    	}
    	return result;
    
    }
    public static void main(String[] args) {
		String strs[] = {"eat","ate","and","edn","tea"};
		System.out.println(new Solution().anagrams(strs));
	}
}
