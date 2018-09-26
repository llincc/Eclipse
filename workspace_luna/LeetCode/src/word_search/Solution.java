package word_search;
/*ÌâÄ¿ÃèÊö

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word ="ABCCED", -> returnstrue,
word ="SEE", -> returnstrue,
word ="ABCB", -> returnsfalse.*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        char words[] = word.toCharArray();
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
            	if(search(board, words, i, j, 0)){
            		return true;
            	}
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, char[] words,  int i, int j, int cur){
    	if(board[i][j] == words[cur]){
    	    if(cur == words.length-1) return true;
    	    char curch = words[cur];
    	    board[i][j] = ' ';
    	    if(i>0 ){
    	    	if(search(board, words, i-1, j, cur+1)) return true;
    	    }
    	    if(j>0 ){
    	    	if(search(board, words, i, j-1, cur+1)) return true;
    	    }
    	    if(i<board.length-1){
    	    	if(search(board, words, i+1, j, cur+1)) return true;
    	    }
    	    if(j<board[0].length-1){
    	    	if(search(board, words, i, j+1, cur+1)) return true;
    	    }
    	    board[i][j] = curch;
    	}
    	return false;
    }
    public static void main(String[] args) {
		char board[][] = {{'a','a'}};
		String word = "aa";
		System.out.println(new Solution().exist(board, word));
	}
}
