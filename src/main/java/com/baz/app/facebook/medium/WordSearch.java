package com.baz.app.facebook.medium;

public class WordSearch {

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
        boolean mark = helper(board, cs, index + 1, i - 1, j) || helper(board, cs, index + 1, i + 1, j) || helper(board, cs, index + 1, i,j - 1) || helper(board, cs, index + 1, i, j + 1);
        board[i][j] ^= 256;
        return mark;
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
