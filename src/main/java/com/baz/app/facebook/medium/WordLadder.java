package com.baz.app.facebook.medium;

import java.util.List;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        for (int i = 0; i < wordList.size(); i++) {
            if(endWord.equals(wordList.get(i))){
                ans ++;
                break;
            }
        }
        if(ans == 0) return ans;
        return ans;
    }

    public void test(){

    }

}
