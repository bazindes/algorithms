package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class OneEditDistance implements Facebook {

    /**
     * Given two strings s and t, determine if they are both one edit distance apart.
     *
     * Note:
     * There are 3 possiblities to satisify one edit distance apart:
     *
     *     Insert a character into s to get t
     *     Delete a character from s to get t
     *     Replace a character of s to get t
     *
     * Example 1:
     * Input: s = "ab", t = "acb"
     * Output: true
     * Explanation: We can insert 'c' into s to get t.
     *
     * Example 2:
     * Input: s = "cab", t = "ad"
     * Output: false
     * Explanation: We cannot get t from s by only one step.
     *
     * Example 3:
     * Input: s = "1203", t = "1213"
     * Output: true
     * Explanation: We can replace '0' with '1' to get t.
     */


        /*
     * There're 3 possibilities to satisfy one edit distance apart:
     *
     * 1) Replace 1 char:
          s: a B c
          t: a D c
     * 2) Delete 1 char from s:
          s: a D  b c
          t: a    b c
     * 3) Delete 1 char from t
          s: a   b c
          t: a D b c
     */
    public boolean isOneEditDistance(String s, String t) {
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length()) // s has the same length as t, so the only possibility is replacing one char in s and t
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length()) // t is longer than s, so the only possibility is deleting one char from t
                    return s.substring(i).equals(t.substring(i + 1));
                else // s is longer than t, so the only possibility is deleting one char from s
                    return t.substring(i).equals(s.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(s.length() - t.length()) == 1;
    }

    // O(n) O(1)
    public boolean isOneEditDistanceTP(String s, String t) {
        if (s == null || s.length() == 0) {
            return t.length() == 1;
        }
        if (t == null || t.length() == 0) {
            return s.length() == 1;
        }
        int m = s.length();
        int n = t.length();
        if (Math.abs(m - n) > 1) {
            return false;
        }
        int p1 = 0;
        int p2 = 0;
        int count = 0;
        while (p1 < m && p2 < n) {
            if (s.charAt(p1) == t.charAt(p2)) {
                p1++;
                p2++;
            } else {
                count++;
                if (count > 1) {
                    return false;
                }
                if (m == n) {
                    p1++;
                    p2++;
                } else if (m > n) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }
        count += m - p1 + n - p2;
        return count == 1;
    }

    //O(n) O(1)
    public boolean isOneEditDistance3(String s, String t) {
        // corner case
        if(s == null && t == null) return false;
        // three cases
        // 1. length diff more than 1, false
        if(Math.abs(s.length()-t.length()) > 1) return false;
        // 2. length diff by 0, so change one char to be equal
        if(s.length() == t.length()) return isOneModify(s,t);
        // 3. length diff by 1, so delete one char from longer one
        if(s.length() > t.length()) return isOneDel(s,t);
        // ensure s.len > t.len
        return isOneDel(t,s);
    }

    public boolean isOneDel(String s,String t){
        // i indicates index of diff char
        int i = 0;
        for(; i < t.length(); i++){
            // if found, check rest substrings are equal or not
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(i + 1).equals(t.substring(i));
            }
        }
        // no diff, return true
        return true;
    }

    public boolean isOneModify(String s,String t){
        // diff indicates how many diff char between s and t
        int diff = 0;
        for(int i = 0; i < s.length(); i++){
            // find one and increase diff
            if(s.charAt(i) != t.charAt(i))
                diff++;
        }
        return diff == 1;
    }


}
