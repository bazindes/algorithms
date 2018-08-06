package com.baz.app.facebook.medium;

import com.baz.app.util.TreeNode;

public class AddAndSearchWord {

    private class TrieNode{
        String name = "";
        TrieNode[] children = new TrieNode[26];
    }

    private TrieNode node = new TrieNode();

    public void addWord(String word){
        if(word == null || "".equals(word)) return;
        char[] cs = word.toCharArray();
        TrieNode cur = node;
        for (char c : cs){
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
