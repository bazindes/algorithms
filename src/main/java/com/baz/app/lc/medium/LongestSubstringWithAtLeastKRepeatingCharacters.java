package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtLeastKRepeatingCharacters implements Facebook {

    /**
     * Find the length of the longest substring T of a given string (consists of lowercase letters only)
     *  such that every character in T appears no less than k times.
     * Example 1:
     * Input:
     * s = "aaabb", k = 3
     * Output:
     * 3
     * The longest substring is "aaa", as 'a' is repeated 3 times.
     * Example 2:
     * Input:
     * s = "ababbc", k = 2
     * Output:
     * 5
     * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
     */

    // D&C O(nlogn) O(n)
    public int longestSubstring(String s, int k) {
        if(s == null || "".equals(s)) return 0;
        if(k == 0) return s.length();
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    private int helper(char[] cs, int start, int end, int k){
        if(end - start < k) return 0;
        int[] count = new int[26];
        for (int i = start; i < end; i++) {
            count[cs[i] - 'a'] ++;
        }

        for (int i = start; i < end; i++) {
            if(count[cs[i] - 'a'] > 0 && count[cs[i] - 'a'] < k){
                int left = helper(cs, start, i, k);
                int right = helper(cs, i + 1, end, k);
                return Math.max(left, right);
            }
        }
        return end - start;
    }

}
