package com.baz.app.facebook.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PermutationInString {

    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1. In other words, one of the first string's permutations is the substring of the second string.
     * Example 1:
     * Input:s1 = "ab" s2 = "eidbaooo"
     * Output:True
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Example 2:
     * Input:s1= "ab" s2 = "eidboaoo"
     * Output: False
     * Note:
     * The input strings only contain lower case letters.
     * The length of both given strings is in range [1, 10,000].
     */

    //O(n) O(n)
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || "".equals(s1)) return true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i) , map.getOrDefault(s1.charAt(i) , 0) + 1);
        }

        int left = 0;
        int right = 0;
        int len = map.size();

        while (right < s2.length()){
            char cur = s2.charAt(right);
            if(map.containsKey(cur)){
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) == 0)
                    len --;
            }
            right ++;
            while (len == 0){
                if(right - left == s1.length()) return true;
                char temp = s2.charAt(left);
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + 1);
                    if(map.get(temp) > 0)
                        len ++;
                }
                left ++;
            }
        }

        return false;
    }

    public void test(){
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaooo"));
    }

}
