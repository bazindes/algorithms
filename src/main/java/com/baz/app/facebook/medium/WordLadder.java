package com.baz.app.facebook.medium;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int ans = 0;
        Set<String> dict = new HashSet<>();
        for (String s : wordList) dict.add(s);
        if(!dict.contains(endWord)) return ans;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        ans = 1;
        int len = beginWord.length();
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> temp;
            if(beginSet.size() > endSet.size()){
                temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            temp = new HashSet<>();
            for (String bw : beginSet){
                char[] cs = bw.toCharArray();
                for (int i = 0; i < cs.length; i++) {
                    for (char j = 'a'; j <= 'z'; j++) {
                        char old = cs[i];
                        cs[i] = j;
                        String tar = new String(cs);

                        if (endSet.contains(tar))
                            return ans + 1;
                        if(!visited.contains(tar) && dict.contains(tar)){
                            visited.add(tar);
                            temp.add(tar);
                        }
                        cs[i] = old;
                    }
                }
            }

            beginSet = temp;
            ans ++;
        }

        return 0;
    }

    public void test(){

    }

}
