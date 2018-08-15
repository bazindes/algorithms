package com.baz.app.util;

public class Trie {

    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(!node.containsKey(cur)){
                node.setLinks(cur, new TrieNode());
            }
            node = node.getlinks(cur);
        }
        node.setEnd(true);
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if(node.containsKey(cur)){
                node = node.getlinks(cur);
            }else{
                return null;
            }
        }
        return node;
    }

    public boolean search(String word){
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startsWith(String word){
        return searchPrefix(word) != null;
    }

}
