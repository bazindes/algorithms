package com.baz.app.facebook.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithAtMostKDistinctCharacters {

    /**
     * Given a string, find the length of the longest substring T that contains at most k distinct characters.
     *
     * Example 1:
     *
     * Input: s = "eceba", k = 2
     * Output: 3
     * Explanation: T is "ece" which its length is 3.
     * Example 2:
     *
     * Input: s = "aa", k = 1
     * Output: 2
     * Explanation: T is "aa" which its length is 2.
     */

    //two pointers O(n) O(n)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // corner case
        if(s == null || "".equals(s) || k == 0) return 0;
        if(k > s.length()) return s.length();

        // ans keep tracking max length
        int ans = 0;
        // map keep tracking two things
        // key is character
        // value is key's frequency
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()){
            char cur = s.charAt(right);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            right ++;
            if(map.size() <= k)
                ans = Math.max(ans, right - left);
            while (left < s.length() && map.size() > k){
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) - 1);
                    if(map.get(temp) < 1)
                        map.remove(temp);
                }
                left ++;
            }
        }

        return ans;
    }

    public void test(){
        String s = "eceba";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
        s = "aa";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
        System.out.println(lengthOfLongestSubstringKDistinct(s, 1));
        s = "abaccc";
        System.out.println(lengthOfLongestSubstringKDistinct(s, 2));
    }

}
