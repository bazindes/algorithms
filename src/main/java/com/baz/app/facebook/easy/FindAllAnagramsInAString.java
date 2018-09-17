package com.baz.app.facebook.easy;

import java.util.*;

public class FindAllAnagramsInAString {

    /**
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     * The order of output does not matter.
     * Example 1:
     * Input:
     * s: "cbaebabacd" p: "abc"
     * Output:
     * [0, 6]
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     * Input:
     * s: "abab" p: "ab"
     * Output:
     * [0, 1, 2]
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || "".equals(s) || p == null || "".equals(p) || p.length() > s.length()) return ans;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            map.put(p.charAt(i) , map.getOrDefault(p.charAt(i) , 0) + 1);
        }
        int len = p.length();
        int left = 0;
        int right = 0;
        int counter = map.size();

        while (right < s.length()){
            char cur = s.charAt(right);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0)
                    counter --;
            }
            right ++;

            while (counter == 0){
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0){
                        counter ++;
                        if(right - left == len)
                            ans.add(left);
                    }
                }
                left ++;
            }
        }

        return ans;
    }

    public void test(){
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

}
