package com.baz.app.facebook.hard;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {

    /**
     * Given a 2D board and a list of words from the dictionary, find all words in the board.
     * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     *
     * Example:
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

    //O(nm) O(nm)
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        Trie trie = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                dfsHelper(board, i, j, trie, ans);
            }
        }

        return ans;
    }

    private void dfsHelper(char[][] board, int i, int j, Trie trie, List<String> ans){
        char c = board[i][j];
        if(c == '#' || trie.next[c - 'a'] == null) return;
        trie = trie.next[c - 'a'];
        if(trie.word != null){
            ans.add(trie.word);
            trie.word = null;
        }

        board[i][j] = '#';
        if(i > 0) dfsHelper(board, i - 1, j, trie, ans);
        if(i < board.length - 1) dfsHelper(board, i + 1, j, trie, ans);
        if(j > 0) dfsHelper(board, i, j - 1, trie, ans);
        if(j < board[0].length - 1) dfsHelper(board, i, j + 1, trie, ans);

        board[i][j] = c;
    }

    private Trie buildTrie(String[] words){
        Trie trie = new Trie();
        for (String word : words){
            Trie p = trie;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if(p.next[c - 'a'] == null)
                    p.next[c - 'a'] = new Trie();
                p = p.next[c - 'a'];
            }
            p.word = word;
        }
        return trie;
    }

    class Trie{
        String word;
        Trie[] next = new Trie[26];
    }


}
