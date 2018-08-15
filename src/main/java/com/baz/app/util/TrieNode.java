package com.baz.app.util;

public class TrieNode {

    private TrieNode[] links;

    private final int R = 26;

    private boolean end;

    public TrieNode(){
        links = new TrieNode[R];
        end = false;
    }

    public boolean isEnd(){
        return end;
    }

    public void setEnd(boolean end){
        this.end = end;
    }

    public void setLinks(char c, TrieNode node){
        links[c - 'a'] = node;
    }

    public TrieNode getlinks(char c){
        return links[c - 'a'];
    }

    public boolean containsKey(char c){
        return links[c - 'a'] != null;
    }

}
