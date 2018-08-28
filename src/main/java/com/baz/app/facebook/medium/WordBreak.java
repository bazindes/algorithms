package com.baz.app.facebook.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
     * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
     * Note:
     * The same word in the dictionary may be reused multiple times in the segmentation.
     * You may assume the dictionary does not contain duplicate words.
     * Example 1:
     * Input: s = "leetcode", wordDict = ["leet", "code"]
     * Output: true
     * Explanation: Return true because "leetcode" can be segmented as "leet code".
     * Example 2:
     * Input: s = "applepenapple", wordDict = ["apple", "pen"]
     * Output: true
     * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
     *              Note that you are allowed to reuse a dictionary word.
     * Example 3:
     * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
     * Output: false
     */

    /**
     * MY solution
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || "".equals(s)) return true;
        Set<String> dict = new HashSet<>(wordDict);
        Set<Integer> set = new HashSet<>();
        return dfsHelper(s, 0, dict, set);
    }

    private boolean dfsHelper(String s, int index, Set<String> dict, Set<Integer> set){
        if(index == s.length()) return true;
        if(set.contains(index)) return false;

        for (int i = index + 1; i <= s.length(); i++) {
            String cur = s.substring(index, i);

            if(dict.contains(cur)){
                if(dfsHelper(s, i, dict, set))
                    return true;
                else
                    set.add(i);
            }
        }

        set.add(index);
        return false;
    }

    /**
     * DP solution
     * */
    public boolean wordBreakDP(String s, List<String> wordDict) {
        if(s == null || "".equals(s)) return true;
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] bs = new boolean[s.length() + 1];
        bs[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if(bs[j] && dict.contains(s.substring(j, i))){
                    bs[i] = true;
                    break;
                }
            }
        }

        return bs[s.length()];
    }

    public void test(){
        String s = "leetcode";
        List<String> wordDict = Arrays.asList(new String[]{"leet", "code"});
        System.out.println(wordBreak(s, wordDict));
        s = "applepenapple";
        wordDict = Arrays.asList(new String[]{"apple", "pen"});
        System.out.println(wordBreak(s, wordDict));
        s = "catsandog";
        wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        System.out.println(wordBreak(s, wordDict));
        s = "aaaaaaa";
        wordDict = Arrays.asList(new String[]{"aaaa", "aaa"});
        System.out.println(wordBreak(s, wordDict));
    }

}
