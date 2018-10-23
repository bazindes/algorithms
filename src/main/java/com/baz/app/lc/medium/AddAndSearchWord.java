package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.TreeNode;

public class AddAndSearchWord implements Facebook {

    /**
     * Design a data structure that supports the following two operations:
     *
     * void addWord(word)
     * bool search(word)
     * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
     *
     * Example:
     *
     * addWord("bad")
     * addWord("dad")
     * addWord("mad")
     * search("pad") -> false
     * search("bad") -> true
     * search(".ad") -> true
     * search("b..") -> true
     * Note:
     * You may assume that all words are consist of lowercase letters a-z.
     */

    // define TrieNode
    private class TrieNode{
        // name != "" indicates current word is in Trie
        String name = "";
        //only lowercase letters, otherwise larger
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode node = new TrieNode();

    // add new word O(l)
    public void addWord(String word){
        //corner case
        if(word == null || "".equals(word)) return;

        char[] cs = word.toCharArray();
        // runner pointer
        TrieNode cur = node;
        // searching for end
        for (char c : cs){
            if(cur.children[c-'a'] == null)
                cur.children[c - 'a'] = new TrieNode();
            cur = cur.children[c - 'a'];
        }
        cur.name = word;
    }

    public boolean search(String word){
        char[]cs = word.toCharArray();
        return helper(cs, 0, node);
    }

    public boolean helper(char[]cs, int index, TrieNode node){
        if(index == cs.length) return !"".equals(node.name);
        if('.' == cs[index]){
            for (int i = 0; i < node.children.length; i++) {
                if(node.children[i] != null){
                    return helper(cs, index + 1, node.children[i]);
                }
            }
        }else {
            return node.children[cs[index] - 'a'] != null && helper(cs, index + 1, node.children[cs[index] - 'a']);
        }
        return false;
    }


    /**
     * follow up是虽然这个已经是optimal的⽅法，有没有可能让search更快⼀点，表
     * 示在insert的时候就把“.”也当做⼀个node加进去，⽐如如果insert “cat”, 那么第⼀
     * 层就是 “c”,".",第⼆层是“a”,"." | "a","."
     */


    public void test(AddAndSearchWord addAndSearchWord){
        addAndSearchWord.addWord("bad");
        addAndSearchWord.addWord("dad");
        addAndSearchWord.addWord("mad");

        System.out.println(addAndSearchWord.search("pad"));
        System.out.println(addAndSearchWord.search("bad"));
        System.out.println(addAndSearchWord.search(".ad"));
        System.out.println(addAndSearchWord.search("b.."));
    }
}
