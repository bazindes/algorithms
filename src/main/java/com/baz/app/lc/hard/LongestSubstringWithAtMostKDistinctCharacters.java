package com.baz.app.lc.hard;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters implements Facebook {

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
            // current char
            char cur = s.charAt(right);
            // keep tracking how many chars between two pointers
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            // move forward
            right ++;
            // check if current window contains at most k distinct chars, keep tracking max length
            if(map.size() <= k)
                ans = Math.max(ans, right - left);

            // otherwise we need to move left pointer in order to let map at most contains k distinct chars
            while (left < s.length() && map.size() > k){
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

    /**
     * 变型：⼤概就是给⼀个bool数组e.g. [F,T,F,T,T,F,T,T,T,F]，你有k个把F变成T的机
     * 会，怎样变才能使某⼀节（连续）T⻓度最⻓。
     * (487 Max Consecutive Ones II)
     */

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
