package com.baz.app.facebook.medium;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.
     *
     * Example 1:
     *
     * Input: "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", which the length is 3.
     * Example 2:
     *
     * Input: "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     *
     * Input: "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
     */

    //O(2n) O(n)
    public int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)) return 0;
        Set<Character> set = new HashSet<>();
        int ans = 0;
        int i = 0;
        int j = 0;
        while (i < s.length() && j < s.length()) {
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                ans = Math.max(ans, j - i + 1);
                j ++;
            }else {
                set.remove(s.charAt(i));
                i ++;
            }
        }
        return ans;
    }

    //O(n) O(n)
    public int lengthOfLongestSubstringOnePass(String s){
        if(s == null || "".equals(s)) return 0;
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int i = 0;
        int ans = 0;
        for (int j = 0; j < len; j++) {
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)) , i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j) , j + 1);
        }

        return ans;
    }

    public void test(){
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstringOnePass(s));
        s = "bbbbb";
        System.out.println(lengthOfLongestSubstringOnePass(s));
        s = "pwwkew";
        System.out.println(lengthOfLongestSubstringOnePass(s));

    }

}
