package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class WordSearch implements Facebook {

    /**
     * Given a 2D board and a word, find if the word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
     * The same letter cell may not be used more than once.
     * Example:
     * board =
     * [
     *   ['A','B','C','E'],
     *   ['S','F','C','S'],
     *   ['A','D','E','E']
     * ]
     *
     * Given word = "ABCCED", return true.
     * Given word = "SEE", return true.
     * Given word = "ABCB", return false.
     */

    public boolean exist(char[][] board, String word) {
        if(word == null || "".equals(word)) return true;
        char[]cs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(helper(board, cs, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][]board, char[] cs, int index, int i, int j){
        if(index == cs.length){
            return true;
        }
        if(i < 0 || i == board.length || j < 0 || j == board[0].length){
            return false;
        }
        if(board[i][j] != cs[index]){
            return false;
        }

        board[i][j] ^= 256;
        boolean mark = helper(board, cs, index + 1, i - 1, j)
                || helper(board, cs, index + 1, i + 1, j)
                || helper(board, cs, index + 1, i,j - 1)
                || helper(board, cs, index + 1, i, j + 1);
        board[i][j] ^= 256;
        return mark;
    }

    //2
    static boolean[][] visited;
    public boolean exist2(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)){
            return true;
        }

        visited[i][j] = false;
        return false;
    }


    public void test(){
       char[][] board = {
               {'A','B','C','E'},
               {'S','F','C','S'},
               {'A','D','E','E'}
       };
        System.out.println(exist(board, "ABCCED"));
        System.out.println(exist(board, "SEE"));
        System.out.println(exist(board, "ABCB"));
    }

}
