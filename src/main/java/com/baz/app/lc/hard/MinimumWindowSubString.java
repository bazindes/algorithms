package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashMap;
import java.util.Map;



public class MinimumWindowSubString implements Facebook {
    /**
     * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
     *
     * Example:
     *
     * Input: S = "ADOBECODEBANC", T = "ABC"
     * Output: "BANC"
     * Note:
     *
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
     */

    //two pointer O(n) O(n)
    public String minWindow(String s, String t) {
        // use map to track: for each distinct char in t, what are they and how many times they appeared in t
        // key is the char, value is frequency
        Map<Character , Integer> toFind = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            toFind.put(t.charAt(i), toFind.getOrDefault(t.charAt(i) , 0) + 1);
        }

        // left: the starting index of result String
        int left = 0;
        // len: the length of result String
        int len = Integer.MAX_VALUE;
        // count: how many chars we've already find both in s and t
        int count = 0;
        // i: left boundary, j: right boundary
        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            // pick out one char from s
            char cur = s.charAt(j);
            // check whether current char is in t
            if(toFind.containsKey(cur)){
                // update toFind map
                toFind.put(cur, toFind.get(cur) - 1);
                // after update, if val >= 0 means that, previously, we need to remove at least one of current char
                // so we increase count by 1
                if(toFind.get(cur) >= 0){
                    count ++;
                }
                // then, we need to check, if the count equals to length of t, means we've already found all of characters in t
                // move left pointer in order to find minimum
                while (i < j && count == t.length()){
                    // check if current substring is shorter or not
                    if(j - i + 1 < len){
                        // update len and left
                        len = j - i + 1;
                        left = i;
                    }

                    // then, move left pointer to right in order to find minimum len
                    char temp = s.charAt(i);
                    if(toFind.containsKey(temp)){
                        toFind.put(temp , toFind.get(temp) + 1);
                        // means we need find another char which is same with temp
                        if(toFind.get(temp) > 0){
                            count --;
                        }
                    }
                    // move left pointer
                    i ++;
                }
            }
        }

        // check corner case
        if (len > s.length()){
            return "";
        }

        return s.substring(left, left + len);
    }

    /**
     * follow up
     * 如果允许⼀个字⺟不⼀样
     * str1 = acedbg, str2 = xcbe，那么返回cedb
     *
     * thought: while(i < j && count + 1 == t.length())
     * corner case: if two characters are adjacent, neighbor to each other, so, we can take either left neighbor or right neighbor
     * left -- or len ++
     */




    public void test(){
        String S = "ADOBECODEBSANC", T = "ABC";
        System.out.println(minWindow(S , T));
    }

}
