package regular_expression_matching;

import javax.lang.model.element.Element;

/*题目描述

Implement regular expression matching with support for'.'and'*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true*/
public class Solution {
    public boolean isMatch1(String s, String p) {
    	
    	char schars[] = s.toCharArray();
    	char pchars[] = p.toCharArray();
    	
    	int i, j;
    	int lens = s.length(), lenp = p.length();   //aab  .*aab;
        for(i=0, j=0; i<lens && j<lenp; ){
        	char s_ch = schars[i];
        	char p_ch = pchars[j];
        	if(s_ch == p_ch || p_ch == '.'){
        		if(p_ch == '.') pchars[j] = s_ch;
        		i++;
        		j++;
        	}
        	else if( p_ch != '*' && j<lenp-1 && pchars[j+1]=='*'){  // ab    ac* 情况
        		j += 2; // * 用于抵消c了，不用了 直接 i和 j+2比
        	}
        	else if(p_ch == '*'){
        		if( j > 0 && (pchars[j-1] == '.' || pchars[j-1] == s_ch)){ // aa   a*的情况 和 aa .*的情况
        			if(pchars[j-1] == '.') pchars[j-1] = s_ch;  //.替代了s_ch，那么就只能替代它了
        			i++;  //j不能加，可能i+1需要继续匹配*如 aaa  a*b
        		}
        		else{
        			j++; //  aab  aa*c的情况  //*跳过
        		}
        	}
        	else{
        		break;
        	}
        }
        return i == lens;
    }
    
    
    public boolean isMatch(String s, String p) {  //aab .*aab      ab   ac*
       /*
    		    动态规划
    		    如果 p[j] == str[i] || pattern[j] == '.', 此时dp[i][j] = dp[i-1][j-1];
    		    如果 p[j] == '*'
    		    分两种情况:
    		    1: 如果p[j-1] != str[i] && p[j-1] != '.', 此时dp[i][j] = dp[i][j-2] //*前面字符匹配0次
    		    2: 如果p[j-1] == str[i] || p[j-1] == '.'
    		        此时dp[i][j] = dp[i][j-2] // *前面字符匹配0次
    		        或者 dp[i][j] = dp[i][j-1] // *前面字符匹配1次
    		        或者 dp[i][j] = dp[i-1][j] // *前面字符匹配多次
        */
    	boolean dp[][] = new boolean[s.length()+1][p.length()+1];
    	dp[0][0] = true;
    	for(int i=1; i<=p.length(); i++){ // aab    .*aab  a*aab
    		if(p.charAt(i-1)=='*')
    			dp[0][i] = dp[0][i-2];
    	}
    	for(int i=0; i<s.length(); i++){
    		char sch = s.charAt(i);
    		for(int j=0; j<p.length(); j++){
    			char pch = p.charAt(j);
    			if(sch == pch || pch == '.'){  //是否需要考虑一下 aab aa*ab   //可能会有aab .*aab的情况，但是不需要在这时候考虑，会在*的时候考虑
    				dp[i+1][j+1] = dp[i][j];
    			}
    			else if(pch == '*'){
    				if(j>0 && p.charAt(j-1) != '.' && sch != p.charAt(j-1)){// aab   c*aab情况
    					dp[i+1][j+1] = dp[i+1][j-1];          
    				}
    				else{
    					dp[i+1][j+1] = dp[i+1][j-1] || dp[i+1][j] || dp[i][j+1];
    				}
    			}
    			
    		}
    	}
    	return dp[s.length()][p.length()];
    }
}
