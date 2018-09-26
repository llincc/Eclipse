package count_and_say;
/*ÌâÄ¿ÃèÊö

The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...   

1is read off as"one 1"or11.   1->11
11is read off as"two 1s"or21. 11->21
21is read off as"one 2, thenone 1"or1211.

Given an integer n, generate the n th sequence.

Note: The sequence of integers will be represented as a string.*/
public class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        return generate("1", 2, n);
    }
    private String generate(String base,int count, int n){	
    	char pre = base.charAt(0);
    	int preindex = 0;
    	StringBuilder sBuilder = new StringBuilder();
    	for(int i=1; i<base.length(); i++){
    		if(base.charAt(i) != pre){
    			sBuilder.append(i-preindex);
    			sBuilder.append(pre);
    			preindex = i;
    			pre = base.charAt(i);
    		}
    	}
    	sBuilder.append(base.length()-preindex);
    	sBuilder.append(pre);  	
    	if(count == n) return sBuilder.toString();
    	else return generate(sBuilder.toString(), count+1, n);
    }
    public static void main(String[] args) {
		System.out.println(new Solution().countAndSay(6));
	}
}
