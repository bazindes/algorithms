package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.Interface.google.Google;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInAString implements Facebook, Google {

    /**
     * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
     *
     * Examples:
     * s = "leetcode"
     * return 0.
     *
     * s = "loveleetcode",
     * return 2.
     * Note: You may assume the string contain only lowercase letters.
     */

    // O(n) O(1)
    public int firstUniqChar(String s) {
        int first = s.length();
        int idx = 0;
        for(char c = 'a'; c <= 'z'; c++){
            idx = s.indexOf(c);
            // contain current char and only one
            if(idx != -1 && idx == s.lastIndexOf(c)){
                first = Math.min(first, idx);
            }
        }
        return first == s.length() ? -1 : first;
    }

    // O(n) O(n)
    public int firstUniqCharMap(String s) {
        int num = Integer.MAX_VALUE;
        if(s == null || "".equals(s)) return -1;
        Map<Character , Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i) ,  map.get(s.charAt(i)) + s.length());
            }else
                map.put(s.charAt(i) , i);
        }
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if(val < s.length()){
                num = Math.min(num , val);
            };
        }
        if(num == Integer.MAX_VALUE) num = -1;
        return num;
    }

}
