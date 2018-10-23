package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class DecodeWays implements Facebook {

    /**
     * A message containing letters from A-Z is being encoded to numbers using the following mapping:
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * Given a non-empty string containing only digits, determine the total number of ways to decode it.
     * Example 1:
     * Input: "12"
     * Output: 2
     * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
     * Example 2:
     * Input: "226"
     * Output: 3
     * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
     */

    //DP O(n) O(1)
    public int numDecodingways(String s){
        if( "".equals(s)) return 1;
        int len = s.length();
        // pre indicates how many ways we've already have
        int pre = 1;
        // cur indicates, at current position, how many ways we can decode the string
        int cur = s.charAt(0) == '0' ? 0 : 1;
        // temporary storage
        int temp;
        for (int i = 1; i < len && cur != 0; i++) {
            // temporary store cur for prev pointer
            temp = cur;
            // check the situation that we can decode current string in different ways
            if(s.charAt( i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6')){
                // only one, same with previous
                if(s.charAt(i) == '0'){
                    cur = pre;
                // otherwise, add them up
                }else {
                    cur += pre;
                }
            // 00, 30, 40, ..., 90, these numbers can't be decode
            }else if(s.charAt(i) == '0'){
                cur = 0;
            }
            // set prev pointer to current
            pre = temp;
        }

        return cur;
    }

    //DP solution O(n) O(n)
    public int numDecodings(String s) {
        int num = s.length();
        if(num == 0) return 0;

        int[] m = new int[num + 1];
        m[num] = 1;
        m[num - 1] = s.charAt(num - 1) != '0' ? 1:0;

        for (int i = num - 2; i > -1; i--) {
            if(s.charAt(i) == '0') continue;
            else
                m[i] = Integer.parseInt(s.charAt(i) + "" + s.charAt(i + 1)) <= 26 ? m[i+1] + m[i+2] : m[i+1];
        }

        return m[0];
    }

    public int numDecodingDP(String s){
        if(s == null || "".equals(s)) return 0;

        int len = s.length();
        int[]cs = new int[len + 1];
        cs[0] = 1;
        cs[1] = s.charAt(0) == '0'? 0:1;

        for (int i = 2; i <= len; i++) {
            int fst = Integer.parseInt(s.substring(i-1, i));
            int sec = Integer.parseInt(s.substring(i-2, i));
            if(fst <= 9 && fst >= 1){
                cs[i] += cs[i - 1];
            }
            if(sec <= 26 && sec >= 10){
                cs[i] += cs[i - 2];
            }
        }

        return cs[len];
    }

    public void test(){
        String s = "2300111";
        System.out.println(numDecodings(s));
        System.out.println(numDecodingways(s));
        s= "226";
        System.out.println(numDecodings(s));
        System.out.println(numDecodingways(s));
    }
}
