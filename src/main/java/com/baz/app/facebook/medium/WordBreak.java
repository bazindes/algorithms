package com.baz.app.facebook.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    /**
     * MY recursive solution, failed on it has to be in order to check the wordDict,
     * */
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || "".equals(s)) return true;
        char[] cs = s.toCharArray();
        return helper(cs, wordDict, 0);
    }

    private boolean helper(char[] cs, List<String> wd, int start){
        if(start > cs.length - 1) return true;
        out : for(String d : wd){
            if(d.length() <= cs.length - start){
                for (int i = 0; i < d.length(); i++) {
                    if(d.charAt(i) != cs[i + start]){
                        continue out;
                    }
                }
                return helper(cs, wd, start + d.length());
            }else {
                continue;
            }
        }
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
        System.out.println(wordBreakDP(s, wordDict));
        s = "applepenapple";
        wordDict = Arrays.asList(new String[]{"apple", "pen"});
        System.out.println(wordBreakDP(s, wordDict));
        s = "catsandog";
        wordDict = Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"});
        System.out.println(wordBreakDP(s, wordDict));
        s = "leetcode";
        wordDict = Arrays.asList(new String[]{"apple", "pen"});
        System.out.println(wordBreakDP(s, wordDict));
    }

}
