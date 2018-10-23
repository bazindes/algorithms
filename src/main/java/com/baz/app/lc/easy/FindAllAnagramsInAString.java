package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class FindAllAnagramsInAString implements Facebook {

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

    // sliding window (two pointers) O(N) O(N)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s == null || "".equals(s) || p == null || "".equals(p) || p.length() > s.length()) return ans;
        // use map to track chars in p
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            // key is distinct char, value is times of current char appears
            map.put(p.charAt(i) , map.getOrDefault(p.charAt(i) , 0) + 1);
        }

        int len = p.length();
        // two pointers indicate window's left boundary and right boundary
        int left = 0;
        int right = 0;
        // counter indicates whether our window contains all chars or not
        int counter = map.size();

        while (right < s.length()){
            // pick out current char
            char cur = s.charAt(right);
            // check whether cur in map or not, if in, we find one so decrease counter
            if(map.containsKey(cur)){
                // update map
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0)
                    counter --;
            }
            // move right boundary of window forward
            right ++;

            // when counter equals to 0, it means that we have all chars in p in our current window,
            // then we'll try to make the window smaller by moving left pointer
            while (counter == 0){
                // check whether the char to remove is in map or not, if in, we need to increase counter
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    // update map
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0)
                        counter ++;
                }
                // check whether there is an answer before increase left
                if(right - left == len) ans.add(left);
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
