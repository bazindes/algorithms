package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Trie;

public class ImplementTrie implements Facebook {

    public void test(){
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app"));        // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
