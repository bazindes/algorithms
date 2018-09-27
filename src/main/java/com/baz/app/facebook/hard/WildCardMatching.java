package com.baz.app.facebook.hard;

public class WildCardMatching {

    /**
     * Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.
     * '?' Matches any single character.
     * '*' Matches any sequence of characters (including the empty sequence).
     * The matching should cover the entire input string (not partial).
     *
     * Note:
     * s could be empty and contains only lowercase letters a-z.
     * p could be empty and contains only lowercase letters a-z, and characters like ? or *.
     * Example 1:
     * Input:
     * s = "aa"
     * p = "a"
     * Output: false
     * Explanation: "a" does not match the entire string "aa".
     * Example 2:
     * Input:
     * s = "aa"
     * p = "*"
     * Output: true
     * Explanation: '*' matches any sequence.
     * Example 3:
     * Input:
     * s = "cb"
     * p = "?a"
     * Output: false
     * Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
     * Example 4:
     * Input:
     * s = "adceb"
     * p = "*a*b"
     * Output: true
     * Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
     * Example 5:
     * Input:
     * s = "acdcb"
     * p = "a*c?b"
     * Output: false
     */

    /**
     * The basic idea is to have one pointer for the string and one pointer for the pattern.
     * This algorithm iterates at most length(string) + length(pattern) times, for each iteration, at least one pointer advance one step.
     */
    //O(L+P)
    boolean comparison(String s, String p) {
        int si = 0, pi = 0, match = 0, starIdx = -1;
        while (si < s.length()){
            // advancing both pointers
            if (pi < p.length()  && (p.charAt(pi) == '?' || s.charAt(si) == p.charAt(pi))){
                si++;
                pi++;
            }
            // * found, only advancing pattern pointer
            else if (pi < p.length() && p.charAt(pi) == '*'){
                starIdx = pi;
                match = si;
                pi++;
            }
            // last pattern pointer was *, advancing string pointer
            else if (starIdx != -1){
                pi = starIdx + 1;
                match++;
                si = match;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else return false;
        }

        //check for remaining characters in pattern
        while (pi < p.length() && p.charAt(pi) == '*')
            pi++;

        return pi == p.length();
    }

}
