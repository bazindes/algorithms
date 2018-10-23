package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class ReverseWrodsInAString implements Facebook {

    /**
     * Given an input string, reverse the string word by word.
     *
     * Example:
     *
     * Input: "the sky is blue",
     * Output: "blue is sky the".
     * Note:
     *
     * A word is defined as a sequence of non-space characters.
     * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
     * You need to reduce multiple spaces between two words to a single space in the reversed string.
     * Follow up: For C programmers, try to solve it in-place in O(1) space.
     */

    public String reverseWords(String s) {
        String[] cs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = cs.length - 1; i >= 0 ; i--) {
            if("".equals(cs[i])) continue;
            sb.append(cs[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public void test(){
        String s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

}
