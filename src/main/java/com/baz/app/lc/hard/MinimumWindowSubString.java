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

        if(s == null || t == null || "".equals(s) || "".equals(t)) return "";
        // use map to track: for each distinct char in t, what are they and how many times they appeared in t
        // key is the char, value is frequency
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i) , map.getOrDefault(t.charAt(i) , 0) + 1);
        }

        // left: the starting index of result String
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) >= 0){
                    count ++;
                }

                while(count == t.length()){
                    char temp = s.charAt(left);
                    if(i - left + 1 < minLen){
                        minLeft = left;
                        minLen = i - left + 1;
                    }
                    if(map.containsKey(temp)){
                        map.put(temp, map.get(temp) + 1);
                        if(map.get(temp) > 0){
                            count --;
                        }
                    }
                    left ++;
                }
            }
        }

        if(minLen > s.length())
            return "";
        return s.substring(minLeft , minLen + minLeft);
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
