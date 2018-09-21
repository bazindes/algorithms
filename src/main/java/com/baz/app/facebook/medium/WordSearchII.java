package com.baz.app.facebook.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class WordSearchII {

    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.
     *
     * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     *
     * Example:
     *
     * Input:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * Output: ["eat","oath"]
     * Note:
     * You may assume that all inputs are consist of lowercase letters a-z.
     */

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        out : for (String s : words){
            char[]cs = s.toCharArray();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if(cs[0] == board[i][j]){
                        if(bfsHelper(board, cs, new int[]{i, j}, 0)){
                            ans.add(s);
                            continue out;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private boolean bfsHelper(char[][] board, char[] word, int[] pos, int n){
        if(n == word.length || pos[0] == board.length || pos[1] == board[0].length)
            return false;

        if(board[pos[0]][pos[1]] == word[n]){
            if(n + 1 == word.length) return true;
            return bfsHelper(board, word, new int[]{pos[0] + 1, pos[1]}, n + 1)
                || bfsHelper(board, word, new int[]{pos[0] - 1, pos[1]}, n + 1)
                || bfsHelper(board, word, new int[]{pos[0], pos[1] + 1}, n + 1)
                || bfsHelper(board, word, new int[]{pos[0], pos[1] - 1}, n + 1);
        }

        return false;
    }


    public void test(){
        char[][] m = {
                  {'o','a','a','n'},
                  {'e','t','a','e'},
                  {'i','h','k','r'},
                  {'i','f','l','v'}
                };
        String[] words = {"oath","pea","eat","rain"};
        findWords(m , words).forEach(System.out::println);
    }

}
