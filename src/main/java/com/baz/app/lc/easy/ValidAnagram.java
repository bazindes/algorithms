package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class ValidAnagram implements Facebook {

    /**
     * Given two strings s and t , write a function to determine if t is an anagram of s.
     * Example 1:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     * Note:
     * You may assume the string contains only lowercase alphabets.
     * Follow up:
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     */

    //O(n) O(1)
    public boolean isAnagram(String s, String t) {
        int[] str = new int[26];
        for(int i=0; i<s.length(); i++){
            str[s.charAt(i) - 'a'] ++;
        }
        for(int i=0; i<t.length(); i++){
            str[t.charAt(i) - 'a'] --;
        }
        for(int i=0; i<str.length; i++){
            if(str[i] != 0)
                return false;
        }
        return true;
    }

    public void test(){

    }

}
