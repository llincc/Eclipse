package implement_strstr;
/*ÌâÄ¿ÃèÊö

Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.*/
public class Solution {
    public String strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return null;
        if(needle.length() == 0) return haystack;
        int next[] = new int[needle.length()+1];  
        return KMP(haystack, needle, next);       
    }
    private void getNext(int next[], String needle){
    	next[0] = -1;
        int j=-1;
        int i=0;
        while(i<needle.length()){
        	if(j == -1 || needle.charAt(i) == needle.charAt(j)){
        		++i;
        		++j;
        		next[i] = j;
        	}
        	else{
        		j = next[j];
        	}
        }
    }
    private String KMP(String haystack, String needle, int[] next){
    	getNext(next, needle);
    	int i=0;
    	int j=0;
    	while(i<haystack.length() && j<needle.length()){
    		if(j==-1 || haystack.charAt(i) == needle.charAt(j)){
    			++i;
    			++j;
    		}
    		else{
    			j = next[j];
    		}
    	}
    	if(j == needle.length()) return haystack.substring(i-needle.length());
    	return null;
    }
    
    public static void main(String[] args) {
		System.out.println(new Solution().strStr("a", "a"));
	}
}
