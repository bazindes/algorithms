package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDC implements Facebook {

    /**
     * Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
     *
     * Example 1:
     *
     * Input: "eceba"
     * Output: 3
     * Explanation: t is "ece" which its length is 3.
     * Example 2:
     *
     * Input: "ccaabbb"
     * Output: 5
     * Explanation: t is "aabbb" which its length is 5.
     */

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // corner case
        if(s == null || "".equals(s)) return 0;
        if(s.length() < 3) return s.length();
        // ans keep tracking max length
        int ans = 0;
        // map keep tracking two things
        // key is character
        // value is key's frequency
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        while (right < s.length()){
            // current char
            char cur = s.charAt(right);
            // keep tracking how many chars between two pointers
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // move forward
            right ++;
            // check if current window contains at most k distinct chars, keep tracking max length
            if(map.size() <= 2)
                ans = Math.max(ans, right - left);

            // otherwise we need to move left pointer in order to let map at most contains k distinct chars
            while (left < s.length() && map.size() > 2){
                // find left most char
                char temp = s.charAt(left);
                if(map.containsKey(temp)){
                    // update map
                    map.put(temp, map.get(temp) - 1);
                    // if it's frequency less than 1, means that current window does not contains temp char now
                    // so we remove it
                    if(map.get(temp) < 1)
                        map.remove(temp);
                }
                // move forward
                left ++;
            }
        }

        return ans;
    }

}
