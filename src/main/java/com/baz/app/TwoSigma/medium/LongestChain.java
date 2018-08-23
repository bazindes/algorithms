package com.baz.app.TwoSigma.medium;

import java.util.*;

public class LongestChain {

    /**
     * "Problem Statement
     * You are given a library with n words (w[0], w[1], ...,w[n-1]).
     * You choose a word from it, and in each step, remove one letter from this word only if doing so yields another word in the library.
     * What is the longest possible chain of these removal steps?
     * Constraints:
     * 1 <= n <= 50000
     * 1 <= the length of each string in w <= 50
     * Each string is composed of lowercase ascii letters only
     * The function should take in an array of strings w as its argument and should return
     * a single integer representing the length of the longest chain of character removals possible.
     * Example input/output
     * a
     * b
     * ba
     * bca
     * bda
     * bdca
     * Calling the function on the input above should output 4. The longest possible chain is ""bdca"" -> ""bca"" -> ""ba"" -> ""a""."
     */


    public int longestChain(String[] words){
        int ans = Integer.MIN_VALUE;
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String str1, String str2) {
                return str1.length()-str2.length();
            }
        });
        Map<String , Integer> map = new HashMap<>();
        for(String s : words){
            if(map.containsKey(s)) continue;
            map.put(s, 1);
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                if(map.containsKey(sb.toString()) && map.get(sb.toString()) + 1 > map.get(s)){
                    map.put(s, map.get(sb.toString()) + 1);
                }
            }
            if(map.get(s) > ans)
                ans = map.get(s);
        }

        return ans;
    }

    public void test(){
        String[] chain = {
                "a",
                "b",
                "ba",
                "bca",
                "bda",
                "bdca"
        };
        System.out.println(longestChain(chain));
    }
}
