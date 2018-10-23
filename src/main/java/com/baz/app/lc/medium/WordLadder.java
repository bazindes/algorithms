package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder implements Facebook {

    /**
     *Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    //Time complexity for one directional graph traversal = (n26)^d
    //Time complexity for one directional graph traversal = (n26)^d/2
    //n is the length of the word and d is the depth of the graph
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
